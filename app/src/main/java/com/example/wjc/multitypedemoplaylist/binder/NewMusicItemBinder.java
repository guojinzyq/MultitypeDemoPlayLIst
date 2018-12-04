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
import com.example.wjc.multitypedemoplaylist.data.NewMusic;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

public class NewMusicItemBinder extends ItemViewBinder<NewMusic,NewMusicItemBinder.newMusicHolder> {

    Context context;
    static class newMusicHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.newMusicTitle)
        TextView newMusicTitle;
        @BindView(R.id.newMusicImageLeft)
        ImageView newMusicImageLeft;
        @BindView(R.id.newMusicTextLeft)
        TextView newMusicTextLeft;
        @BindView(R.id.newMusicImageCenter)
        ImageView newMusicImageCenter;
        @BindView(R.id.newMusicTextCenter)
        TextView newMusicTextCenter;
        @BindView(R.id.newMusicImageRight)
        ImageView newMusicImageRight;
        @BindView(R.id.newMusicTextRight)
        TextView newMusicTextRight;
        newMusicHolder(View itemView){
                super(itemView);
                ButterKnife.bind(this,itemView);
        }
    }

    @NonNull
    @Override
    protected newMusicHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        context=parent.getContext();
        View view=inflater.inflate(R.layout.newmusic_item,parent,false);
        return new newMusicHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull newMusicHolder holder, @NonNull NewMusic item) {
        holder.newMusicTitle.setText(item.getTitle());
        Glide.with(context).load(item.getLeftImage()).into(holder.newMusicImageLeft);
        holder.newMusicTextLeft.setText(item.getLeftText());
        Glide.with(context).load(item.getCenterImage()).into(holder.newMusicImageCenter);
        holder.newMusicTextCenter.setText(item.getCenterText());
        Glide.with(context).load(item.getRightImage()).into(holder.newMusicImageRight);
        holder.newMusicTextRight.setText(item.getRightText());
    }
}
