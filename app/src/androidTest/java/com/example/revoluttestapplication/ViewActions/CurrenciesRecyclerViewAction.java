package com.example.revoluttestapplication.ViewActions;

import android.view.View;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.ViewActions;
import com.example.revoluttestapplication.R;
import org.hamcrest.Matcher;

/**
 * @author moeidheidari
 * @version 1.0
 */

public class CurrenciesRecyclerViewAction  implements ViewAction{

    ViewAction click = ViewActions.click();


    @Override
    public Matcher<View> getConstraints() {
        return click.getConstraints();
    }
    @Override
    public String getDescription() {
        return " click on custom image view";
    }

    @Override
    public void perform(UiController uiController, View view) {
        click.perform(uiController, view.findViewById(R.id.currensies_list_item_flag));
    }






}