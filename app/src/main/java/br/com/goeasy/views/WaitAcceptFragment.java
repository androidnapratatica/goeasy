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
import br.com.goeasy.interactors.WaitAcceptInteractor;

/**
 * Created by biliboss on 28/02/2015.
 */
@EFragment(R.layout.fragment_wait_accept)
public class WaitAcceptFragment extends Fragment {

    @Bean
    WaitAcceptInteractor interactor;

    //Show this Fragment
    public static void show(Activity activity) {
        ViewHelper.createFragmentTransaction(activity, R.id.place_holder, WaitAcceptFragment_.class.getName());
    }

    @AfterInject
    void afterInject() {
        interactor.setActivity(getActivity());
    }

    @Click(R.id.decline_ride)
    public void declineRide() {
        interactor.declineRide();
    }
}
