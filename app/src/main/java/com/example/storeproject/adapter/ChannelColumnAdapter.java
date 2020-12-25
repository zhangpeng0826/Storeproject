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
import com.alibaba.android.vlayout.layout.ColumnLayoutHelper;
import com.bumptech.glide.Glide;
import com.example.storeproject.R;
import com.example.storeproject.bean.HomeBean;

import java.util.ArrayList;


public class ChannelColumnAdapter extends DelegateAdapter.Adapter<ChannelColumnAdapter.ViewHolder> {
    private ColumnLayoutHelper columnLayoutHelper;
    private Context context;
    private ArrayList<HomeBean.DataBean.ChannelBean> channellist;


    public ChannelColumnAdapter(ColumnLayoutHelper columnLayoutHelper, Context context, ArrayList<HomeBean.DataBean.ChannelBean> channellist) {
        this.columnLayoutHelper = columnLayoutHelper;
        this.context = context;
        this.channellist = channellist;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return columnLayoutHelper;
    }

    @NonNull
    @Override
    public ChannelColumnAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_channel_helper, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChannelColumnAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(channellist.get(position).getIcon_url()).into(holder.ivChannel);
        holder.tvChannel.setText(channellist.get(position).getName());
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


    public interface OnClickItemListener {
        void onClick(int position);
    }

    private OnClickItemListener onClickItemListener;

    public void setOnClickItemListener(OnClickItemListener onClickItemListener) {
        this.onClickItemListener = onClickItemListener;
    }


}
