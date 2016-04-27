package com.apmv.batso.ui.uicontroller;

import android.view.View;
import android.widget.ImageView;

import com.apmv.batso.R;
import com.apmv.batso.ui.activity.ServerWaitActivity;
import com.skyfishjy.library.RippleBackground;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class ServerWaitActivityUiController implements View.OnClickListener {
    private String TAG = ServerWaitActivityUiController.class.getSimpleName();
    private ServerWaitActivity activity;

    @Bind(R.id.content)
    RippleBackground rippleBackground;
    @Bind(R.id.centerImage)
    ImageView centerImage;

    public ServerWaitActivityUiController(ServerWaitActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
        centerImage.setOnClickListener(this);
        rippleBackground.startRippleAnimation();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.centerImage:
                break;

            default:
                break;
        }
    }
}
