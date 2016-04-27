package com.apmv.batso.ui.activity;

import android.support.v4.app.FragmentActivity;

import com.apmv.batso.R;
import com.apmv.batso.ui.LoadingDialog;

public abstract class BaseActivity extends FragmentActivity {

    private LoadingDialog dialogMessage;

    public void showLoadingMessage(int strResId) {
        if (isFinishing()) {
            return;
        }
        if (dialogMessage != null) {
            return;
        }
        try {
            dialogMessage = LoadingDialog.newInstance(R.string.processing);
            dialogMessage.show(getFragmentManager(), "LoadingDialog");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void dismissLoadingMessage() {
        if (dialogMessage == null) {
            return;
        }
        try {
            dialogMessage.dismiss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } finally {
            dialogMessage = null;
        }
    }

    public String getStringResource(int strResId) {
        return getResources().getString(strResId);
    }

}
