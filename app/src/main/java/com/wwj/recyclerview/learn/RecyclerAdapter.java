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

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final List<TuiJianBean.TuijianBean> dataList;
    private final Context context;
    private LayoutInflater layoutInflater;

    public RecyclerAdapter(List<TuiJianBean.TuijianBean> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(layoutInflater.inflate(R.layout.item_tui_jian, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            TuiJianBean.TuijianBean tuijianBean = dataList.get(position);

            Glide.with(context).load(tuijianBean.getImg_url()).centerCrop().into(itemViewHolder.imageView);

            int width = DensityUtil.dip2px(context, 105);
            int height = width * tuijianBean.getImg_height() / tuijianBean.getImg_width();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(width, height);
            if (position + 1 != dataList.size()){
                layoutParams.rightMargin = 10;
            }
            itemViewHolder.imageView.setLayoutParams(layoutParams);

            itemViewHolder.tvPrice.setText("￥" + tuijianBean.getPrice());
        }

    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView tvPrice;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
