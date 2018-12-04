package com.example.wjc.multitypedemoplaylist.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.wjc.multitypedemoplaylist.R;
import com.example.wjc.multitypedemoplaylist.binder.HotListBinder;
import com.example.wjc.multitypedemoplaylist.binder.HotMusicItemBinder;
import com.example.wjc.multitypedemoplaylist.binder.NewMusicItemBinder;
import com.example.wjc.multitypedemoplaylist.data.HotList;
import com.example.wjc.multitypedemoplaylist.data.HotMusic;
import com.example.wjc.multitypedemoplaylist.data.NewMusic;
import com.example.wjc.multitypedemoplaylist.livemodel.PracticeLiveData;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.drakeet.multitype.Items;
import me.drakeet.multitype.MultiTypeAdapter;

public class MainActivity extends AppCompatActivity {

    public static MainActivity instance=null;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    MultiTypeAdapter adapter;
    static NewMusic newMusic;
    HotMusic hotMusic;
    HotList hotList;
    Items items;
    LinearLayoutManager manager;
    PracticeLiveData liveModel;
    @BindView(R.id.unm)
    Button unm;
    @BindView(R.id.uhm)
    Button uhm;
    @BindView(R.id.uhl)
    Button uhl;
    @BindView(R.id.skip)
    Button skip;
    @OnClick(R.id.unm)
    public void updateNewMusic(){
        newMusic.setTitle("新歌速递2");
        liveModel.getNewMusic().setValue(newMusic);
    }
    @OnClick(R.id.uhm)
    public void updateHotMusic(){
        hotMusic.setTitle("热门歌单2");
        liveModel.getHotMusic().setValue(hotMusic);
    }
    @OnClick(R.id.uhl)
    public void updateHotList(){
//        hotList.setTitle("热门榜单2");
//        liveModel.getHotList().setValue(hotList);
        initData();
        adapter.setItems(items);
        adapter.notifyDataSetChanged();
    }
    @OnClick(R.id.skip)
    public void skip(){
        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intent);
    }
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
        items.add(newMusic);
        items.add(hotMusic);
        items.add(hotList);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instance=this;
        items =new Items();
        //创建类的实例
        liveModel=ViewModelProviders.of(this).get(PracticeLiveData.class);
//        liveModel=ViewModelProviders.of(this).get(PracticeLiveData.class);
        //创建观察者对象，这里观察者为data包中的三个类
        //绑定起来
        liveModel.getNewMusic().observe(this,(NewMusic newMusic) -> {
//            items.add(newMusic);
//            adapter.setItems(items);
            adapter.notifyDataSetChanged();
        });
        liveModel.getHotMusic().observe(this, new Observer<HotMusic>() {
            @Override
            public void onChanged(@Nullable HotMusic hotMusic) {
//                items.add(hotMusic);
//                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        });
        liveModel.getHotList().observe(this, new Observer<HotList>() {
            @Override
            public void onChanged(@Nullable HotList hotList) {
//                items.add(items);
//                adapter.setItems(items);
                adapter.notifyDataSetChanged();
            }
        });
        ButterKnife.bind(this);
        adapter=new MultiTypeAdapter();
        adapter.register(NewMusic.class,new NewMusicItemBinder());
        adapter.register(HotMusic.class,new HotMusicItemBinder());
        adapter.register(HotList.class,new HotListBinder());
        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }
}
