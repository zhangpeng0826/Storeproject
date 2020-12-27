package com.example.littleapp.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.littleapp.R;
import com.example.littleapp.bean.HomeBean;

import java.util.ArrayList;

public class TopicRecyAdapter extends RecyclerView.Adapter {
    private ArrayList<HomeBean.DataDTO.TopicListDTO> list;
    private Context context;

    public TopicRecyAdapter(ArrayList<HomeBean.DataDTO.TopicListDTO> list, Context context) {
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
            HomeBean.DataDTO.TopicListDTO data = list.get(position);
            viewHolder.subtitle.setText(data.getSubtitle());
            viewHolder.title.setText(data.getTitle());
            viewHolder.priceInfo.setText("¥ " + data.getPrice_info() + "元起");
            String url = (data.getItem_pic_url().split(":"))[0] + "s:" + (data.getItem_pic_url().split(":"))[1];
            Glide.with(context).load(url).into(viewHolder.itemPicUrl);
            Log.e("TAG", "onBindViewHolder: " + url);
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
