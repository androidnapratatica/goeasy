package br.com.goeasy;

import android.support.v4.app.FragmentActivity;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;

import br.com.goeasy.R;
import br.com.goeasy.views.MainFragment;

/**
 * Created by biliboss on 28/02/2015.
 */
@EActivity(R.layout.activity_main)
public class MainActivity extends FragmentActivity {
    @AfterViews
    void init(){
        MainFragment.show(this);
    }
}
