package com.ankita.androidmainproject.Fragement;

import android.os.Bundle;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.ImageAdapter;
import com.ankita.androidmainproject.adapter.PagerAnimation;

import java.util.ArrayList;


public class OffersFragment extends Fragment  {


private ViewPager viewPager;
ArrayList<Integer> arrayList;
LinearLayout linearLayout;
TextView[] dot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_offers, container, false);
        arrayList = new ArrayList<>();
        arrayList.add(R.color.red);
        arrayList.add(R.color.colorPrimaryDark);
        arrayList.add(R.color.colorAccent);
        arrayList.add(R.color.colorAccent);
        arrayList.add(R.color.colorAccent);
        viewPager = view.findViewById(R.id.viewPager);
        linearLayout=view.findViewById(R.id.layout_dot);
       ImageAdapter imageAdapter = new ImageAdapter(getActivity());
        viewPager.setAdapter(imageAdapter);
       /* viewPager.setPageTransformer(false,new ViewPager.PageTransformer(){
            @Override
            public void transformPage(View page, float position) {
                final float normalizedposition = Math.abs(Math.abs(position) - 1);
                page.setScaleX(normalizedposition / 2 + 0.5f);
                page.setScaleY(normalizedposition / 2 + 0.5f);
            }
                }
        ); */
       viewPager.setPageTransformer(false,new PagerAnimation());
        addDot(0);
            viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                }

                @Override
                public void onPageSelected(int position) {
                    addDot(position);
                }

                @Override
                public void onPageScrollStateChanged(int state) {

                }
            });
        return view;
    }
    public void addDot(int page_position) {
        dot = new TextView[arrayList.size()];
        linearLayout.removeAllViews();
        for (int i = 0; i < dot.length; i++) {
            dot[i] = new TextView(getActivity());
            dot[i].setText(Html.fromHtml("&#9673;"));
            dot[i].setTextSize(24);
            dot[i].setTextColor(getResources().getColor(R.color.gray));
           linearLayout.addView(dot[i]);
        }
        //active dot
        dot[page_position].setTextColor(getResources().getColor(R.color.green_4caf50));
    }


}
