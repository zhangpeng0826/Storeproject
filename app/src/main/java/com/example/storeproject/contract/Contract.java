package com.example.storeproject.contract;

import com.example.mylibraryutil.callback.HttpCallback;
import com.example.storeproject.bean.HomeBean;

public class Contract {
    public interface IHomePresenter{
        void getData();
    }

    public interface IHomeModel{
        <T> void modelData(String url, HttpCallback<T> callBack);
    }

    public interface IHomeView{
        void OnSuccess(HomeBean.DataBean bean);
        void onFail(String err);
    }
}
