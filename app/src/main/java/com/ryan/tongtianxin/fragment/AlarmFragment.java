package com.ryan.tongtianxin.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.adapter.MyPagerAdapter;

import java.util.ArrayList;

public class AlarmFragment extends BaseFragment {
    private Activity context;
    private com.flyco.tablayout.SegmentTabLayout commonTabLayout;
    private ViewPager viewPager;
    private String[] mTitles = {"行车事件", "行车安全"};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private View mDecorView;
    private ArrayList<Fragment> mFragments;
//    private FragmentManager fm;
    @Override
    protected int attachLayoutRes() {
        return R.layout.alarm_fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         context = getActivity();
//         fm = getFragmentManager();
    }

    @Override
    protected void initView(View view) {
        commonTabLayout = view.findViewById(R.id.sl_1);
        viewPager = view.findViewById(R.id.vp_1);
        mFragments = new ArrayList<>();
        mFragments.add(new AlarmFragmentOne());
        mFragments.add(new AlarmFragmentTwo());
        viewPager.setAdapter(new MyPagerAdapter(fm,mTitles,mFragments));
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

//        viewPager.setCurrentItem(1);

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initListener() {

    }
}
