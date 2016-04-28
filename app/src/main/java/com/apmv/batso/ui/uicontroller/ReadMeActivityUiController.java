package com.apmv.batso.ui.uicontroller;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.apmv.batso.R;
import com.apmv.batso.ui.activity.ReadMeActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by an.pham1611 on 2/23/16.
 */
public class ReadMeActivityUiController implements View.OnClickListener {
    private String TAG = ReadMeActivityUiController.class.getSimpleName();
    private ReadMeActivity activity;
    boolean loadingFinished = true;
    boolean redirect = false;

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.webViewReadMe)
    WebView webViewReadMe;
    @Bind(R.id.progressBar)
    ProgressBar progressBar;

    public ReadMeActivityUiController(ReadMeActivity activity) {
        this.activity = activity;
        ButterKnife.bind(this, activity);
        init();
    }

    private void init() {
        initToolbar();
    }

    public void loadReadMe(String url) {
        webViewReadMe.getSettings().setJavaScriptEnabled(true);
        webViewReadMe.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return (event.getAction() == MotionEvent.ACTION_MOVE);
            }
        });
        webViewReadMe.setWebViewClient(new CustomWebViewClient());
        webViewReadMe.loadUrl(url);
    }

    private class CustomWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            progressBar.setVisibility(View.VISIBLE);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progressBar.setVisibility(View.GONE);
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            // this will ignore the Ssl error and will go forward to your site
            handler.proceed();
            error.getCertificate();
        }
    }

    private void initToolbar() {
        toolbar.setTitle(activity.getStringResource(R.string.read_me));
        toolbar.setNavigationIcon(R.drawable.ic_white_back);
        toolbar.setNavigationOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            default:
                activity.onBackPressed();
                break;
        }
    }
}
