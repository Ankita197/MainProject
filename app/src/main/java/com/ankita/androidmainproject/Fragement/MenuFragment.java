package com.ankita.androidmainproject.Fragement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.ankita.androidmainproject.Activity.EntreesActivity;
import com.ankita.androidmainproject.DataBaseModel.AppDataBase;
import com.ankita.androidmainproject.DataBaseModel.Entrees;
import com.ankita.androidmainproject.R;

import java.util.ArrayList;
import java.util.List;

public class MenuFragment extends Fragment {

    List<Entrees> entrees = new ArrayList<>();
    private TextView tvTotalEntrees;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_menu, container, false);
        ImageView img = v.findViewById(R.id.ivEntrees);
        tvTotalEntrees=v.findViewById(R.id.tvtotalentrees);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), EntreesActivity.class));
            }
        });
        entrees=AppDataBase.getAppDatabase(getActivity()).entreesDao().getAll();
        tvTotalEntrees.setText(String.valueOf(entrees.size()));
        if (entrees.size()== 0) {
            Entrees entrees = new Entrees(11, "Rieby Stick", 30, true);
            Entrees entrees1 = new Entrees(22, "French fries", 50, true);
            Entrees entrees2 = new Entrees(33, "panir tica", 120, true);
            Entrees entrees3 = new Entrees(44, "wood grils", 100, true);
            AppDataBase.getAppDatabase(getActivity()).entreesDao().insertAll(entrees, entrees1, entrees2, entrees3);
        }


        return v;
    }



}

