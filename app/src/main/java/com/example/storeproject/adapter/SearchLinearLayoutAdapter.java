package com.example.storeproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.example.storeproject.R;

public class SearchLinearLayoutAdapter extends DelegateAdapter.Adapter<SearchLinearLayoutAdapter.ViewHolder> {
    private Context context;
    private LinearLayoutHelper linearLayoutHelper;


    public SearchLinearLayoutAdapter(Context context, LinearLayoutHelper linearLayoutHelper) {
        this.context = context;
        this.linearLayoutHelper = linearLayoutHelper;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return linearLayoutHelper;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_search_helper, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
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
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private LinearLayout llSearchMain;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            llSearchMain = itemView.findViewById(R.id.ll_search_main);
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
