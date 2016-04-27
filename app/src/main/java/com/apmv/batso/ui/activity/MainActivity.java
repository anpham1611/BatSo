package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.apmv.batso.R;
import com.apmv.batso.helper.SharedPreferenceUtils;
import com.apmv.batso.net.api.ApiResponse;
import com.apmv.batso.net.helper.ApiHelper;
import com.apmv.batso.ui.uicontroller.MainActivityUiController;

import org.json.JSONArray;
import org.json.JSONException;

import bolts.Continuation;
import bolts.Task;

public class MainActivity extends PrimaryActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private MainActivityUiController uiController;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;
        uiController = new MainActivityUiController(this);

        init();
    }

    private void init() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

}
