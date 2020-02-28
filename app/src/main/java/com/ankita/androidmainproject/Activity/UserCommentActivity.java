package com.ankita.androidmainproject.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ankita.androidmainproject.DataBaseModel.AppDataBase;
import com.ankita.androidmainproject.DataBaseModel.Comments;
import com.ankita.androidmainproject.DataBaseModel.Favorite;
import com.ankita.androidmainproject.Fragement.FavoriteFragments.FavioriteFragment;
import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.ItemCommentAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.ArrayList;
import java.util.List;

public class UserCommentActivity extends AppCompatActivity implements View.OnClickListener {
    ItemCommentAdapter itemCommentAdapter;
    private EditText edtComment;
    private Button btnSend, btnAddToFavorite;
    private RecyclerView recyclerView;
    private List<Comments> comments;
    private Comments comment;
    private Favorite favorite;
    private CollapsingToolbarLayout toolbar;
    private AppBarLayout appBarLayout;

    private void init() {
        edtComment = findViewById(R.id.edtComment);
        btnSend = findViewById(R.id.btnSend);
        recyclerView = findViewById(R.id.list);
        toolbar = findViewById(R.id.collapsingtoolbar);
        appBarLayout = findViewById(R.id.appBarLayout);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorite);
    }

    private boolean isFavorite(int id) {
        favorite = AppDataBase.getAppDatabase(getApplicationContext()).favoriteDao().getFavoriteById(id);
        return favorite != null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_comment);
        init();
        toolbar.setTitleEnabled(false);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = false;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    isShow = true;
                } else if (isShow) {
                    isShow = false;
                }
            }
        });
        comments = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        btnSend.setOnClickListener(this);
        btnAddToFavorite.setOnClickListener(this);
        comments = AppDataBase.getAppDatabase(getApplicationContext()).commentDao().getAll();
        if (comments.size() > 0) {
            itemCommentAdapter = new ItemCommentAdapter(this, comments);
            recyclerView.setAdapter(itemCommentAdapter);
        }
        // 1. check whether id available in favorite table or not
        if (getIntent().getExtras() != null && getIntent().getExtras().containsKey(EntreesActivity.ARGS_FOOD_ID)) {

            if (isFavorite(Integer.parseInt(getIntent().getStringExtra(EntreesActivity.ARGS_FOOD_ID)))) {
                btnAddToFavorite.setText("Remove from Favorite");
                btnAddToFavorite.setTextColor(getResources().getColor(R.color.black));
            } else {
                btnAddToFavorite.setText("Add To Favorite");
                btnAddToFavorite.setTextColor(getResources().getColor(R.color.black));
            }

        }
        // 2. if available then delete while clicking favorite button
        //3. else insert

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSend:
                if (getIntent().getStringExtra("foodId") != null) {
                    comment = new Comments(0, Integer.parseInt(getIntent().getStringExtra(EntreesActivity.ARGS_FOOD_ID)), "Allison Grayce", edtComment.getText().toString());
                }
                comments.add(comment);
                AppDataBase.getAppDatabase(getApplicationContext()).commentDao().insertAll(comment);
                itemCommentAdapter.notifyItemInserted(comments.size() - 1);
                break;
            case R.id.btnAddToFavorite:
                if (isFavorite(Integer.parseInt(getIntent().getStringExtra(EntreesActivity.ARGS_FOOD_ID)))) {
                    AppDataBase.getAppDatabase(getApplicationContext()).favoriteDao().delete(favorite);
                    btnAddToFavorite.setText("Add To Favorite");
                    btnAddToFavorite.setTextColor(getResources().getColor(R.color.black));
                    Log.d("@!!!","data deleted successfully");
                } else {
                    Favorite favorite = new Favorite(Integer.parseInt(getIntent().getStringExtra(EntreesActivity.ARGS_FOOD_ID)));
                    AppDataBase.getAppDatabase(getApplicationContext()).favoriteDao().insertAll(favorite);
                    btnAddToFavorite.setText("Remove from Favorite");
                    btnAddToFavorite.setTextColor(getResources().getColor(R.color.black));
                    Log.d("@!!!","data added successfully");
                    switchFragmentFavorite();
                }
                break;
        }
    }
    private void switchFragmentFavorite(){
        FavioriteFragment favioriteFragment = new FavioriteFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, favioriteFragment, FavioriteFragment.class.getSimpleName());
        fragmentTransaction.commit();
    }
}
