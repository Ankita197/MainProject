package com.ankita.androidmainproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.model.FavouriteData;

import java.util.ArrayList;

public class FavoriteEditAdapter extends RecyclerView.Adapter<FavoriteEditAdapter.MyViewHolder> {
    private Context context;
    private ArrayList<FavouriteData> favDataList;
    private RvClickListener rvClickListener;

    public FavoriteEditAdapter(Context context, ArrayList<FavouriteData> imgId, RvClickListener rvClickListener) {
        this.context = context;
        this.favDataList = imgId;
        this.rvClickListener = rvClickListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.favorite_edititem, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.ivFavoriteEdit.setImageResource(favDataList.get(position).getImage());
        holder.tvFoodName.setText(favDataList.get(position).getFoodName());
        holder.cbChecked.setOnCheckedChangeListener(null);
        holder.cbChecked.setChecked(favDataList.get(position).isSelected());
        holder.cbChecked.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    favDataList.get(position).setSelected(true);
                    rvClickListener.onItemClick(position, buttonView);
                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return favDataList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        CheckBox cbChecked;
        private ImageView ivFavoriteEdit;
        private TextView tvFoodName;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFavoriteEdit = itemView.findViewById(R.id.ivFavoriteEdit);
            tvFoodName = itemView.findViewById(R.id.tvfoodname);
            cbChecked = itemView.findViewById(R.id.cbChecked);

        }
    }
}
