// Generated code from Butter Knife. Do not modify!
package com.example.revoluttestapplication.views.mainActivity;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.example.revoluttestapplication.R;
import com.github.angads25.toggle.widget.LabeledSwitch;
import com.jjoe64.graphview.GraphView;
import com.wang.avi.AVLoadingIndicatorView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MainActivity_ViewBinding implements Unbinder {
  private MainActivity target;

  @UiThread
  public MainActivity_ViewBinding(MainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MainActivity_ViewBinding(MainActivity target, View source) {
    this.target = target;

    target.CurrensiesRecyclerView = Utils.findRequiredViewAsType(source, R.id.CurrensiesRecyclerView, "field 'CurrensiesRecyclerView'", RecyclerView.class);
    target.NetworkStateLayout = Utils.findRequiredViewAsType(source, R.id.NetworkStateLayout, "field 'NetworkStateLayout'", RelativeLayout.class);
    target.LoadingProgressBar = Utils.findRequiredViewAsType(source, R.id.LoadingProgressBar, "field 'LoadingProgressBar'", AVLoadingIndicatorView.class);
    target.LoadingDataLayout = Utils.findRequiredViewAsType(source, R.id.LoadingDataLayout, "field 'LoadingDataLayout'", RelativeLayout.class);
    target.lineChart = Utils.findRequiredViewAsType(source, R.id.lineChart, "field 'lineChart'", GraphView.class);
    target.livedataSwitch = Utils.findRequiredViewAsType(source, R.id.livedataSwitch, "field 'livedataSwitch'", LabeledSwitch.class);
    target.LastUpdateTextView = Utils.findRequiredViewAsType(source, R.id.LastUpdateTextView, "field 'LastUpdateTextView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.CurrensiesRecyclerView = null;
    target.NetworkStateLayout = null;
    target.LoadingProgressBar = null;
    target.LoadingDataLayout = null;
    target.lineChart = null;
    target.livedataSwitch = null;
    target.LastUpdateTextView = null;
  }
}
