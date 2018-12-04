package com.example.wjc.multitypedemoplaylist;

import com.example.wjc.multitypedemoplaylist.data.HotList;
import com.example.wjc.multitypedemoplaylist.data.HotMusic;
import com.example.wjc.multitypedemoplaylist.data.NewMusic;

public class Repository {

    NewMusic newMusic;
    HotMusic hotMusic;
    HotList hotList;
    void initData(){
        newMusic=new NewMusic();
        newMusic.setTitle("新歌速递");
        newMusic.setCenterImage(R.mipmap.new_music_image);
        newMusic.setLeftText("新歌首发");
        newMusic.setLeftImage(R.mipmap.new_music_image);
        newMusic.setCenterText("新碟上架");
        newMusic.setRightImage(R.mipmap.new_music_image);
        newMusic.setRightText("唱片店");
        hotMusic=new HotMusic();
        hotMusic.setTitle("热门歌单");
        hotMusic.setMore("更多");
        hotMusic.setImage1(R.mipmap.hot_music_image);
        hotMusic.setImage2(R.mipmap.hot_music_image);
        hotMusic.setImage3(R.mipmap.hot_music_image);
        hotMusic.setImage4(R.mipmap.hot_music_image);
        hotMusic.setImage5(R.mipmap.hot_music_image);
        hotMusic.setImage6(R.mipmap.hot_music_image);
        hotMusic.setText1("起风了");
        hotMusic.setText2("盗将行");
        hotMusic.setText3("白龙马");
        hotMusic.setText4("起风了");
        hotMusic.setText5("盗将行");
        hotMusic.setText6("白龙马");
        hotList=new HotList();
        hotList.setTitle("酷狗热歌榜");
        hotList.setMore("更多");
        hotList.setImage1(R.mipmap.hot_list_image);
        hotList.setText1("Alan Walker-Faded");
        hotList.setText2("火箭少女101-卡路里");
        hotList.setText3("邓紫棋-光年之外");
    }
}
