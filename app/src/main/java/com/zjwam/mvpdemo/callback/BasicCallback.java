package com.zjwam.mvpdemo.callback;

import com.lzy.okgo.model.Response;

public interface BasicCallback<T> {
    void onSuccess(Response<T> response);
    void onError(Response<T> response);
    void onFinish();
}
