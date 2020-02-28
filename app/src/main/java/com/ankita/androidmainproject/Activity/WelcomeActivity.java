package com.ankita.androidmainproject.Activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ankita.androidmainproject.Fragement.FavoriteFragments.FavoriteEditFragment;
import com.ankita.androidmainproject.Fragement.CartFragment;
import com.ankita.androidmainproject.Fragement.FavoriteFragments.FavioriteFragment;
import com.ankita.androidmainproject.Fragement.LastOrders;
import com.ankita.androidmainproject.Fragement.MenuFragment;
import com.ankita.androidmainproject.Fragement.OffersFragment;
import com.ankita.androidmainproject.Fragement.SettingsFragment;
import com.ankita.androidmainproject.Fragement.SupportFragment;
import com.ankita.androidmainproject.R;
import com.ankita.androidmainproject.adapter.RvClickListener;
import com.ankita.androidmainproject.adapter.Data;
import com.ankita.androidmainproject.adapter.NavigationAdapter;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class WelcomeActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener ,View.OnClickListener{
    private String tag;
    private DrawerLayout mDrawerLayout;
    private NavigationView nav_view;
    private RecyclerView list;
    private NavigationAdapter recyclerAdapter;
    private ActionBarDrawerToggle mDrawerToggle;
    private View mainView;
    private Toolbar toolbar;
    private TextView mTitle,tvEdit;

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        mTitle = toolbar.findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.rgb(255, 255, 255));
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(false);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }


    private void switchFragment(Fragment fragment, String tag, Boolean isAddBackStack) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.container, fragment, tag);
        if (isAddBackStack)
            transaction.addToBackStack(fragment.getClass().getName());
        transaction.commit();
    }


    private void loadFragment(int position) {
        switch (position) {
            case 0:
                mTitle.setText("Menu");
                tag= MenuFragment.class.getSimpleName();
                switchFragment(new MenuFragment(),tag, true);
                getAnimation();
                break;
            case 1:
                mTitle.setText("Offers");
                tag=OffersFragment.class.getSimpleName();
                switchFragment(new OffersFragment(), tag, true);
                break;
            case 2:
                mTitle.setText("Cart");
                tag=CartFragment.class.getSimpleName();
                switchFragment(new CartFragment(),tag, true);
                setTextEditCart();
                getAnimation();
                break;
            case 3:
                mTitle.setText("Last Orders");
                tag= LastOrders.class.getSimpleName();
                switchFragment(new LastOrders(), tag, true);
                getAnimation();
                break;
            case 4:
                mTitle.setText("Favorite");
                tag=FavioriteFragment.class.getSimpleName();
                switchFragment(new FavioriteFragment(), tag, true);
                setTextEdit();
                getAnimation();
                break;
            case 5:
                mTitle.setText("Settings");
                tag=SettingsFragment.class.getSimpleName();
                switchFragment(new SettingsFragment(),tag, true);
                setIconNotVisible();
                break;
            case 6:
                mTitle.setText("Support");
                tag=SupportFragment.class.getSimpleName();
                switchFragment(new SupportFragment(),tag , true);
                setIconNotVisible();
                break;
            case 7:
                sharedPreferenceStoreValue.clearSharedPreference();
                Intent intent = new Intent(WelcomeActivity.this, SignInActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
                break;
        }
    }

    private void setTextEditCart() {
        ImageView iv=toolbar.findViewById(R.id.search_icon);
        iv.setVisibility(View.GONE);
        tvEdit=new TextView(this);
        tvEdit.setText("Edit");
        tvEdit.setId(R.id.tvEditCart);
        tvEdit.setTextColor(getResources().getColor(R.color.white));
        tvEdit.setTextSize(24);
        tvEdit.setClickable(true);
        Toolbar.LayoutParams l1=new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        l1.gravity = Gravity.END;
        l1.setMarginEnd(10);
        tvEdit.setLayoutParams(l1);
        toolbar.addView(tvEdit);
        tvEdit.setOnClickListener(this);
    }

    private void setIconNotVisible() {
        ImageView iv=toolbar.findViewById(R.id.search_icon);
        iv.setVisibility(View.GONE);
    }


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        mainView = findViewById(R.id.mainview);
        setToolbar();
        setNavHeader();
        /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }*/
        switchFragment(new MenuFragment(), MenuFragment.class.getSimpleName(), true);

        mDrawerLayout = findViewById(R.id.drawerLayout);
        list = findViewById(R.id.list);
        final ArrayList<Data> nav_item = new ArrayList<>();
        nav_item.add(new Data(R.drawable.menu_icon, "Menu"));
        nav_item.add(new Data(R.drawable.offer_icon, "Offers"));
        nav_item.add(new Data(R.drawable.cart_icon, "My Cart"));
        nav_item.add(new Data(R.drawable.order_icon, "Last Order"));
        nav_item.add(new Data(R.drawable.favorite_icon, "Favorite"));
        nav_item.add(new Data(R.drawable.settings, "Settings"));
        nav_item.add(new Data(R.drawable.support_icon, "Support"));
        nav_item.add(new Data(R.drawable.logout_icon, "Logout"));

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        list.setLayoutManager(layoutManager);
        //position to be clicked
        recyclerAdapter = new NavigationAdapter(WelcomeActivity.this, nav_item, new RvClickListener() {
            @Override

            public void onItemClick(int position, View view) {
                recyclerAdapter.selectedItem();
                loadFragment(position);
                mDrawerLayout.closeDrawer(GravityCompat.START);
            }

        });
        list.setAdapter(recyclerAdapter);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
            public void onDrawerClosed(View view) {
                supportInvalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                supportInvalidateOptionsMenu();
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                mainView.setTranslationX(slideOffset * drawerView.getWidth());
            }

        };
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        mDrawerLayout.setDrawerElevation(0f);
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        return false;
    }

    private void setNavHeader() {
        nav_view = findViewById(R.id.navview);
        View header = nav_view.findViewById(R.id.header);
        TextView number = header.findViewById(R.id.number);
        number.setText(sharedPreferenceStoreValue.getValue());
    }

    @Override
    public void onBackPressed() {
        if(tag.equals(MenuFragment.class.getSimpleName())||tag.equals(CartFragment.class.getSimpleName())||tag.equals(OffersFragment.class.getSimpleName())){
            finish();
            super.onBackPressed();
        }
    }
    private void setTextEdit(){
        ImageView iv=toolbar.findViewById(R.id.search_icon);
        iv.setVisibility(View.GONE);
        tvEdit=new TextView(this);
        tvEdit.setText("Edit");
        tvEdit.setId(R.id.tvEdit);
        tvEdit.setTextColor(getResources().getColor(R.color.white));
        tvEdit.setTextSize(24);
        tvEdit.setClickable(true);
        Toolbar.LayoutParams l1=new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
        l1.gravity = Gravity.END;
        l1.setMarginEnd(10);
        tvEdit.setLayoutParams(l1);
        toolbar.addView(tvEdit);
        tvEdit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tvEdit:
                if(tvEdit.getText().toString().equals("Edit"))
                {
                    tvEdit.setText("Cancel");
                    switchFragment(new FavoriteEditFragment(),FavoriteEditFragment.class.getSimpleName(),true);
                }
                else if(tvEdit.getText().toString().equals("Cancel"))
                {
                    tvEdit.setText("Edit");
                    switchFragment(new FavioriteFragment(),FavioriteFragment.class.getSimpleName(),true);
                }
                break;
        }
    }
    private void getAnimation(){
        overridePendingTransition(R.anim.slide_left_in, R.anim.slide_left_out);
    }
}