package com.ankita.androidmainproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.R;

import java.util.ArrayList;

public class FavoriteAdepter extends RecyclerView.Adapter<FavoriteAdepter.MyViewHolder> {

private Context context;
private ArrayList<Integer> imgid;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.itemfavorite, parent, false);
        return new MyViewHolder(view);

    }
    public FavoriteAdepter(Context context, ArrayList<Integer> imgid) {
        this.context = context;
       this.imgid=imgid;
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Integer id=imgid.get(position);
        holder.iv.setImageResource(id);
    }

    @Override
    public int getItemCount() {
        return imgid.size();
    }

   static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView iv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           iv= itemView.findViewById(R.id.ivFavorite);
        }
    }
}
