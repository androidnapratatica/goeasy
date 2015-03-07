package br.com.goeasy.views;

import android.app.Activity;
import android.app.Fragment;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.views.MapView;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

import br.com.goeasy.R;
import br.com.goeasy.helpers.ViewHelper;
import br.com.goeasy.interactors.MainInteractor;
import hugo.weaving.DebugLog;
import io.nlopez.smartlocation.SmartLocation;
import io.nlopez.smartlocation.location.providers.LocationManagerProvider;

/**
 * Created by biliboss on 28/02/2015.
 */
@EFragment(R.layout.fragment_main)
public class MainFragment extends Fragment {

    private static String TAG = MainFragment.class.getSimpleName();

    @ViewById(R.id.main_map)
    MapView mainMap;

    @Bean
    MainInteractor interactor;

    //Show this Fragment
    public static void show(Activity activity) {
        ViewHelper.createFragmentTransaction(activity, R.id.place_holder, MainFragment_.class.getName());
    }

    @AfterViews
    void init() {
        mainMap.getOverlays();
        //TODO: BUG, location sempre null... Falta Play Services (talvez)
        Location location = SmartLocation.with(getActivity()).location()
                .getLastLocation();
        Log.i(TAG, ">>>\n"
        +"Location null?: " + Boolean.toString(location ==null));
        if (location != null) {
            Log.i(TAG, ">>>\n"
                    + "Location: " + location.toString());
            mainMap.setCenter(new LatLng(location));
        }
    }

    @AfterInject
    void afterInject() {
        interactor.setActivity(getActivity());
    }

    @DebugLog
    @Click(R.id.request_ride)
    public void requestRide() {
        interactor.requestRide();
    }

    @Click(R.id.become_driver)
    public void becomeDriver() {
        interactor.becomeDriver();
    }
}
