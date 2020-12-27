package com.example.storeproject.homeadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import com.example.storeproject.R;
import com.example.storeproject.bean.HomeBean;

import java.util.ArrayList;

public class TopicRecyAdapter extends RecyclerView.Adapter {
    private ArrayList<HomeBean.DataBean.TopicListBean> list;
    private Context context;

    public TopicRecyAdapter(ArrayList<HomeBean.DataBean.TopicListBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_topic_recy, parent, false);
        return new TopicRecyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (list.size() != 0) {
            TopicRecyViewHolder viewHolder = (TopicRecyViewHolder) holder;
            HomeBean.DataBean.TopicListBean data = list.get(position);
            viewHolder.subtitle.setText(data.getSubtitle());
            viewHolder.title.setText(data.getTitle());
            viewHolder.priceInfo.setText("¥ " + data.getPrice_info() + "元起");
            String url = (data.getItem_pic_url().split(":"))[0] + "s:" + (data.getItem_pic_url().split(":"))[1];
            Glide.with(context).load(data.getItem_pic_url()).into(viewHolder.itemPicUrl);

        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class TopicRecyViewHolder extends RecyclerView.ViewHolder {
        private ImageView itemPicUrl;
        private TextView title;
        private TextView priceInfo;
        private TextView subtitle;

        public TopicRecyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemPicUrl = (ImageView) itemView.findViewById(R.id.item_pic_url);
            title = (TextView) itemView.findViewById(R.id.title);
            priceInfo = (TextView) itemView.findViewById(R.id.price_info);
            subtitle = (TextView) itemView.findViewById(R.id.subtitle);
        }
    }

}
