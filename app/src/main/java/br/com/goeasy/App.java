package br.com.goeasy;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EApplication;

import java.util.List;

import br.com.goeasy.models.Request;

/**
 * Created by biliboss on 07/03/2015.
 */
@EApplication
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);
        // Enable Local Datastore.
        Parse.enableLocalDatastore(this);
        ParseObject.registerSubclass(Request.class);
        Parse.initialize(this, "wqgsgpjil1d0mbmchOnP7ffb6xBF1A6Xl6x1utiX", "YaefPULtFLwyDcrktjbNzRH28W5dpWQBs4lb4CNH");
        backgroundInit();
    }

    @Background
    void backgroundInit() {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
        try {
            Log.i("Installation", "Saving");
            installation.save();
            Log.i("Installation", "Saved");
        } catch (ParseException e) {
            Log.e("Installation", e.getMessage());
        }
//        List<String> channels = installation.getList("channels");
//
//        Log.i("backgroundInit", ">>>\n"
//                        + "Channels: " + (channels == null ? "null" : channels.toString())
//
//        );

        // Save the current Installation to Parse.
//        ParseInstallation installation = ParseInstallation.getCurrentInstallation();
//        installation.put("channels", new ArrayList<String>());
//        installation.saveInBackground(new SaveCallback() {
//            @DebugLog
//            @Override
//            public void done(ParseException e) {
//
//            }
//        });
        Log.i("App.back.after", "<<<");
    }
}
