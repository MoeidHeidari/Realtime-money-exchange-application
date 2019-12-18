package com.example.revoluttestapplication;

import android.content.Context;
import android.os.SystemClock;

import androidx.test.InstrumentationRegistry;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.espresso.matcher.RootMatchers;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import com.example.revoluttestapplication.ViewActions.CurrenciesRecyclerViewAction;
import com.example.revoluttestapplication.ViewActions.RecyclerViewMatcher;
import com.example.revoluttestapplication.views.mainActivity.MainActivity;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Random;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.revoluttestapplication", appContext.getPackageName());
    }
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule=new ActivityTestRule<>(MainActivity.class);

    @Test
    public void inputNumber()
    {

        SystemClock.sleep(5000);
        for(int i=1;i<mActivityRule.getActivity().getRates().getRateList().size();i++)
        {
            clickOnListItem(i);
            scrollToPosition(0);
            clearTextView();
            writeRandomNumbers(10);
            SystemClock.sleep(2000);
        }


        SystemClock.sleep(3000);
    }

    public void clickOnListItem(int position) {
        onView(withId(R.id.CurrensiesRecyclerView)).perform(RecyclerViewActions.actionOnItemAtPosition(position, new CurrenciesRecyclerViewAction()));
    }

    public void clearTextView()
    {
        onView(RecyclerViewMatcher.withRecyclerView(R.id.CurrensiesRecyclerView)
                .atPositionOnView(0, R.id.Currency_Converter_EditText_Item))
                .perform(clearText());
    }

    public void writeRandomNumbers(int bound)
    {
        Random rand=new Random();
        onView(RecyclerViewMatcher.withRecyclerView(R.id.CurrensiesRecyclerView)
                .atPositionOnView(0, R.id.Currency_Converter_EditText_Item))
                .perform(typeText(String.valueOf(rand.nextInt(10))));
    }
    public void scrollToPosition(int position)
    {
        Espresso.onView(ViewMatchers.withId(R.id.CurrensiesRecyclerView))
                .inRoot(RootMatchers.withDecorView(Matchers.is(mActivityRule.getActivity().getWindow().getDecorView())))
                .perform(RecyclerViewActions.scrollToPosition(position));
    }

}
