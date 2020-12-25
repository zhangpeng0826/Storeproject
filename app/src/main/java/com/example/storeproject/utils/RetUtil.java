package com.example.storeproject.utils;


import com.example.storeproject.api.ApiServices;
import com.example.storeproject.callback.HttpCallback;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

public class RetUtil implements INetWorkInterface {
    private static volatile RetUtil retUtil;
    private final ApiServices apiServices;

    private RetUtil() {
        apiServices = new Retrofit.Builder()
                .baseUrl(URLConstant.BASEURL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(ApiServices.class);
    }

    public static RetUtil getRetUtil() {
        if (retUtil == null) {
            synchronized (RetUtil.class) {
                if (retUtil == null) {
                    retUtil = new RetUtil();
                }
            }
        }
        return retUtil;
    }

    @Override
    public <T> void get(String url, HttpCallback<T> callBack) {
        apiServices.get(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull ResponseBody responseBody) {
                        try {
                            String json = responseBody.string();
                            Type[] genericInterfaces = callBack.getClass().getGenericInterfaces();
                            Type[] actualTypeArguments = ((ParameterizedType) genericInterfaces[0]).getActualTypeArguments();
                            Type t = actualTypeArguments[0];
                            callBack.OnSuccess(new Gson().fromJson(json, t));

                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override
    public <T> void post(String url, HashMap<String, String> map, HttpCallback<T> callBack) {

    }

    @Override
    public <T> void post(String url, HttpCallback<T> callBack) {

    }
}
