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
import com.example.wjc.multitypedemoplaylist.data.HotList;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.drakeet.multitype.ItemViewBinder;

public class HotListBinder extends ItemViewBinder<HotList, HotListBinder.HotListHolder> {
    Context context;


    static class HotListHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.hotListTitle)
        TextView hotListTitle;
        @BindView(R.id.hotMore)
        TextView hotMore;
        @BindView(R.id.hotListImage1)
        ImageView hotListImage1;
        @BindView(R.id.hotListText1)
        TextView hotListText1;
        @BindView(R.id.hotListText2)
        TextView hotListText2;
        @BindView(R.id.hotListText3)
        TextView hotListText3;
        HotListHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @NonNull
    @Override
    protected HotListHolder onCreateViewHolder(@NonNull LayoutInflater inflater, @NonNull ViewGroup parent) {
        context = parent.getContext();
        View view = inflater.inflate(R.layout.hotlist_item, parent, false);
        return new HotListHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull HotListHolder holder, @NonNull HotList item) {
        holder.hotListTitle.setText(item.getTitle());
        holder.hotMore.setText(item.getMore());
        Glide.with(context).load(item.getImage1()).into(holder.hotListImage1);
        holder.hotListText1.setText(item.getText1());
        holder.hotListText2.setText(item.getText2());
        holder.hotListText3.setText(item.getText3());
    }
}
