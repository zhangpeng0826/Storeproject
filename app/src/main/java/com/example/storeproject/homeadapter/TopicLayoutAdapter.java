package com.example.storeproject.homeadapter;

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
import com.example.storeproject.R;
import com.example.storeproject.bean.HomeBean;

import java.util.ArrayList;

public class TopicLayoutAdapter extends DelegateAdapter.Adapter {
    private ArrayList<HomeBean.DataBean.TopicListBean> list;
    private Context context;
    private GridLayoutHelper gridLayoutHelper;

    public TopicLayoutAdapter(ArrayList<HomeBean.DataBean.TopicListBean> list, Context context, GridLayoutHelper gridLayoutHelper) {
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

            view = LayoutInflater.from(context).inflate(R.layout.layout_topic, parent, false);
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
        return 2;
    }

    public class TopicViewHolder extends RecyclerView.ViewHolder {
        private RecyclerView topicRecy;

        public TopicViewHolder(@NonNull View itemView) {
            super(itemView);
            topicRecy = (RecyclerView) itemView.findViewById(R.id.topic_recy);
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
