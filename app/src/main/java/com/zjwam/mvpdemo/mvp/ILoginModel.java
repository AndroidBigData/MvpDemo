package com.zjwam.mvpdemo.mvp;

import java.util.Map;

public interface ILoginModel {
    void getData(String url, Object context, Map<String,String> param, LoginModel.CallBack callBack);
}
