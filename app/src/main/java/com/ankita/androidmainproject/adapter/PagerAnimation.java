package com.ankita.androidmainproject.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

public class PagerAnimation implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9f;
    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position < -1) { // [-Infinity,-1)
            page.setTranslationX(1150 * -position);

            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

        } else if (position <= 0) { // [-1,0]
            page.setAlpha(1 - position);

            page.setTranslationX(1150 * -position);

            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            page.setScaleX(scaleFactor);
            page.setScaleY(scaleFactor);

        } else if (position <= 1) { // (0,1]
            page.setAlpha(1);
            page.setTranslationX(1);
            page.setScaleX(1);
            page.setScaleY(1);

        } else { // (1,+Infinity]
            page.setAlpha(1);
        }

    }
}
