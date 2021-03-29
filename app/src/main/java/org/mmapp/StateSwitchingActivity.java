package org.mmapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * MIT License (http://choosealicense.com/licenses/mit/)
 * <p><br>
 * <b>StateSwitchingActivity</b><br>
 * This activity indicates all its life cycle states in the logcat as soon as they are triggered.
 * </p><br>
 * @author Erik Roemmelt
 */
public class StateSwitchingActivity extends Activity {
    private final String TAG = "MMAPP.StateSwitching";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(TAG, "onCreate()");
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "onStart()");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "onResume()");
        super.onResume();
    }

    @Override
    protected void onRestart() {
        Log.i(TAG, "onRestart()");
        super.onRestart();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "onPause()");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "onStop()");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "onDestroy()");
        super.onDestroy();
    }
}
