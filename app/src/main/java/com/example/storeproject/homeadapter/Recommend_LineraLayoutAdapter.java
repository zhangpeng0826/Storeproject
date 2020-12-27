package com.example.storeproject.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.storeproject.R;
import com.example.storeproject.bean.HomeBean;

import java.util.ArrayList;

public class Recommend_LineraLayoutAdapter extends DelegateAdapter.Adapter<Recommend_LineraLayoutAdapter.ViewHolder> {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;
    private ArrayList<HomeBean.DataBean.HotGoodsListBean> list;


    public Recommend_LineraLayoutAdapter(Context context, LinearLayoutHelper linearLayoutHelper, ArrayList<HomeBean.DataBean.HotGoodsListBean> list) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recommend_helper, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeBean.DataBean.HotGoodsListBean bean = list.get(position);
        Glide.with(context).load(bean.getList_pic_url()).into(holder.ivRecommendUrl);
        holder.tvRecommendName.setText(bean.getName());
        holder.tvRecommendGoods.setText(bean.getGoods_brief());
        holder.tvRecommendPrice.setText("￥" + bean.getRetail_price());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener != null) {
                    onClickItemListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivRecommendUrl;
        private TextView tvRecommendName;
        private TextView tvRecommendGoods;
        private TextView tvRecommendPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivRecommendUrl = itemView.findViewById(R.id.iv_recommend_url);
            tvRecommendName = itemView.findViewById(R.id.tv_recommend_name);
            tvRecommendGoods = itemView.findViewById(R.id.tv_recommend_goods);
            tvRecommendPrice = itemView.findViewById(R.id.tv_recommend_price);
        }
    }


    public interface OnClickItemListener {
        void onClick(int position);
    }

    private OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }
}
