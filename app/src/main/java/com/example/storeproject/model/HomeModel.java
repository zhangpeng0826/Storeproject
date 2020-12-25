package com.example.storeproject.model;

import com.example.mylibraryutil.base.BaseModel;
import com.example.mylibraryutil.callback.HttpCallback;
import com.example.mylibraryutil.utils.INetWorkInterface;
import com.example.mylibraryutil.utils.RetUtil;
import com.example.mylibraryutil.utils.URLConstant;
import com.example.storeproject.contract.Contract;

import java.util.HashMap;

public class HomeModel implements Contract.IHomeModel, BaseModel {
    private Contract.IHomePresenter presenter;

    public HomeModel(Contract.IHomePresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public <T> void modelData(String url, HttpCallback<T> callBack) {
        RetUtil.getRetUtil().get(url,callBack);
    }
}
