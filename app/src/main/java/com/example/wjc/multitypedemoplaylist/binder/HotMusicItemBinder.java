package com.example.wjc.multitypedemoplaylist.binder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.wjc.multitypedemoplaylist.R;
import com.example.wjc.multitypedemoplaylist.data.HotMusic;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

public class HotMusicItemBinder extends ItemViewBinder<HotMusic,HotMusicItemBinder.HotMusicHolder> {
    Context context;
    static class HotMusicHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.hotMusicTitle)
        TextView title;
        @BindView(R.id.hotMore)
        TextView more;
        @BindView(R.id.hotMusicImage1)
        ImageView imageView1;
        @BindView(R.id.hotMusicText1)
        TextView textView1;
        @BindView(R.id.hotMusicImage2)
        ImageView imageView2;
        @BindView(R.id.hotMusicText2)
        TextView textView2;
        @BindView(R.id.hotMusicImage3)
        ImageView imageView3;
        @BindView(R.id.hotMusicText3)
        TextView textView3;

        @BindView(R.id.hotMusicImage4)
        ImageView imageView4;
        @BindView(R.id.hotMusicText4)
        TextView textView4;
        @BindView(R.id.hotMusicImage5)
        ImageView imageView5;
        @BindView(R.id.hotMusicText5)
        TextView textView5;
        @BindView(R.id.hotMusicImage6)
        ImageView imageView6;
        @BindView(R.id.hotMusicText6)
        TextView textView6;
        HotMusicHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

    @NonNull
    @Override
    protected HotMusicHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        context=parent.getContext();
        View view=inflater.inflate(R.layout.hotmusic_item,parent,false);
        return new HotMusicHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull HotMusicHolder holder, @NonNull HotMusic item) {
        holder.title.setText(item.getTitle());
        holder.more.setText(item.getMore());
        Glide.with(context).load(item.getImage1()).into(holder.imageView1);
        holder.textView1.setText(item.getText1());

        Glide.with(context).load(item.getImage2()).into(holder.imageView2);
        holder.textView2.setText(item.getText2());

        Glide.with(context).load(item.getImage3()).into(holder.imageView3);
        holder.textView3.setText(item.getText3());

        Glide.with(context).load(item.getImage4()).into(holder.imageView4);
        holder.textView4.setText(item.getText4());

        Glide.with(context).load(item.getImage5()).into(holder.imageView5);
        holder.textView5.setText(item.getText5());

        Glide.with(context).load(item.getImage6()).into(holder.imageView6);
        holder.textView6.setText(item.getText6());

    }
}
