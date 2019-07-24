package com.ryan.tongtianxin.activity;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.fragment.AlarmFragment;
import com.ryan.tongtianxin.fragment.HomeFragment;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {
    Context context = MainActivity.this;
    private BottomNavigationBar bottomNavigationBar;
    private FrameLayout fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        InitNavigationBar();
    }

    private void initView() {
        fragmentContainer = findViewById(R.id.container);
        bottomNavigationBar = findViewById(R.id.navigationBar);
    }


    private void InitNavigationBar() {
        bottomNavigationBar.setTabSelectedListener(this)
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setBarBackgroundColor(R.color.colorPrimary)
                .setActiveColor(R.color.white)
                .setInActiveColor(R.color.gray_line)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.home, "首页").setActiveColorResource(R.color.white))
                .addItem(new BottomNavigationItem(R.mipmap.me, "报警").setActiveColorResource(R.color.white))
                .setFirstSelectedPosition(0)
                .initialise();
        setDefaultFragment();
    }

    /**
     * 设置默认的
     */
    private void setDefaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        HomeFragment homeFragment = new HomeFragment();
        transaction.replace(R.id.container, homeFragment);
        transaction.commit();
    }

    @Override
    public void onTabSelected(int position) {
        Log.d("onTabSelected", "onTabSelected: " + position);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                HomeFragment homeFragment = new HomeFragment();
                transaction.replace(R.id.container, homeFragment);
                break;
            case 1:
                AlarmFragment controlFragment = new AlarmFragment();
                transaction.replace(R.id.container, controlFragment);
                break;
            default:
                break;
        }
        // 事务提交
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {
        Log.d("onTabUnselected", "onTabUnselected: " + position);
    }

    @Override
    public void onTabReselected(int position) {
        Log.d("onTabReselected", "onTabReselected: " + position);
    }
}


