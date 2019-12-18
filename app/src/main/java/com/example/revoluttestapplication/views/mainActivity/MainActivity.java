package com.example.revoluttestapplication.views.mainActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.revoluttestapplication.R;
import com.example.revoluttestapplication.data.network.dataModels.CurrenciesApiResponseModel;
import com.example.revoluttestapplication.receivers.NetworkStateReceiver;
import com.example.revoluttestapplication.utils.CommonUtils;
import com.example.revoluttestapplication.viewHolders.CallBacks.CurrenciesOnClickListener;
import com.example.revoluttestapplication.viewHolders.CallBacks.FirstInputerTextChangeCallBack;
import com.example.revoluttestapplication.viewHolders.CurrenciesAdapter;
import com.example.revoluttestapplication.views.base.BaseActivity;
import com.github.angads25.toggle.interfaces.OnToggledListener;
import com.github.angads25.toggle.model.ToggleableView;
import com.github.angads25.toggle.widget.LabeledSwitch;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;
import com.jjoe64.graphview.series.OnDataPointTapListener;
import com.jjoe64.graphview.series.Series;
import com.wang.avi.AVLoadingIndicatorView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * main activity
 *
 * @author moeidheidari
 * @version 1.0
 */
public class MainActivity extends BaseActivity implements MainActivityMvpView, FirstInputerTextChangeCallBack, CurrenciesOnClickListener, OnToggledListener {

    //=======================================================================================================================
    // View binder
    @BindView(R.id.CurrensiesRecyclerView)
    RecyclerView CurrensiesRecyclerView;
    @BindView(R.id.NetworkStateLayout)
    RelativeLayout NetworkStateLayout;
    @BindView(R.id.LoadingProgressBar)
    AVLoadingIndicatorView LoadingProgressBar;
    @BindView(R.id.LoadingDataLayout)
    RelativeLayout LoadingDataLayout;
    @BindView(R.id.lineChart)
    GraphView lineChart;
    @BindView(R.id.livedataSwitch)
    LabeledSwitch livedataSwitch;
    @BindView(R.id.LastUpdateTextView)
    TextView LastUpdateTextView;
    //=======================================================================================================================
    //member variables
    boolean isDataLive; // determine if data should be live or offline
    DateFormat dateFormat; //data format to format the time
    CurrenciesApiResponseModel rates; //reference list of rates came from the server
    boolean isInitialized; //determine if data has been loaded and everything is initialized or not
    LineGraphSeries<DataPoint> series; // a list of series (rates) whis has to be shown on the graph
    DataPoint[] dataPoints; // data points on the graph as a reference data for sets
    CurrenciesAdapter adapter; //custom adapter for rates recycler view
    float currencyToExchange = 0.0f; // valuse of the first row input field to convert
    //injection of presenter
    @Inject
    MainActivityMvpPresenter<MainActivityMvpView> presenter;

    //=======================================================================================================================
    //member methods
    public CurrenciesApiResponseModel getRates() {
        return rates;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        presenter.onAttach(MainActivity.this);
        startNetworkBroadcastReceiver(this);
        setUp();
    }

    /**
     * everything starts from here
     */
    @Override
    protected void setUp() {
        dateFormat = new SimpleDateFormat("EEE, HH:mm:ss");
        initializeRecyclerView();
        presenter.updateTheRates("EUR");
        LoadingProgressBar.show();
        isDataLive = true;
        livedataSwitch.setOnToggledListener(this);
    }


    /**
     * initialize the graph view and it's properties
     */
    private void setupGraphView() {
        dataPoints = new DataPoint[rates.getRateList().size()];
        for (int i = 0; i < rates.getRateList().size(); i++) {
            dataPoints[i] = new DataPoint(i, rates.getRateList().get(i).getCurrencyRate());

        }
        series = new LineGraphSeries<>(dataPoints);
        lineChart.getGridLabelRenderer().setVerticalAxisTitle("rates");
        lineChart.getGridLabelRenderer().setHorizontalAxisTitle("currencies");
        lineChart.getGridLabelRenderer().setNumHorizontalLabels(rates.getRateList().size() / 4);
        lineChart.getGridLabelRenderer().setGridColor(Color.LTGRAY);
        lineChart.getGridLabelRenderer().setHighlightZeroLines(false);
        lineChart.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.HORIZONTAL);
        lineChart.getGridLabelRenderer().setHorizontalLabelsVisible(false);
        lineChart.getGridLabelRenderer().setVerticalLabelsVisible(false);
        lineChart.getGridLabelRenderer().setNumVerticalLabels(10);
        lineChart.getViewport().setXAxisBoundsManual(true);
        lineChart.computeScroll();
        lineChart.setTitle("currency rate graph");
        lineChart.getViewport().setScalable(true);
        lineChart.getViewport().setScrollable(true);
        lineChart.getViewport().setMaxX(rates.getRateList().size());
        series.setDrawDataPoints(true);
        series.setDrawBackground(true);
        series.setAnimated(true);
        series.setDrawAsPath(true);
        series.setColor(Color.BLUE);
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getResources().getColor(R.color.blue));
        series.setCustomPaint(paint);
        series.setBackgroundColor(getResources().getColor(R.color.graphBackColor));
        series.setOnDataPointTapListener(new OnDataPointTapListener() {
            @Override
            public void onTap(Series series, DataPointInterface dataPoint) {
                showSnackBar(rates.getRateList().get((int) dataPoint.getX()).getCurrencyName() + " has rate : " + rates.getRateList().get((int) dataPoint.getX()).getCurrencyRate());
            }
        });
        lineChart.addSeries(series);
        lineChart.invalidate();
    }

    /**
     * initialize the recycler view to make it ready for adapter attachment
     */
    private void initializeRecyclerView() {
        isInitialized = false;
        rates = new CurrenciesApiResponseModel();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        CurrensiesRecyclerView.setLayoutManager(linearLayoutManager);
        CurrensiesRecyclerView.setItemAnimator(null);
        adapter = new CurrenciesAdapter(this);
        CurrensiesRecyclerView.setAdapter(adapter);
        adapter.setInputerTextChangeCallBack(this);
        adapter.setOnClickListener(this);
    }


    /**
     * we jump here whenever we get the response of Currencies api point
     *
     * @param responseModel
     */
    @Override
    public void onFetchCurrencies(CurrenciesApiResponseModel responseModel) {
        responseModel.makeTheList();

        if (!isInitialized) {
            initializeRecyclerView();
            LoadingDataLayout.setVisibility(View.INVISIBLE);
            rates.setRatesList(responseModel.getRateList());
            adapter.setmData(rates.getRateList());
            isInitialized = true;
            setupGraphView();
        } else {
            if (isDataLive) {
                rates.getRateList().get(0).setConvertedCurrency(currencyToExchange);
                for (int i = 1; i < rates.getRateList().size(); i++)
                    rates.getRateList().get(i).setCurrencyRate(responseModel.getRateList().get(i).getCurrencyRate());
                updateTheCurrencies();
            }
        }
    }


    /**
     * handler for text change of first row input field which has the amount currency that the user entered
     * @param amount
     */
    @Override
    public void onTextChanged(String amount) {
        if (CommonUtils.isCurrancyValid(amount)) {
            currencyToExchange = Float.parseFloat(amount);
            updateTheCurrencies();
        } else {
            showSnackBar("Please enter a valid input");
        }


    }

    /**
     * update the currency reates after each api call and also updated the graph view with new comming data from server
     */
    public void updateTheCurrencies() {
        LastUpdateTextView.setText(dateFormat.format(Calendar.getInstance().getTime()));

        for (int i = 1; i < rates.getRateList().size(); i++)
            adapter.getmData().get(i).setConvertedCurrency(currencyToExchange * rates.getRateList().get(i).getCurrencyRate());

        runOnUiThread(() -> {
            if (!CurrensiesRecyclerView.isComputingLayout())
                adapter.notifyItemRangeChanged(1, rates.getRateList().size());

            for (int i = 0; i < rates.getRateList().size(); i++)
                dataPoints[i] = new DataPoint(i, rates.getRateList().get(i).getCurrencyRate());

            series.resetData(dataPoints);
        });
    }

    /**
     * an on click event listener to exchange the row which has been touched be the user with the first row to be the main inputer
     * @param item
     */
    @Override
    public void onClick(CurrenciesApiResponseModel.Rate item) {
        int curentPosition = rates.getRateList().indexOf(item);
        Collections.swap(rates.getRateList(), rates.getRateList().indexOf(item), 0);
        CurrensiesRecyclerView.getAdapter().notifyItemChanged(0);
        CurrensiesRecyclerView.getAdapter().notifyItemChanged(curentPosition);
    }


    /**
     *
     * if we get an internet connection this method will be called
     */
    @Override
    public void networkAvailable() {
        NetworkStateLayout.setVisibility(View.INVISIBLE);
        if (!isInitialized) {
            setUp();
        }
        livedataSwitch.setOn(true);
    }

    /**
     * if we the system cannot find a relevant internet connection this method will be called
     */
    @Override
    public void networkUnavailable() {
        livedataSwitch.setOn(false);
        NetworkStateLayout.setVisibility(View.VISIBLE);
    }

    /**
     * unregister the networkBroadcastReceiver
     * @param currentContext
     */
    @Override
    public void unregisterNetworkBroadcastReceiver(Context currentContext) {
        currentContext.unregisterReceiver(networkStateReceiver);
    }

    /**
     * register the networkBroadcastReceiver
     * @param currentContext
     */
    @Override
    public void registerNetworkBroadcastReceiver(Context currentContext) {
        currentContext.registerReceiver(networkStateReceiver, new IntentFilter(android.net.ConnectivityManager.CONNECTIVITY_ACTION));
    }

    /**
     * the NetworkBroadcastReceiver will be started with this method
     * @param currentContext
     */
    @Override
    public void startNetworkBroadcastReceiver(Context currentContext) {
        networkStateReceiver = new NetworkStateReceiver();
        networkStateReceiver.addListener((NetworkStateReceiver.NetworkStateReceiverListener) currentContext);
        registerNetworkBroadcastReceiver(currentContext);
    }


    /**
     * even of swith toggle to determine if the switch has been toggeled or not and will be called when ever user
     * toggles the switch
     * @param toggleableView
     * @param isOn
     */
    @Override
    public void onSwitched(ToggleableView toggleableView, boolean isOn) {
        isDataLive = isOn ? true : false;

    }
}
