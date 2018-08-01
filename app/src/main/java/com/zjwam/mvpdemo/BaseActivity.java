package com.zjwam.mvpdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.lzy.okgo.OkGo;

public class BaseActivity extends AppCompatActivity {
    private boolean mReceiverTag = false;
    /**
     * 关闭Activity的广播
     */
    protected BroadcastReceiver finishAppReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            finish();
        }
    };

    @Override
    public void onResume() {
        super.onResume();
        // 在当前的activity中注册广播
        IntentFilter filter = new IntentFilter();
        filter.addAction("exitapp");
        if (!mReceiverTag) {
            this.registerReceiver(this.finishAppReceiver, filter);
            mReceiverTag = true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mReceiverTag) {
            mReceiverTag = false;
            this.unregisterReceiver(this.finishAppReceiver);
        }
        OkGo.getInstance().cancelTag(this);
    }

    public void error(final String error) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getBaseContext(), error, Toast.LENGTH_LONG).show();
            }
        });
    }
}
