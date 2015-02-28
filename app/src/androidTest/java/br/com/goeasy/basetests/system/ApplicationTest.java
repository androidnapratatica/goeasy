package br.com.goeasy.basetests.system;

import android.test.ApplicationTestCase;

import com.parse.ParseConfig;

import org.androidannotations.annotations.Trace;

import br.com.goeasy.App_;


/**
 * Test some system functions
 */
public class ApplicationTest extends ApplicationTestCase<App_> {
    public ApplicationTest() {
        super(App_.class);
    }

    @Trace
    public void testParseInitialization() {
        createApplication();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ParseConfig.getCurrentConfig();
    }
}