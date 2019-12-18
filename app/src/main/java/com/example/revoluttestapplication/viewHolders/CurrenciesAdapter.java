package com.example.revoluttestapplication.viewHolders;

import android.content.Context;
import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.revoluttestapplication.R;
import com.example.revoluttestapplication.data.network.dataModels.CurrenciesApiResponseModel;
import com.example.revoluttestapplication.utils.CurrencyUtil;
import com.example.revoluttestapplication.viewHolders.CallBacks.CurrenciesOnClickListener;
import com.example.revoluttestapplication.viewHolders.CallBacks.FirstInputerTextChangeCallBack;
import java.util.ArrayList;
import java.util.List;

/**
 * rates recycler view custom adapter
 *
 * @author moeidheidari
 * @version 1.0
 */

public class CurrenciesAdapter extends RecyclerView.Adapter<CurrenciesViewHolder> implements OnClickListener {
    private List<CurrenciesApiResponseModel.Rate> mData;
    private LayoutInflater mInflater;
    private Context mContext;
    private FirstInputerTextChangeCallBack inputerTextChangeCallBack;
    private CurrenciesOnClickListener onClickListener;

    public CurrenciesOnClickListener getOnClickListener() {
        return onClickListener;
    }

    public void setOnClickListener(CurrenciesOnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public FirstInputerTextChangeCallBack getInputerTextChangeCallBack() {
        return inputerTextChangeCallBack;
    }

    public void setInputerTextChangeCallBack(FirstInputerTextChangeCallBack inputerTextChangeCallBack) {
        this.inputerTextChangeCallBack = inputerTextChangeCallBack;
    }

    public List<CurrenciesApiResponseModel.Rate> getmData() {
        return mData;
    }

    public void setmData(List<CurrenciesApiResponseModel.Rate> mData) {
        this.mData = mData;
    }

    public LayoutInflater getmInflater() {
        return mInflater;
    }

    public void setmInflater(LayoutInflater mInflater) {
        this.mInflater = mInflater;
    }

    public CurrenciesAdapter(Context context) {
        this.mContext = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = new ArrayList<>();
    }

    @NonNull
    @Override
    public CurrenciesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.currency_converter_list_item, parent, false);
        return new CurrenciesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CurrenciesViewHolder holder, int position) {
        CurrenciesApiResponseModel.Rate currency = mData.get(position);
        holder.setIsRecyclable(false);
        if (position != 0) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onClickListener.onClick(currency);
                }
            });
        }

        holder.Currency_Converter_EditText_Item.setHintTextColor(Color.WHITE);
        holder.Currency_Converter_EditText_Item.setOnClickListener(this);
        holder.currensies_list_item_flag.setImageResource(CurrencyUtil.getCountryCodeFromCurrencyCode(currency.getCurrencyName()));
        holder.Currency_Converter_RateTextView_Item.setText(currency.getCurrencyName());
        holder.Currency_Converter_EditText_Item.setText(String.valueOf(currency.getConvertedCurrency()));
        if (position == 0) {
            holder.Currency_Converter_EditText_Item.setBackgroundResource(R.drawable.rounded_blue_rectangle);
            holder.Currency_Converter_EditText_Item.setHintTextColor(Color.WHITE);
            holder.Currency_Converter_EditText_Item.setTextColor(Color.WHITE);
            holder.Currency_Converter_EditText_Item.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    if (charSequence.length() > 0)
                    {

                        if(Float.parseFloat(holder.Currency_Converter_EditText_Item.getText().toString())>0)
                        inputerTextChangeCallBack.onTextChanged(holder.Currency_Converter_EditText_Item.getText().toString());
                    }
                    else
                    {
                        inputerTextChangeCallBack.onTextChanged("0.0");
                    }
                }

                @Override
                public void afterTextChanged(Editable s)
                {


                }
            });
        }




    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View view)
    {
        view.performLongClick();

    }
}
