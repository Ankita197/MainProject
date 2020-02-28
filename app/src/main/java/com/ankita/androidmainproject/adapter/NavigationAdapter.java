package com.ankita.androidmainproject.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.R;

import java.util.List;


public class NavigationAdapter extends RecyclerView.Adapter<NavigationAdapter.MyViewHolder> {
    private Context context;
    private List<Data> mData;
    private RvClickListener clickListener;
    private int selectedPos = 0;

    public NavigationAdapter(Context context, List<Data> data, RvClickListener clickListener) {
        this.context = context;
        this.mData = data;
        this.clickListener = clickListener;
    }

    public void selectedItem() {
        notifyDataSetChanged();
    }

    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_navigation, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

        Data all = mData.get(position);
        holder.mTextView.setText(all.txt);
        holder.imageView.setImageResource(all.imageId);
        if (selectedPos == position) {
            holder.itemView.setSelected(true);
            holder.itemView.setBackgroundColor(Color.rgb(0, 0, 0));
        } else {
            holder.itemView.setSelected(false);
            holder.itemView.setBackgroundColor(context.getResources().getColor(R.color.transparent));
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onItemClick(position, v);
                selectedPos = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView mTextView;
        private ImageView imageView;

        private MyViewHolder(View v) {
            super(v);

            mTextView = v.findViewById(R.id.tvnav);
            imageView = v.findViewById(R.id.iv);
        }
    }
}