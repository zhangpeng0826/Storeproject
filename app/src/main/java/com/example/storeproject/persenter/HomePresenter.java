package com.example.storeproject.persenter;

import com.example.mylibraryutil.base.BasePresenter;
import com.example.mylibraryutil.base.BaseView;
import com.example.mylibraryutil.callback.HttpCallback;
import com.example.mylibraryutil.utils.URLConstant;
import com.example.storeproject.bean.HomeBean;
import com.example.storeproject.contract.Contract;
import com.example.storeproject.fragment.HomeFragment;
import com.example.storeproject.model.HomeModel;

public class HomePresenter extends BasePresenter<HomeFragment, HomeModel> implements Contract.IHomePresenter {
    @Override
    public void getData() {
        getModel().modelData(URLConstant.HomeURL, new HttpCallback<HomeBean>() {
            @Override
            public void OnSuccess(HomeBean homeBean) {
                iView.OnSuccess(homeBean.getData());
            }

            @Override
            public void onFail(String err) {
                iView.onFail(err);
            }
        });
    }

    @Override
    protected HomeModel getModel() {
        HomeModel model = new HomeModel(this);
        return model;
    }
}
