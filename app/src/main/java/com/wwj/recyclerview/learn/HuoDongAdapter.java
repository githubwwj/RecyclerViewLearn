package com.wwj.recyclerview.learn;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class HuoDongAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final List<HomeBean.DataBean.HuodongBean> dataList;
    private final Context context;
    private LayoutInflater layoutInflater;

    public HuoDongAdapter(List<HomeBean.DataBean.HuodongBean> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(layoutInflater.inflate(R.layout.item_huo_dong, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            HomeBean.DataBean.HuodongBean huodongBean = dataList.get(position);

            Glide.with(context).load(huodongBean.getImg_url()).centerCrop().into(itemViewHolder.imageView);
            int screenWidth=DensityUtil.getScreenWidth(context);
            int height = screenWidth * huodongBean.getImg_height() / huodongBean.getImg_width();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth, height);
            if (position + 1 != dataList.size()) {
                layoutParams.rightMargin = 10;
            }
            itemViewHolder.imageView.setLayoutParams(layoutParams);
        }

    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
