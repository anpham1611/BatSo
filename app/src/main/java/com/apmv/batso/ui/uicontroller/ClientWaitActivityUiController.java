package com.apmv.batso.ui.uicontroller;

import android.view.View;
import android.widget.ImageView;

import com.apmv.batso.R;
import com.apmv.batso.ui.activity.ClientWaitActivity;
import com.skyfishjy.library.RippleBackground;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class ClientWaitActivityUiController implements View.OnClickListener {
    private String TAG = ClientWaitActivityUiController.class.getSimpleName();
    private ClientWaitActivity activity;

    @Bind(R.id.content)
    RippleBackground rippleBackground;
    @Bind(R.id.centerImage)
    ImageView centerImage;

    public ClientWaitActivityUiController(ClientWaitActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
        rippleBackground.startRippleAnimation();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}
