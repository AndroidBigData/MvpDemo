package com.zjwam.mvpdemo.Utils;

import com.google.gson.Gson;
import com.zjwam.mvpdemo.Bean.SimpleResponse;

public class MyException extends IllegalStateException {

    private SimpleResponse errorBean;

    public MyException(String s) {
        super(s);
        errorBean = new Gson().fromJson(s, SimpleResponse.class);
    }

    public SimpleResponse getErrorBean() {
        return errorBean;
    }
}
