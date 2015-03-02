package br.com.goeasy.helpers;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;

import java.lang.reflect.Constructor;
import java.lang.reflect.Type;

import br.com.goeasy.R;

/**
 * Created by CasalKoala on 01/03/2015.
 */
public class ViewHelper {
    public static void createFragmentTransaction(Activity activity, int id, String className) {
        try {
            FragmentTransaction transaction = activity.getFragmentManager().beginTransaction();
            //transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right);
            Class fragmentClass = Class.forName(className);
            Fragment fragment = (Fragment)fragmentClass.newInstance();
            transaction.replace(id, fragment, className);
            transaction.commit();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
