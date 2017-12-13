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

public class TeBieTuiJianAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final List<HomeBean.DataBean.TbtuijianBean> dataList;
    private final Context context;
    private LayoutInflater layoutInflater;

    public TeBieTuiJianAdapter(List<HomeBean.DataBean.TbtuijianBean> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemViewHolder(layoutInflater.inflate(R.layout.item_te_bie_tui_jian, null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder itemViewHolder = (ItemViewHolder) holder;

            HomeBean.DataBean.TbtuijianBean tbtuijianBean = dataList.get(position);

            Glide.with(context).load(tbtuijianBean.getImg_url()).centerCrop().into(itemViewHolder.imageView);

            int screenWidth = DensityUtil.getScreenWidth(context) / 2;
            int height = screenWidth * tbtuijianBean.getImg_height() / tbtuijianBean.getImg_width();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(screenWidth, height);
            if (position % 2 == 0) {
                layoutParams.rightMargin = 10;
            } else {
                layoutParams.leftMargin = 10;
            }
            itemViewHolder.imageView.setLayoutParams(layoutParams);

            if (null != tbtuijianBean.getTitle()) {
                itemViewHolder.tvTitle.setText(tbtuijianBean.getTitle());
            } else {
                itemViewHolder.tvTitle.setText("");
            }
            itemViewHolder.tvPrice.setText("￥" + tbtuijianBean.getPrice());
        }

    }

    private class ItemViewHolder extends RecyclerView.ViewHolder {

        private final ImageView imageView;
        private final TextView tvPrice;
        private final TextView tvTitle;

        public ItemViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvPrice = itemView.findViewById(R.id.tvPrice);
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
