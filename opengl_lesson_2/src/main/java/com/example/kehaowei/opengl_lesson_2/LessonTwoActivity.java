package com.example.kehaowei.opengl_lesson_2;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class LessonTwoActivity extends Activity {

    private GLSurfaceView mGLSurfceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mGLSurfceView = new GLSurfaceView(this);
        final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        final ConfigurationInfo info = activityManager.getDeviceConfigurationInfo();
        final boolean supportEs2 = info.reqGlEsVersion >= 0x2000;
        if (supportEs2) {
            mGLSurfceView.setEGLContextClientVersion(2);
            mGLSurfceView.setRenderer(new LessonTwoRenderer());
        } else {
            return;
        }
        setContentView(mGLSurfceView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mGLSurfceView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mGLSurfceView.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lesson_two, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
