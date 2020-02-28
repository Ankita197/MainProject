package com.ankita.androidmainproject.Fragement.FavoriteFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.FavoriteAdepter;

import java.util.ArrayList;


public class FavioriteFragment extends Fragment {
private RecyclerView recyclerView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view= inflater.inflate(R.layout.fragment_faviorite, container, false);
       recyclerView=view.findViewById(R.id.recyclerView);
      ArrayList<Integer> imgid = new ArrayList<>();
        imgid.add(R.drawable.foodimage);
        imgid.add(R.drawable.berger);
        imgid.add(R.drawable.pannir_ticca);
        imgid.add(R.drawable.cheesy_garlic_bread);
        imgid.add(R.drawable.french_fries);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        FavoriteAdepter favoriteAdepter=new FavoriteAdepter(getActivity(),imgid);
        recyclerView.setAdapter(favoriteAdepter);
       return view;
    }




}
