package com.ryan.tongtianxin.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.adapter.MyPagerAdapter;
import com.ryan.tongtianxin.fragment.AlarmFragmentOne;
import com.ryan.tongtianxin.fragment.AlarmFragmentTwo;

import java.util.ArrayList;

public class TabTestActivity extends AppCompatActivity {
//    private com.flyco.tablayout.CommonTabLayout commonTabLayout;
private com.flyco.tablayout.SegmentTabLayout commonTabLayout;
    private ViewPager viewPager;
    private String[] mTitles = {"行车事件", "行车安全"};
    private int[] mIconUnselectIds = {
            R.mipmap.home, R.mipmap.me};
    private int[] mIconSelectIds = {
            R.mipmap.me, R.mipmap.home};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;
    private ArrayList<Fragment> mFragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_test);
        initView();

    }

    private void initView() {
        commonTabLayout = findViewById(R.id.tl_2);
        viewPager = findViewById(R.id.vp_2);
//        for (int i = 0; i < mTitles.length; i++) {
//            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
//        }
        mFragments = new ArrayList<>();
        mFragments.add(new AlarmFragmentOne());
        mFragments.add(new AlarmFragmentTwo());

//        mDecorView = getWindow().getDecorView();
//        viewPager = ViewFindUtils.find(mDecorView, R.id.vp_2);
        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager(),mTitles,mFragments));
        commonTabLayout.setTabData(mTitles);
        commonTabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                viewPager.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
                if (position == 0) {
//                    commonTabLayout.showMsg(0,   1);
//                    UnreadMsgUtils.show(commonTabLayout.getMsgView(0), mRandom.nextInt(100) + 1);
                }
            }
        });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                commonTabLayout.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

//        viewPager.setCurrentItem(0);
    }
//    private class MyPagerAdapter extends FragmentPagerAdapter {
//        public MyPagerAdapter(FragmentManager fm) {
//            super(fm);
//        }
//
//        @Override
//        public int getCount() {
//            return mFragments.size();
//        }
//
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mTitles[position];
//        }
//
//        @Override
//        public Fragment getItem(int position) {
//            return mFragments.get(position);
//        }
//    }

}
