package com.example.storeproject.callback;

public interface HttpCallback<T> {
    void OnSuccess(T t);
    void onFail(String err);
}
