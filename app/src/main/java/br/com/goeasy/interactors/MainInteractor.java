package br.com.goeasy.interactors;

import android.app.Activity;
import android.location.Location;
import android.util.Log;

import com.parse.ParseException;

import org.androidannotations.annotations.EBean;

import br.com.goeasy.models.Request;
import br.com.goeasy.views.WaitAcceptFragment;
import br.com.goeasy.views.WaitRideFragment;

/**
 * Created by biliboss on 28/02/2015.
 */
@EBean
public class MainInteractor {

    private static String TAG = MainInteractor.class.getSimpleName();

    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void requestRide() {
        Location location = new Location("");
        location.setLatitude(20);
        location.setLongitude(20);
        Request request = new Request()
                .setLocation(location);
        try {
            request.save();
        } catch (ParseException e) {
            Log.e(TAG, e.getMessage());
        }
        WaitRideFragment.show(activity);
    }

    public void becomeDriver() {
        WaitAcceptFragment.show(activity);
    }
}
