package com.ryan.tongtianxin.fragment;


import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.activity.FiveActivity;
import com.ryan.tongtianxin.activity.TabTestActivity;

public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout look, chart;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_to_activity: {
                Intent intent = new Intent(getActivity(), TabTestActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.chart: {
                Intent intent = new Intent(getActivity(), FiveActivity.class);
                startActivity(intent);
                break;
            }

        }
    }

    @Override
    protected int attachLayoutRes() {
        return R.layout.home_fragment;
    }

    @Override
    protected void initView(View view) {
        look = view.findViewById(R.id.ll_to_activity);
        chart = view.findViewById(R.id.chart);
        look.setOnClickListener(this);
        chart.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initListener() {

    }
}
