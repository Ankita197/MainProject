package com.ankita.androidmainproject.Fragement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.ankita.androidmainproject.Fragement.ThreeFragments.SecondOfLastOrders;
import com.ankita.androidmainproject.R;
import com.google.android.material.tabs.TabLayout;


public class LastOrders extends Fragment {
    private TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View v= inflater.inflate(R.layout.fragment_last__orders, container, false);
       tabLayout=v.findViewById(R.id.tablayout);
        TabLayout.Tab tab = tabLayout.getTabAt(0);
        tab.select();
        switchFragment();
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
              switch (tab.getPosition()){
                      case 0:
                      case 1:
                      case 2:
                          switchFragment();
                      break;

              }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        return v;
    }
    private void switchFragment(){
        SecondOfLastOrders fragment2=new SecondOfLastOrders();
        FragmentManager fragmentManager=getChildFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment2,"tag");
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }



}
