package com.zjwam.mvpdemo.Utils;

import com.lzy.okgo.OkGo;
import com.zjwam.mvpdemo.callback.JsonCallback;

import java.util.Map;

public class OkGoUtils {
    /**
     * 不带缓存的网络请求
     * @param url
     * @param tag
     * @param callback
     * @param <T>
     */
    public static <T> void getRequets(String url, Object tag, JsonCallback<T> callback) {
        OkGo.<T>get(url)
                .tag(tag)
                .execute(callback);
    }

    public static <T> void postRequets(String url, Object tag, Map<String, String> params, JsonCallback<T> callback) {
        OkGo.<T>post(url)
                .tag(tag)
                .params(params)
                .execute(callback);
    }
}
