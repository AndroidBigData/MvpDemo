package com.zjwam.mvpdemo.mvp;

import com.lzy.okgo.model.Response;
import com.zjwam.mvpdemo.Bean.EmptyBean;
import com.zjwam.mvpdemo.Bean.ResponseBean;
import com.zjwam.mvpdemo.Utils.OkGoUtils;
import com.zjwam.mvpdemo.callback.BasicCallback;
import com.zjwam.mvpdemo.callback.JsonCallback;
import java.util.Map;

public class LoginModel implements ILoginModel {
    public void getData(String url, Object context, Map<String, String> param, final BasicCallback<ResponseBean<EmptyBean>> callBack) {
        JsonCallback callback = new JsonCallback<ResponseBean<EmptyBean>>() {
            @Override
            public void onSuccess(Response<ResponseBean<EmptyBean>> response) {
                callBack.onSuccess(response);
            }

            @Override
            public void onError(Response<ResponseBean<EmptyBean>> response) {
                super.onError(response);
                callBack.onError(response);
            }

            @Override
            public void onFinish() {
                super.onFinish();
                callBack.onFinish();
            }
        };
        OkGoUtils.postRequets(url,context,param,callback);
    }

}
