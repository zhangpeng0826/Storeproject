package com.example.mylibraryutil.callback;

public interface HttpCallback<T> {
    void OnSuccess(T t);
    void onFail(String err);
}
