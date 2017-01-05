package com.example.dandancao.robotium;
import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import com.robotium.solo.Solo;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Dandan.Cao on 2016/12/29.
 */

public class APKTest extends ActivityInstrumentationTestCase2 {
    private Solo solo;
    private Activity activity;
    private static final String packageName = "com.delta.smsandroidproject";
    private static final String mainActiviy = "com.delta.smsandroidproject.view.activity.LoginActivity";
    private static Class<?> launcherActivityClass;

    static {
        try {
            launcherActivityClass = Class.forName(mainActiviy);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @SuppressWarnings("unchecked")
    public APKTest() {
        super(packageName,launcherActivityClass);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        this.activity=getActivity();
       this.solo = new Solo(getInstrumentation(), getActivity());
    }

    @Test
    public void testApk() throws ClassNotFoundException {
        solo.waitForActivity("LoginActivity", 2000);
        assertTrue("无法启动启动类", solo.waitForActivity("LoginActivity", 30000));
        solo.sleep(5000);
    }
    public void testLogin() throws Exception {
        solo.clearEditText(0);
        solo.enterText(0, "service");
        solo.clearEditText(1);
        solo.enterText(1, "service");
        solo.clickOnText(getActivity().getString(R.string.login));
        solo.sleep(30 * 1000);
        solo.assertCurrentActivity("Is this MainActivity",MainActivity.class);

    }
    public void tearDown() throws Exception {
        try {
            this.solo.finishOpenedActivities();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        this.activity.finish();
        super.tearDown();
    }
    }


