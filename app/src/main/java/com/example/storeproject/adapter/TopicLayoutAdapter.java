package com.example.littleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.SingleLayoutHelper;
import com.example.littleapp.R;
import com.example.littleapp.bean.HomeBean;

import java.util.ArrayList;

public class TopicLayoutAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataDTO.TopicListDTO> list;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    public TopicLayoutAdapter(ArrayList<HomeBean.DataDTO.TopicListDTO> list, Context context, GridLayoutHelper gridLayoutHelper) {
        this.list = list;
        this.context = context;
        this.gridLayoutHelper = gridLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return gridLayoutHelper;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(context).inflate(R.layout.layout_topic_title, parent, false);
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.layout_topic, parent, false);
        }
        return new TopicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (list.size() != 0) {
            if (position == 0) {

            } else {
                TopicViewHolder viewHolder = (TopicViewHolder) holder;

                RecyclerView recy = viewHolder.topicRecy;

                TopicRecyAdapter topicRecyAdapter = new TopicRecyAdapter(list, context);
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
                linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
                recy.setLayoutManager(linearLayoutManager);
                recy.setAdapter(topicRecyAdapter);
            }
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView topicRecy;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicRecy = (RecyclerView) itemView.findViewById(R.id.topic_recy);
        }
    }
}
