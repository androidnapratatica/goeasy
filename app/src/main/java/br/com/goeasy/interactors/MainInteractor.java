package br.com.goeasy.interactors;

import android.app.Activity;

import org.androidannotations.annotations.EBean;

import br.com.goeasy.views.WaitAcceptFragment;
import br.com.goeasy.views.WaitRideFragment;

/**
 * Created by biliboss on 28/02/2015.
 */
@EBean
public class MainInteractor {

    private Activity activity;

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public void requestRide() {
        WaitRideFragment.show(activity);
    }

    public void becomeDriver() {
        WaitAcceptFragment.show(activity);
    }
}
