package com.ankita.androidmainproject.Fragement.FavoriteFragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.FavoriteEditAdapter;
import com.ankita.androidmainproject.adapter.RvClickListener;
import com.ankita.androidmainproject.model.FavouriteData;

import java.util.ArrayList;

public class FavoriteEditFragment extends Fragment implements View.OnClickListener {
    private RecyclerView rvItemEdit;
    private ArrayList<FavouriteData> imgId;
    private LinearLayoutManager layoutManager;
    private Button btnItemDelete;
    private String btnText;
    private FavoriteEditAdapter favoriteEditAdapter;
    private ArrayList<Integer> positionArray;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favorite_edit, container, false);
        init(view);
        setAdepter();
        btnItemDelete.setOnClickListener(this);
        return view;
    }

    private void setAdepter() {
        imgId.add(new FavouriteData(R.drawable.foodimage, "test food one", "Veg"));
        imgId.add(new FavouriteData(R.drawable.berger, "test food two", "Veg"));
        imgId.add(new FavouriteData(R.drawable.pannir_ticca, "test food Three", "Veg"));
        imgId.add(new FavouriteData(R.drawable.cheesy_garlic_bread, "test food Four", "Veg"));
        imgId.add(new FavouriteData(R.drawable.french_fries, "test food Five", "Veg"));
        imgId.add(new FavouriteData(R.drawable.foodimage, "test food six", "Veg"));
        imgId.add(new FavouriteData(R.drawable.berger, "test food seven", "Veg"));
        imgId.add(new FavouriteData(R.drawable.pannir_ticca, "test food eight", "Veg"));
        imgId.add(new FavouriteData(R.drawable.cheesy_garlic_bread, "test food 9", "Veg"));
        imgId.add(new FavouriteData(R.drawable.french_fries, "test food 10", "Veg"));
        imgId.add(new FavouriteData(R.drawable.foodimage, "test food 11", "Veg"));
        imgId.add(new FavouriteData(R.drawable.berger, "test food 12", "Veg"));
        imgId.add(new FavouriteData(R.drawable.pannir_ticca, "test food 13", "Veg"));
        imgId.add(new FavouriteData(R.drawable.cheesy_garlic_bread, "test food 14", "Veg"));
        imgId.add(new FavouriteData(R.drawable.french_fries, "test food 15", "Veg"));
        rvItemEdit.setLayoutManager(layoutManager);
        favoriteEditAdapter = new FavoriteEditAdapter(getActivity(), imgId, new RvClickListener() {
            @Override
            public void onItemClick(int pos, View view) {
                positionArray.add(pos);
                btnText = getString(R.string.delete_value_items, String.valueOf(positionArray.size()));
                btnItemDelete.setText(btnText);
            }
        });
        rvItemEdit.setAdapter(favoriteEditAdapter);
    }

    private void init(View view) {
        rvItemEdit = view.findViewById(R.id.rvItemEdit);
        layoutManager = new LinearLayoutManager(getActivity());
        imgId = new ArrayList<>();
        positionArray = new ArrayList<>();
        btnItemDelete = view.findViewById(R.id.btnItemDelete);
    }

    @Override
    public void onClick(View v) {
        for (Integer i : positionArray) {
            imgId.remove(i);
            favoriteEditAdapter.notifyItemRemoved(i);
        }
        btnText = "Deleted item";
        btnItemDelete.setText(btnText);
    }
}
