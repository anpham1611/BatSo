package com.apmv.batso.ui.uicontroller;

import android.view.View;
import android.widget.TextView;

import com.apmv.batso.R;
import com.apmv.batso.ui.activity.ClientActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class ClientActivityUiController implements View.OnClickListener {
    private String TAG = ClientActivityUiController.class.getSimpleName();
    private ClientActivity activity;

    @Bind(R.id.txtMessage)
    TextView txtMessage;

    public ClientActivityUiController(ClientActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
    }

    public TextView getTxtMessage() {
        return txtMessage;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                break;
        }
    }
}
