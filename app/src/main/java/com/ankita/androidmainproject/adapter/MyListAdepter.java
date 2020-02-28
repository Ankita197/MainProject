package com.ankita.androidmainproject.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ankita.androidmainproject.DataBaseModel.Entrees;
import com.ankita.androidmainproject.R;

import java.util.List;
import java.util.Random;

public class MyListAdepter extends ArrayAdapter<String> {
    Integer[] imgid;
    List<Entrees> entrees;
    private Activity context;

    public MyListAdepter(Activity context, List<Entrees> entrees, Integer[] imgid) {
        super(context, R.layout.my_list);
        this.context = context;
        this.entrees = entrees;
        this.imgid = imgid;
    }

    @Override
    public int getCount() {
        return entrees.size();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.my_list, parent, false);

        TextView titleText = rowView.findViewById(R.id.tvTitleText);
        ImageView imageView = rowView.findViewById(R.id.imageView);
        TextView subtitleText = rowView.findViewById(R.id.tvDescription);
        TextView tvprice = rowView.findViewById(R.id.tvPrice);
        titleText.setText(entrees.get(position).getFoodname());

        try {
            imageView.setImageResource(imgid[new Random().nextInt(4)]);
        } catch (Exception e) {
            imageView.setImageResource(imgid[0]);
        }
        subtitleText.setText(String.valueOf(entrees.get(position).isVag()));
        tvprice.setText(String.valueOf(entrees.get(position).getPrice()));

        return rowView;
    }
}
