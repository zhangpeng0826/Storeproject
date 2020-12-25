package com.example.storeproject.utils;

import com.example.storeproject.callback.HttpCallback;

import java.util.HashMap;

public interface INetWorkInterface {
     <T> void get(String url, HttpCallback<T> callBack);
     <T> void post(String url, HashMap<String,String> map,HttpCallback<T> callBack);
     <T> void post(String url, HttpCallback<T> callBack);
}
