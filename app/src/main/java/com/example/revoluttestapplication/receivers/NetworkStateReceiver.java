package com.example.revoluttestapplication.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.util.ArrayList;
import java.util.List;


public class NetworkStateReceiver extends BroadcastReceiver
{

    protected List<NetworkStateReceiverListener> listeners;
    protected Boolean connected;
    private String TAG = "NetworkStateReceiver";


    public NetworkStateReceiver() {
        listeners = new ArrayList<>();
        connected = null;
    }

    public void onReceive(Context context, Intent intent) {

        if(intent == null || intent.getExtras() == null)
            return;

        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if(networkInfo != null && networkInfo.getState() == NetworkInfo.State.CONNECTED) {
            connected = true;
        } else if(intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, Boolean.FALSE))
        {
            connected = false;
        }

        notifyStateToAll();
    }

    private void notifyStateToAll() {

        for(NetworkStateReceiverListener eachNetworkStateReceiverListener : listeners)
            notifyState(eachNetworkStateReceiverListener);
    }

    private void notifyState(NetworkStateReceiverListener networkStateReceiverListener) {
        if(connected == null || networkStateReceiverListener == null)
            return;

        if(connected == true) {
            // Triggering function on the interface towards network availability
            networkStateReceiverListener.networkAvailable();
        } else {
            // Triggering function on the interface towards network being unavailable
            networkStateReceiverListener.networkUnavailable();
        }
    }

    public void addListener(NetworkStateReceiverListener networkStateReceiverListener) {

        listeners.add(networkStateReceiverListener);
        notifyState(networkStateReceiverListener);
    }

    public void removeListener(NetworkStateReceiverListener networkStateReceiverListener) {
        listeners.remove(networkStateReceiverListener);
    }


    public interface NetworkStateReceiverListener {

        void networkAvailable();


        void networkUnavailable();
    }
}
