package com.zjwam.mvpdemo.mvp;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.zjwam.mvpdemo.BaseActivity;
import com.zjwam.mvpdemo.R;

public class LoginActivity extends BaseActivity implements ILoginView {

    private EditText login_name,login_pass;
    private Button login;
    private TextView login_result;
    private LoginPresenter loginPresenter;
    private String EXITAPP = "再按一次退出程序";
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login_name = findViewById(R.id.login_name);
        login_pass = findViewById(R.id.login_pass);
        login = findViewById(R.id.login);
        login_result = findViewById(R.id.login_result);
        loginPresenter = new LoginPresenter(this,this);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.login(login_name.getText().toString().trim(),login_pass.getText().toString().trim());
            }
        });
    }

    @Override
    public void loginResult(String result) {
        login_result.setText(result);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            // 判断是否在两秒之内连续点击返回键，是则退出，否则不退出
            if (System.currentTimeMillis() - exitTime > 2000) {
                Toast.makeText(getBaseContext(),EXITAPP,Toast.LENGTH_SHORT).show();
                // 将系统当前的时间赋值给exitTime
                exitTime = System.currentTimeMillis();
            } else {
                exitApp();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    /**
     * 退出应用程序的方法，发送退出程序的广播
     */
    private void exitApp() {
        Intent intent = new Intent();
        intent.setAction("exitapp");
        this.sendBroadcast(intent);
    }
}
