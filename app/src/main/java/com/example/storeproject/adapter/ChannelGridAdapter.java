package com.example.storeproject.adapter;

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

public class ChannelGridAdapter extends DelegateAdapter.Adapter<ChannelGridAdapter.ViewHolder> {
    private GridLayoutHelper gridLayoutHelper;
    private Context context;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;


    public ChannelGridAdapter(GridLayoutHelper gridLayoutHelper, Context context, ArrayList<HomeBean.DataBean.ChannelBean> channellist) {
        this.gridLayoutHelper = gridLayoutHelper;
        this.context = context;
        this.channellist = channellist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_channel_helper, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeBean.DataBean.ChannelBean channelBean = channellist.get(position);
        Glide.with(context).load(channelBean.getIcon_url()).into(holder.ivChannel);
        holder.tvChannel.setText(channelBean.getName());
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
        return channellist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivChannel;
        private TextView tvChannel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivChannel = itemView.findViewById(R.id.iv_channel);
            tvChannel = itemView.findViewById(R.id.tv_channel);
        }
    }

    public interface OnClickItemListener{
        void onClick(int position);
    }
    private SearchLinearLayoutAdapter.OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(SearchLinearLayoutAdapter.OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }

}
