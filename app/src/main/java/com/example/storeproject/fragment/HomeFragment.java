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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibraryutil.base.BaseFragment;
import com.example.mylibraryutil.base.BaseView;
import com.example.storeproject.R;
import com.example.storeproject.adapter.BannerLinearLayoutAdapter;
import com.example.storeproject.adapter.ChannelGridAdapter;
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
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;
    private ChannelGridAdapter channelGridAdapter;


    public void initListener() {
        //首页 搜索框 监听
        searchLinearLayoutAdapter.setOnClickItemListener(new SearchLinearLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        //首页 第三个 模块 网格 分类 监听
        channelGridAdapter.setOnClickItemListener(new SearchLinearLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), channellist.get(position).getName(), Toast.LENGTH_SHORT).show();
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


        //首页 第三个 模块 网格 分类
        channellist = new ArrayList<>();
        GridLayoutHelper channel_gridLayoutHelper = new GridLayoutHelper(5);
        channel_gridLayoutHelper.setItemCount(5);// 设置布局里Item个数
        channel_gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        channel_gridLayoutHelper.setWeights(new float[]{20, 20, 20, 20, 20});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        channel_gridLayoutHelper.setVGap(20);// 控制子元素之间的垂直间距
        channel_gridLayoutHelper.setHGap(40);// 控制子元素之间的水平间距
        channel_gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        channel_gridLayoutHelper.setSpanCount(5);// 设置每行多少个网格
        channelGridAdapter = new ChannelGridAdapter(channel_gridLayoutHelper, getActivity(), channellist);





        adapter = new DelegateAdapter(virtualLayoutManager, true);
        adapter.addAdapter(searchLinearLayoutAdapter);
        adapter.addAdapter(bannerLinearLayoutAdapter);
        adapter.addAdapter(channelGridAdapter);
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
        channellist.addAll(bean.getChannel());
        channelGridAdapter.notifyDataSetChanged();






        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String err) {

    }
}