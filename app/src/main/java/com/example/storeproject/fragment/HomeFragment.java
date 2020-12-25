package com.example.storeproject.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibraryutil.base.BaseFragment;
import com.example.mylibraryutil.base.BaseView;
import com.example.storeproject.R;
import com.example.storeproject.adapter.BannerLinearLayoutAdapter;
import com.example.storeproject.adapter.SearchLinearLayoutAdapter;
import com.example.storeproject.bean.HomeBean;
import com.example.storeproject.contract.Contract;
import com.example.storeproject.persenter.HomePresenter;

import java.util.ArrayList;

public class HomeFragment extends BaseFragment<HomePresenter> implements BaseView, Contract.IHomeView {

    private RecyclerView rv;
    private VirtualLayoutManager virtualLayoutManager;
    private RecyclerView.RecycledViewPool pool;
    private SearchLinearLayoutAdapter searchLinearLayoutAdapter;
    private BannerLinearLayoutAdapter bannerLinearLayoutAdapter;
    private DelegateAdapter adapter;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;


    public void initListener() {
        //首页 搜索框 监听
        searchLinearLayoutAdapter.setOnClickItemListener(new SearchLinearLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_home;
    }

    public void initData() {
        //首页 搜索框
        LinearLayoutHelper search_linearLayoutHelper = new LinearLayoutHelper();
        search_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        search_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        searchLinearLayoutAdapter = new SearchLinearLayoutAdapter(getActivity(),search_linearLayoutHelper);


        //首页 第二个 模块 Banner
        bannerlist = new ArrayList<>();
        LinearLayoutHelper banner_linearLayoutHelper = new LinearLayoutHelper();
        banner_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        banner_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        bannerLinearLayoutAdapter = new BannerLinearLayoutAdapter(getActivity(),banner_linearLayoutHelper,bannerlist);










        adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(searchLinearLayoutAdapter);
        adapter.addAdapter(bannerLinearLayoutAdapter);
        rv.setAdapter(adapter);
    }

    public void initView(View view) {
        presenter.attachView(this);
        rv = view.findViewById(R.id.rv_home);
        virtualLayoutManager = new VirtualLayoutManager(getActivity());
        rv.setLayoutManager(virtualLayoutManager);
        pool = new RecyclerView.RecycledViewPool();
        rv.setRecycledViewPool(pool);
        pool.setMaxRecycledViews(0, 10);
        presenter.getData();
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter();
    }

    @Override
    public void OnSuccess(HomeBean.DataBean bean) {
        bannerlist.addAll(bean.getBanner());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String err) {

    }
}