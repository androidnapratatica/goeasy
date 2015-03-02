package br.com.goeasy.views;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EFragment;

import br.com.goeasy.R;
import br.com.goeasy.helpers.ViewHelper;
import br.com.goeasy.interactors.WaitRideInteractor;

/**
 * Created by biliboss on 28/02/2015.
 */
@EFragment(R.layout.fragment_wait_ride)
public class WaitRideFragment extends Fragment {

    @Bean
    WaitRideInteractor interactor;

    //Show this Fragment
    public static void show(Activity activity) {
        ViewHelper.createFragmentTransaction(activity, R.id.place_holder, WaitRideFragment_.class.getName());
    }

    @AfterInject
    void afterInject(){
        interactor.setActivity(getActivity());
    }

    @Click(R.id.cancel_ride)
    public void cancelRide(){
        interactor.cancelRide();
    }
}
