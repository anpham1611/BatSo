package com.apmv.batso.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.apmv.batso.R;
import com.apmv.batso.helper.Constants;
import com.apmv.batso.ui.uicontroller.ReadMeActivityUiController;

public class ReadMeActivity extends SecondaryActivity {
    private static final String TAG = ReadMeActivity.class.getSimpleName();
    private ReadMeActivityUiController uiController;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_me);

        mContext = this;
        uiController = new ReadMeActivityUiController(this);

        init();
    }

    private void init() {
        uiController.loadReadMe(Constants.READ_ME_URL);
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
