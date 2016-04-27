package com.apmv.batso.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.apmv.batso.R;
import com.apmv.batso.ui.uicontroller.SignInActivityUiController;

public class SignInActivity extends PrimaryActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private SignInActivityUiController uiController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        uiController = new SignInActivityUiController(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public void onClickNext(String name) {
        uiController.getTvName().setError(null);
        if (uiController.getName().equals("")) {
            uiController.getTvName().setError("Please input your name!");

        } else {
            asyncRequestRegister(name);
        }
    }

    private void asyncRequestRegister(String name) {
        showLoadingMessage(R.string.processing);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                dismissLoadingMessage();
                Intent intent = new Intent(SignInActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 1000);

    }

}
