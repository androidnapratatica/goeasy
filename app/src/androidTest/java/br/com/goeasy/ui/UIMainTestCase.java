package br.com.goeasy.ui;

import android.support.test.espresso.ViewInteraction;
import android.test.ActivityInstrumentationTestCase2;

import com.mapbox.mapboxsdk.geometry.LatLng;

import br.com.goeasy.MainActivity_;
import br.com.goeasy.R;
import br.com.goeasy.interactors.MainInteractor;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by biliboss on 17/02/2015.
 */
public class UIMainTestCase extends ActivityInstrumentationTestCase2<MainActivity_> {


    MainInteractor interactor;
    private LatLng start;
    private LatLng end;

    public UIMainTestCase() {
        super(MainActivity_.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        //Create Activity
        interactor = mock(MainInteractor.class);
        MainActivity_ activity = getActivity();
    }

    public void testSanity() {
        onView(withId(R.id.request_ride)).check(matches(isDisplayed()));
//        onView(withId(R.id.become_driver)).check(matches(isDisplayed()));
    }

    public void testRequestRide(){
        onView(withId(R.id.request_ride))
                .perform(click());
        verify(interactor).requestRide();
    }

    public void testRequestRideWaitFragment() throws InterruptedException {
        ViewInteraction waitProgress = onView(withId(R.id.wait_ride_text));
        waitProgress.check(doesNotExist());
        onView((withId(R.id.request_ride))).perform(click());
        waitProgress.check(matches(isDisplayed()));
    }

//    public void test_1_WhenNewRideArrives_HeaderAppears() {
//        onView(withId(R.id.main_top)).check(matches(isDisplayed()));
//    }
//
//    public void test_1_WhenNewRideArrives_FooterAppears() {
//        onView(withId(R.id.main_bottom)).check(matches(isDisplayed()));
//    }

}


