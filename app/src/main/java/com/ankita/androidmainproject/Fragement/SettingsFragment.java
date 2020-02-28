package com.ankita.androidmainproject.Fragement;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ankita.androidmainproject.Fragement.FragmentsOfSettings.AddCardFragment;
import com.ankita.androidmainproject.Fragement.FragmentsOfSettings.MyAddressFragment;
import com.ankita.androidmainproject.R;
import com.google.android.material.tabs.TabLayout;


public class SettingsFragment extends Fragment {

private TabLayout tabLayout;
private Button btnAddAddress;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_settings, container, false);
        initView(v);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch(tab.getPosition()){
                    case 0:
                        if(btnAddAddress.getText().toString().equals("Add Card"))
                        {
                            btnAddAddress.setText("Add Address");
                            btnAddAddress.setTextColor(Color.WHITE);
                        }
                        switchFragment(new MyAddressFragment());
                        break;
                    case 1:
                        if(btnAddAddress.getText().toString().equals("Add Address"))
                        {
                            btnAddAddress.setText("Add Card");
                            btnAddAddress.setTextColor(Color.WHITE);
                        }
                        switchFragment(new AddCardFragment());
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
        switchFragment(new MyAddressFragment());
        return v;
    }

    private void initView(View v) {
        tabLayout=v.findViewById(R.id.tablayout);
        btnAddAddress=v.findViewById(R.id.btnAddAddress);
    }

    private void switchFragment(Fragment fragment) {
        FragmentManager fragmentManager=getChildFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container,fragment,MyAddressFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }


}
