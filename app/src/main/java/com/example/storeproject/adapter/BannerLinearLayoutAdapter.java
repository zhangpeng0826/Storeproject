package com.example.storeproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.storeproject.R;
import com.example.storeproject.bean.HomeBean;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class BannerLinearLayoutAdapter extends DelegateAdapter.Adapter<BannerLinearLayoutAdapter.ViewHolder> {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.BannerBean> bannerlist;

    public BannerLinearLayoutAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.BannerBean> bannerlist) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.bannerlist = bannerlist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner_helper, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
           holder.banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
               @Override
               public void displayImage(Context context, Object path, ImageView imageView) {
                   HomeBean.DataBean.BannerBean pa = (HomeBean.DataBean.BannerBean) path;
                   Glide.with(context).load(pa.getImage_url()).into(imageView);
               }
           }).start();
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private Banner banner;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner_home);
        }
    }

}
