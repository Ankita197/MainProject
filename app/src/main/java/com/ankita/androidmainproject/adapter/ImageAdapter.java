package com.ankita.androidmainproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.ankita.androidmainproject.R;

public class ImageAdapter extends PagerAdapter {
    private LayoutInflater mLayoutInflater;
    Context context;
    private int[] GalImages = new int[] {
            R.drawable.foodimage,
            R.drawable.berger,
            R.drawable.french_fries,
            R.drawable.pannir_ticca,
            R.drawable.cheesy_garlic_bread
    };
    public ImageAdapter(Context context){
        this.context=context;
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return GalImages.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==(object);
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View itemView = mLayoutInflater.inflate(R.layout.item_offers, container, false);

        ImageView imageView =itemView.findViewById(R.id.ivOffers);
        imageView.setImageResource(GalImages[position]);

        container.addView(itemView);

        return itemView;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
