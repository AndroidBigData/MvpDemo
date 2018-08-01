package com.zjwam.mvpdemo.mvp;

import android.content.Context;

import com.lzy.okgo.model.Response;
import com.zjwam.mvpdemo.Bean.EmptyBean;
import com.zjwam.mvpdemo.Bean.ResponseBean;
import com.zjwam.mvpdemo.Utils.HttpErrorMsg;

import java.util.HashMap;
import java.util.Map;

public class LoginPresenter implements ILoginPresenter {
    private ILoginView loginView;
    private ILoginModel loginModel;
    private Context context;
    private Map<String,String> param;
    public LoginPresenter(ILoginView loginView, Context context) {
        this.loginView = loginView;
        this.context = context;
        loginModel = new LoginModel();
    }

    @Override
    public void login(String name,String pass) {
        param = new HashMap<>();
        param.put("name",name);
        param.put("pass",pass);
        loginModel.getData("http://zkw.org.cn/api/login/login", context, param, new LoginModel.CallBack() {
            @Override
            public void onSuccess(Response<ResponseBean<EmptyBean>> response) {
                loginView.loginResult(response.body().msg);
            }

            @Override
            public void onError(Response<ResponseBean<EmptyBean>> response) {
                Throwable exception = response.getException();
                String error = HttpErrorMsg.getErrorMsg(exception);
                loginView.loginResult(error);
            }

            @Override
            public void onFinish() {

            }
        });
    }
}
