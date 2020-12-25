package com.example.mylibraryutil.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment<T> extends Fragment implements BaseView{
    private T presenter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(getLayout(), container, false);
        presenter = getPresenter();
        initView(view);
        initData();
        initListener();
        return view;
    }

    protected abstract void initListener();

    protected abstract int getLayout();

    protected abstract void initData();

    protected abstract void initView(View view);

    protected abstract T getPresenter();
}
