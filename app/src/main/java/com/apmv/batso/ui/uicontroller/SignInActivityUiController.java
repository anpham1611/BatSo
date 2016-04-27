package com.apmv.batso.ui.uicontroller;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.apmv.batso.R;
import com.apmv.batso.helper.SharedPreferenceUtils;
import com.apmv.batso.ui.activity.SignInActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class SignInActivityUiController implements View.OnClickListener {
    SignInActivity activity;

    @Bind(R.id.tv_name)
    EditText tvName;

    @Bind(R.id.btn_next)
    Button btnNext;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    public SignInActivityUiController(SignInActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
        initToolbar();
        btnNext.setOnClickListener(this);
        if (SharedPreferenceUtils.getString("user_name") != null) {
            if (!SharedPreferenceUtils.getString("user_name").equals("")) {
                tvName.setText(SharedPreferenceUtils.getString("user_name"));
            }
        }
    }

    private void initToolbar() {
        toolbar.setTitle("Login");
//        toolbar.setNavigationIcon(R.drawable.ic_white_back);
//        toolbar.setNavigationOnClickListener(this);
    }

    public String getName() {
        return tvName.getText().toString();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_next:
                activity.onClickNext(getName());
                break;
        }
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    public SignInActivity getActivity() {
        return activity;
    }

    public void setActivity(SignInActivity activity) {
        this.activity = activity;
    }

    public EditText getTvName() {
        return tvName;
    }

    public void setTvName(EditText tvName) {
        this.tvName = tvName;
    }
}
