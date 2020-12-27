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
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.storeproject.R;
import com.example.storeproject.bean.HomeBean;

import java.util.ArrayList;

public class Make_gridLayoutAdapter extends DelegateAdapter.Adapter<Make_gridLayoutAdapter.ViewHoldr> {
    private Context context;
    private GridLayoutHelper gridLayoutHelper;
    private ArrayList<HomeBean.DataBean.BrandListBean> list;


    public Make_gridLayoutAdapter(Context context, GridLayoutHelper gridLayoutHelper, ArrayList<HomeBean.DataBean.BrandListBean> list) {
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
        this.list = list;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHoldr onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_make_helper, parent, false);
        return new ViewHoldr(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHoldr holder, int position) {
        Glide.with(context).load(list.get(position).getNew_pic_url()).into(holder.ivMakeUrl);
        holder.tvMakeName.setText(list.get(position).getName());
        holder.tvMakePrice.setText(list.get(position).getFloor_price()+"");
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickItemListener!=null){
                    onClickItemListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }



    public class ViewHoldr extends RecyclerView.ViewHolder {
        private ImageView ivMakeUrl;
        private TextView tvMakeName;
        private TextView tvMakePrice;
        public ViewHoldr(@NonNull View itemView) {
            super(itemView);
            ivMakeUrl = itemView.findViewById(R.id.iv_make_url);
            tvMakeName = itemView.findViewById(R.id.tv_make_name);
            tvMakePrice = itemView.findViewById(R.id.tv_make_price);
        }
    }
    public interface OnClickItemListener{
        void onClick(int position);
    }
    private OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }
}
