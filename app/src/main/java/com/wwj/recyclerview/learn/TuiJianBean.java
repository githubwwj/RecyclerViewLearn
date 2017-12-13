package com.wwj.recyclerview.learn;

import java.util.List;

/**
 * Created by Administrator on 2017/12/13 0013.
 */

public class TuiJianBean {


    private List<TuijianBean> tuijian;

    public List<TuijianBean> getTuijian() {
        return tuijian;
    }

    public void setTuijian(List<TuijianBean> tuijian) {
        this.tuijian = tuijian;
    }

    public static class TuijianBean {
        /**
         * produc_id : 34196
         * title :
         * price : 38
         * producnumb : 148877726618538
         * img_url : http://www.mallgo.com/Tpl/default/upload/wshop/tuijian/5996bccde6753_small.jpg
         * sort : 3
         * img_width : 210
         * img_height : 280
         */

        private String produc_id;
        private String price;
        private String img_url;
        private int img_width;
        private int img_height;

        public String getProduc_id() {
            return produc_id;
        }

        public void setProduc_id(String produc_id) {
            this.produc_id = produc_id;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getImg_url() {
            return img_url;
        }

        public void setImg_url(String img_url) {
            this.img_url = img_url;
        }

        public int getImg_width() {
            return img_width;
        }

        public void setImg_width(int img_width) {
            this.img_width = img_width;
        }

        public int getImg_height() {
            return img_height;
        }

        public void setImg_height(int img_height) {
            this.img_height = img_height;
        }
    }
}
