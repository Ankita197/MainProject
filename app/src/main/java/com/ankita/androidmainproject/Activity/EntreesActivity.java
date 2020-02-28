package com.ankita.androidmainproject.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import com.ankita.androidmainproject.DataBaseModel.AppDataBase;
import com.ankita.androidmainproject.DataBaseModel.Entrees;
import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.MyListAdepter;
import java.util.List;
import java.util.Objects;

public class EntreesActivity extends AppCompatActivity {

    public static String ARGS_FOOD_ID = "foodId";

    ListView list;
    Integer[] imgId = {R.drawable.french_fries, R.drawable.cheesy_garlic_bread, R.drawable.foodimage, R.drawable.berger};
    private Toolbar toolbar;

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(Color.rgb(255, 255, 255));
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.left_black);
        toolbar.setNavigationIcon(drawable);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrees);

        list = findViewById(R.id.my_list);

        final List<Entrees> entrees = AppDataBase.getAppDatabase(getApplicationContext()).entreesDao().getAll();
        if (entrees.size() > 0) {
            MyListAdepter adapter = new MyListAdepter(this, entrees, imgId);
            list.setAdapter(adapter);
        }

        for (Entrees e1 : entrees) {
            if (e1 != null) {
                Log.d("data from entrees ", e1.getFoodname());
            } else {
                Log.d("###", "entrees object is null");

            }
        }

        setToolbar();

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(EntreesActivity.this, WelcomeActivity.class));
            }
        });

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Intent intent = new Intent(EntreesActivity.this, UserCommentActivity.class);
                    intent.putExtra(ARGS_FOOD_ID, String.valueOf(entrees.get(position).getEntreeid()));
                    startActivity(intent);
                } else if (position == 1) {
                    Toast.makeText(getApplicationContext(), "Place Your Second Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 2) {

                    Toast.makeText(getApplicationContext(), "Place Your Third Option Code", Toast.LENGTH_SHORT).show();
                } else if (position == 3) {

                    Toast.makeText(getApplicationContext(), "Place Your Forth Option Code", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
