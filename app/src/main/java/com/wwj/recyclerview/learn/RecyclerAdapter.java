package com.wwj.recyclerview.learn;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.wwj.banner.Banner;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private static final int TYPE_BANNER = 10; //轮播图
    private static final int TYPE_TUIJIAN = 11; //推荐
    private static final int TYPE_HUO_DONG = 12; //活动
    private static final int TYPE_TE_BIE_TUI_JIAN = 13; //特别推荐
    private final HomeBean.DataBean homeBean;
    private final Context context;
    private LayoutInflater layoutInflater;
    private ArrayList<String> bannerData = new ArrayList<>();

    public RecyclerAdapter(HomeBean.DataBean homeBean, Context context) {
        this.homeBean = homeBean;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        for (int i = 0; i < homeBean.getCover().size(); i++) {
            bannerData.add(homeBean.getCover().get(i).getImg_url());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TYPE_BANNER) {
            return new BannerViewHolder(layoutInflater.inflate(R.layout.item_type_banner, null));
        } else if (viewType == TYPE_TUIJIAN) {
            return new TuiJianViewHolder(layoutInflater.inflate(R.layout.item_type_tui_jian, null));
        } else if (viewType == TYPE_HUO_DONG) {
            return new HuoDongViewHolder(layoutInflater.inflate(R.layout.item_type_huodong, null));
        } else if (viewType == TYPE_TE_BIE_TUI_JIAN) {
            return new TeBieTuiJianViewHolder(layoutInflater.inflate(R.layout.item_type_te_bie_tui_jian, null));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof BannerViewHolder) {
            BannerViewHolder bannerViewHolder = (BannerViewHolder) holder;
            bannerViewHolder.banner.setData(bannerData);
            bannerViewHolder.banner.start();
        } else if (holder instanceof TuiJianViewHolder) {
            TuiJianViewHolder tuiJianViewHolder = (TuiJianViewHolder) holder;
            tuiJianViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context, 1, GridLayoutManager.HORIZONTAL, false));
            tuiJianViewHolder.recyclerView.setAdapter(new TuiJianAdapter(homeBean.getTuijian(), context));
        } else if (holder instanceof HuoDongViewHolder) {
            HuoDongViewHolder huoDongViewHolder = (HuoDongViewHolder) holder;
            huoDongViewHolder.recyclerView.setLayoutManager(new LinearLayoutManager(context, GridLayoutManager.VERTICAL,false));
            huoDongViewHolder.recyclerView.setAdapter(new HuoDongAdapter(homeBean.getHuodong(), context));
        } else if (holder instanceof TeBieTuiJianViewHolder) {
            TeBieTuiJianViewHolder teBieTuiJianViewHolder = (TeBieTuiJianViewHolder) holder;
            teBieTuiJianViewHolder.recyclerView.setLayoutManager(new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false));
            teBieTuiJianViewHolder.recyclerView.setAdapter(new TeBieTuiJianAdapter(homeBean.getTbtuijian(), context));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return TYPE_BANNER;
        } else if (position == 1) {
            return TYPE_TUIJIAN;
        } else if (position == 2) {
            return TYPE_HUO_DONG;
        } else if (position == 3) {
            return TYPE_TE_BIE_TUI_JIAN;
        }
        return -1;

    }

    private class BannerViewHolder extends RecyclerView.ViewHolder {

        private final Banner banner;

        public BannerViewHolder(View itemView) {
            super(itemView);
            banner = itemView.findViewById(R.id.banner);
        }
    }

    private class TuiJianViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public TuiJianViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }

    private class HuoDongViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public HuoDongViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }

    private class TeBieTuiJianViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recyclerView;

        public TeBieTuiJianViewHolder(View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.recyclerView);
        }
    }


    @Override
    public int getItemCount() {
        return 4;
    }
}
