package com.zjwam.mvpdemo.mvp;

import com.zjwam.mvpdemo.Bean.EmptyBean;
import com.zjwam.mvpdemo.Bean.ResponseBean;
import com.zjwam.mvpdemo.callback.BasicCallback;

import java.util.Map;

public interface ILoginModel {
    void getData(String url, Object context, Map<String,String> param, BasicCallback<ResponseBean<EmptyBean>> callBack);
}
