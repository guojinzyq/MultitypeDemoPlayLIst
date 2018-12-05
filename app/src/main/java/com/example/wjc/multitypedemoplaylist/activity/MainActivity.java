package com.example.wjc.multitypedemoplaylist.activity;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.wjc.multitypedemoplaylist.R;
import com.example.wjc.multitypedemoplaylist.Repository;
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

    Repository repository;
    String TAG="MainActivity";
    Items items;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    public static MultiTypeAdapter adapter;
    LinearLayoutManager manager;
    PracticeLiveData liveModel;
    @BindView(R.id.anm)
    Button anm;
    @BindView(R.id.ahm)
    Button ahm;
    @BindView(R.id.ahl)
    Button ahl;
    @BindView(R.id.unm)
    Button unm;
    @OnClick(R.id.anm)
    public void updateNewMusic(){

        liveModel.updateNewMusicTitle("我的名字");
    }
    @OnClick(R.id.ahm)
    public void updateHotMusic(){
        liveModel.hotMusic.setTitle("新版");

    }
    @OnClick(R.id.ahl)
    public void updateHotList(){
        liveModel.hotList.setTitle("新版");
        liveModel.updateHotListObject();
    }
    @OnClick(R.id.unm)
    public void skip(){
//        Intent intent=new Intent(MainActivity.this,SecondActivity.class);
//        startActivity(intent);
//        liveModel.updateNewMusic();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        items=new Items();
        Log.d(TAG,"onCreate");
        //创建类的实例
        liveModel=PracticeLiveData.getInstance();
//        liveModel=ViewModelProviders.of(this).get(PracticeLiveData.class);
        //创建观察者对象，这里观察者为data包中的三个类
        //绑定起来
        liveModel.getNewMusic().observe(this,(NewMusic newMusic) -> {
            adapter.notifyDataSetChanged();
        });
        liveModel.getHotMusic().observe(this, new Observer<HotMusic>() {
            @Override
            public void onChanged(@Nullable HotMusic hotMusic) {
                adapter.notifyDataSetChanged();
            }
        });
        liveModel.getHotList().observe(this, new Observer<HotList>() {
            @Override
            public void onChanged(@Nullable HotList hotList) {
                adapter.notifyDataSetChanged();
            }
        });
        liveModel.getItems().observe(this, new Observer<Items>() {
            @Override
            public void onChanged(@Nullable Items objects) {
                adapter.setItems(objects);
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
        liveModel.firstOpenApp();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,"onRestart");
    }
}
