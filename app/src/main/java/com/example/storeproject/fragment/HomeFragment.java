package com.example.storeproject.fragment;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.mylibraryutil.base.BaseFragment;
import com.example.mylibraryutil.base.BaseView;
import com.example.storeproject.R;
import com.example.storeproject.adapter.BannerLinearLayoutAdapter;
import com.example.storeproject.adapter.Brand_markLineraLayoutAdapter;
import com.example.storeproject.adapter.ChannelColumnAdapter;
import com.example.storeproject.adapter.Living_at_home_GridLayoutAdapter;
import com.example.storeproject.adapter.Living_at_home_title_LineraLayoutAdapter;
import com.example.storeproject.adapter.Make_gridLayoutAdapter;
import com.example.storeproject.adapter.New_product_LineraLayoutAdapter;
import com.example.storeproject.adapter.Popularity_LineraLayoutAdapter;
import com.example.storeproject.adapter.Product_gridLayoutAdapter;
import com.example.storeproject.adapter.Project_selection_LineraLayoutAdapter;
import com.example.storeproject.adapter.Recommend_LineraLayoutAdapter;
import com.example.storeproject.adapter.SearchLinearLayoutAdapter;
import com.example.storeproject.adapter.TopicLayoutAdapter;
import com.example.storeproject.bean.HomeBean;
import com.example.storeproject.contract.Contract;
import com.example.storeproject.persenter.HomePresenter;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment<HomePresenter> implements BaseView, Contract.IHomeView {

    private RecyclerView rv;
    private VirtualLayoutManager virtualLayoutManager;
    private RecyclerView.RecycledViewPool pool;
    private SearchLinearLayoutAdapter searchLinearLayoutAdapter;
    private BannerLinearLayoutAdapter bannerLinearLayoutAdapter;
    private DelegateAdapter adapter;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;
    private ChannelColumnAdapter channelGridAdapter;
    private Brand_markLineraLayoutAdapter brand_markLineraLayoutAdapter;
    private ArrayList<HomeBean.DataBean.BrandListBean> brandList;
    private Make_gridLayoutAdapter make_gridLayoutAdapter;
    private New_product_LineraLayoutAdapter new_product_LineraLayoutAdapter;
    private ArrayList<HomeBean.DataBean.NewGoodsListBean> productList;
    private Product_gridLayoutAdapter product_gridLayoutAdapter;
    private Popularity_LineraLayoutAdapter popularity_LineraLayoutAdapter;
    private Recommend_LineraLayoutAdapter recommend_LineraLayoutAdapter;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> recommendlist;
    private Project_selection_LineraLayoutAdapter project_selection_LineraLayoutAdapter;
    private ArrayList<HomeBean.DataBean.TopicListBean> topicListDTOS;
    private TopicLayoutAdapter topicLayoutAdapter;
    private Living_at_home_title_LineraLayoutAdapter living_at_home_title_LineraLayoutAdapter;
    private Living_at_home_GridLayoutAdapter living_at_home_gridLayoutAdapter;
    private ArrayList<HomeBean.DataBean.CategoryListBean> homeListBeans;


    public void initListener() {
        //首页 搜索框 监听
        searchLinearLayoutAdapter.setOnClickItemListener(new SearchLinearLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), "搜索", Toast.LENGTH_SHORT).show();
            }
        });

        //首页 第三个 模块 网格 分类 监听
        channelGridAdapter.setOnClickItemListener(new ChannelColumnAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), channellist.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //第四个 文字 品牌制造商直供 监听
        brand_markLineraLayoutAdapter.setOnClickItemListener(new Brand_markLineraLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });

        //第四个 品牌制造商直供 监听
        make_gridLayoutAdapter.setOnClickItemListener(new Make_gridLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
                Toast.makeText(getActivity(), brandList.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
        //第五个 死文字 周一周四新品首发 监听
        new_product_LineraLayoutAdapter.setOnClickItemListener(new New_product_LineraLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });
        //第五个 周一周四新品首发 监听
        product_gridLayoutAdapter.setOnClickItemListener(new Product_gridLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });

        //第六个 文字 人气推荐 监听
        popularity_LineraLayoutAdapter.setOnClickItemListener(new Popularity_LineraLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });

        //第六个 人气推荐 监听
        recommend_LineraLayoutAdapter.setOnClickItemListener(new Recommend_LineraLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });
        //第七个 文字 专题精选 监听
        project_selection_LineraLayoutAdapter.setOnClickItemListener(new Project_selection_LineraLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });
        //第七个  专题精选 监听
        topicLayoutAdapter.setOnClickItemListener(new TopicLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {
            }
        });

        //第七个 文字 居家 监听
        living_at_home_title_LineraLayoutAdapter.setOnClickItemListener(new Living_at_home_title_LineraLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });

        //第七个 居家 监听
        living_at_home_gridLayoutAdapter.setOnClickItemListener(new Living_at_home_GridLayoutAdapter.OnClickItemListener() {
            @Override
            public void onClick(int position) {

            }
        });

        //第七个 文字 餐厨 监听


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
        searchLinearLayoutAdapter = new SearchLinearLayoutAdapter(getActivity(), search_linearLayoutHelper);


        //首页 第二个 模块 Banner
        bannerlist = new ArrayList<>();
        LinearLayoutHelper banner_linearLayoutHelper = new LinearLayoutHelper();
        banner_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        banner_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        bannerLinearLayoutAdapter = new BannerLinearLayoutAdapter(getActivity(), banner_linearLayoutHelper, bannerlist);


        //首页 第三个 模块 网格 分类
        channellist = new ArrayList<>();
        ColumnLayoutHelper channel_columnLayoutHelper = new ColumnLayoutHelper();
        channel_columnLayoutHelper.setItemCount(5);// 设置布局里Item个数
        channel_columnLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        channelGridAdapter = new ChannelColumnAdapter(channel_columnLayoutHelper, getActivity(), channellist);


        //第四个 死文字 品牌制造商直供
        LinearLayoutHelper brand_mark_linearLayoutHelper = new LinearLayoutHelper();
        search_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        search_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        brand_markLineraLayoutAdapter = new Brand_markLineraLayoutAdapter(getActivity(), brand_mark_linearLayoutHelper);


        //第四个 品牌制造商直供
        brandList = new ArrayList<>();
        GridLayoutHelper make_gridLayoutHelper = new GridLayoutHelper(1);
        make_gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        make_gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        make_gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        make_gridLayoutHelper.setHGap(0);// 控制子元素之间的水平间距
        make_gridLayoutHelper.setVGap(0);// 控制子元素之间的垂直间距
        make_gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        make_gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        make_gridLayoutAdapter = new Make_gridLayoutAdapter(getActivity(), make_gridLayoutHelper, brandList);


        //第五个 死文字 周一周四新品首发
        LinearLayoutHelper new_product_linearLayoutHelper = new LinearLayoutHelper();
        new_product_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        new_product_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        new_product_LineraLayoutAdapter = new New_product_LineraLayoutAdapter(getActivity(), new_product_linearLayoutHelper);


        //第五个 周一周四新品首发
        productList = new ArrayList<>();
        GridLayoutHelper product_gridLayoutHelper = new GridLayoutHelper(2);
        make_gridLayoutHelper.setItemCount(4);// 设置布局里Item个数
        make_gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        make_gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        make_gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        make_gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        product_gridLayoutAdapter = new Product_gridLayoutAdapter(getActivity(), product_gridLayoutHelper, productList);


        //第六个 死文字 人气推荐
        LinearLayoutHelper popularity_linearLayoutHelper = new LinearLayoutHelper();
        new_product_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        new_product_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        popularity_LineraLayoutAdapter = new Popularity_LineraLayoutAdapter(getActivity(), popularity_linearLayoutHelper);


        //第六个 人气推荐
        recommendlist = new ArrayList<>();
        LinearLayoutHelper recommend_linearLayoutHelper = new LinearLayoutHelper();
        new_product_linearLayoutHelper.setItemCount(3);// 设置布局里Item个数
        new_product_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        recommend_LineraLayoutAdapter = new Recommend_LineraLayoutAdapter(getActivity(), recommend_linearLayoutHelper, recommendlist);

        //第七个 文字 专题精选
        LinearLayoutHelper roject_selection_linearLayoutHelper = new LinearLayoutHelper();
        new_product_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        new_product_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        project_selection_LineraLayoutAdapter = new Project_selection_LineraLayoutAdapter(getActivity(), roject_selection_linearLayoutHelper);


        //第七个 专题精选
        topicListDTOS = new ArrayList<>();
        GridLayoutHelper topoc_gridLayoutHelper = new GridLayoutHelper(1);
        topoc_gridLayoutHelper.setItemCount(2);
        topicLayoutAdapter = new TopicLayoutAdapter(topicListDTOS, getActivity(), topoc_gridLayoutHelper);



        //第八个 文字 居家
        LinearLayoutHelper living_at_home_title_linearLayoutHelper = new LinearLayoutHelper();
        new_product_linearLayoutHelper.setItemCount(1);// 设置布局里Item个数
        new_product_linearLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        living_at_home_title_LineraLayoutAdapter = new Living_at_home_title_LineraLayoutAdapter(getActivity(), living_at_home_title_linearLayoutHelper);

        //下面布局全部的数据
        homeListBeans = new ArrayList<>();

        //第八个 居家
        GridLayoutHelper living_at_home_gridLayoutHelper = new GridLayoutHelper(2);
        make_gridLayoutHelper.setItemCount(7);// 设置布局里Item个数
        make_gridLayoutHelper.setBgColor(Color.WHITE);// 设置背景颜色
        make_gridLayoutHelper.setWeights(new float[]{50, 50});//设置每行中 每个网格宽度 占 每行总宽度 的比例
        make_gridLayoutHelper.setAutoExpand(false);//是否自动填充空白区域
        make_gridLayoutHelper.setSpanCount(2);// 设置每行多少个网格
        living_at_home_gridLayoutAdapter = new Living_at_home_GridLayoutAdapter(getActivity(), living_at_home_gridLayoutHelper, homeListBeans);












        adapter = new DelegateAdapter(virtualLayoutManager, false);
        adapter.addAdapter(searchLinearLayoutAdapter);
        adapter.addAdapter(bannerLinearLayoutAdapter);
        adapter.addAdapter(channelGridAdapter);
        adapter.addAdapter(brand_markLineraLayoutAdapter);
        adapter.addAdapter(make_gridLayoutAdapter);
        adapter.addAdapter(new_product_LineraLayoutAdapter);
        adapter.addAdapter(product_gridLayoutAdapter);
        adapter.addAdapter(popularity_LineraLayoutAdapter);
        adapter.addAdapter(recommend_LineraLayoutAdapter);
        adapter.addAdapter(project_selection_LineraLayoutAdapter);
        adapter.addAdapter(topicLayoutAdapter);
        adapter.addAdapter(living_at_home_title_LineraLayoutAdapter);
        adapter.addAdapter(living_at_home_gridLayoutAdapter);
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
        brandList.addAll(bean.getBrandList());
        make_gridLayoutAdapter.notifyDataSetChanged();
        productList.addAll(bean.getNewGoodsList());
        product_gridLayoutAdapter.notifyDataSetChanged();
        recommendlist.addAll(bean.getHotGoodsList());
        recommend_LineraLayoutAdapter.notifyDataSetChanged();
        topicListDTOS.addAll(bean.getTopicList());
        topicLayoutAdapter.notifyDataSetChanged();
        homeListBeans.addAll(bean.getCategoryList());
        living_at_home_gridLayoutAdapter.notifyDataSetChanged();

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFail(String err) {
        Log.e("TAG", "首页网络异常====》" + err);
    }
}