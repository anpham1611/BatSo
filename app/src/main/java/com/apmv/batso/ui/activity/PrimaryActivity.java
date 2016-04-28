package com.apmv.batso.ui.activity;

public abstract class PrimaryActivity extends BaseActivity {

    public void updateServerMessage(String message) {
        showToastMessage(message);
    }
}
