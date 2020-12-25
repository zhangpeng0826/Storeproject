package com.example.mylibraryutil.base;

public abstract class BasePresenter<V extends BaseView,M extends BaseModel> {
    protected V iView;
    protected M iModle;
    public void attachView(V v){
        iView = v;
        iModle = getModel();
    }

    protected abstract M getModel();

    public void detachView(){
        iView = null;
        iModle = null;
    }
}
