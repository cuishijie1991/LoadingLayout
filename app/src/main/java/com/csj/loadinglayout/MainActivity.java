package com.csj.loadinglayout;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    private Handler mHandler = new Handler();
    private LoadingLayout mLoadingLayout;
    private TextView mResultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mResultTextView = (TextView) findViewById(R.id.resultText);
        mLoadingLayout = (LoadingLayout) findViewById(R.id.loadingLayout);
        mLoadingLayout.setOnNetErrorClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchData(true);
                mLoadingLayout.showLoading();
            }
        });
        fetchData(false);
        mLoadingLayout.showLoading();
    }

    private void handleResult(boolean success, String result) {
        if (success) {
            if (result == null) {
                mLoadingLayout.showNoResult();
            } else {
                mResultTextView.setText(result);
                mLoadingLayout.showResult();
            }
        } else {
            mLoadingLayout.showNetError();
        }
    }

    private void fetchData(final boolean isRetry) {
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isRetry) {
                    handleResult(true, "This is the result !");
                } else {
                    handleResult(false, null);
                }
            }
        }, 1000);
    }
}
