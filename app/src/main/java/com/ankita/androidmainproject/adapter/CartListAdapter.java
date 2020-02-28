package com.ankita.androidmainproject.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.ankita.androidmainproject.R;

import java.util.ArrayList;

public class CartListAdapter extends ArrayAdapter<CartItemData> {
    private ArrayList<CartItemData> cartList;
    private OnItemClickListener onItemClickListener;


    public CartListAdapter(Activity context, ArrayList<CartItemData> dataModel) {
        super(context, R.layout.my_listcart, dataModel);
        this.cartList = dataModel;

    }

    @NonNull
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        final CartItemData cartItemData = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        final ViewHolder viewHolder; // view lookup cache stored in tag
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.my_listcart, parent, false);
            viewHolder.tvtitle = convertView.findViewById(R.id.tvfoodname);
            viewHolder.tvsubtitle = convertView.findViewById(R.id.tvfoodtype);
            viewHolder.txtPrice = convertView.findViewById(R.id.tvPrice);
            viewHolder.tvQty = convertView.findViewById(R.id.tvQty);
            viewHolder.iv = convertView.findViewById(R.id.ivcart);
            viewHolder.btnminus = convertView.findViewById(R.id.btnminus);
            viewHolder.btnplus = convertView.findViewById(R.id.btnplus);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        assert cartItemData != null;
        viewHolder.tvtitle.setText(cartItemData.getTitle());
        viewHolder.tvsubtitle.setText(cartItemData.getSubtitle());
        String strPrice = "$" + cartItemData.getPrice();
        viewHolder.txtPrice.setText(strPrice);
        viewHolder.tvQty.setText(String.valueOf(cartItemData.getQty()));
        viewHolder.btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClickListener(v, position, cartList);
            }
        });

        viewHolder.btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onItemClickListener(v, position, cartList);
            }
        });
        return convertView;


    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        void onItemClickListener(View view, int position, ArrayList<CartItemData> cartList);
    }

    private static class ViewHolder {
        TextView txtPrice, tvtitle, tvsubtitle, tvQty;
        Button btnplus, btnminus;
        ImageView iv;
    }
}

