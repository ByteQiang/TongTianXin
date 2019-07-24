package com.ryan.tongtianxin.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.activity.AlarmTwoDetailActivity;
import com.ryan.tongtianxin.adapter.AlarmThreeAdapter;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.ArrayList;
import java.util.List;

public class AlarmFragmentTwo extends BaseFragment {
    private RecyclerView alarmRecyclerView;
    private SwipeRefreshLayout sRefresh;
    private Context context;
    List<AlarmOneBean> data = new ArrayList<>();
    private AlarmThreeAdapter adapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.alarm_fragment_two;
    }

    @Override
    protected void initView(View view) {
        alarmRecyclerView = view.findViewById(R.id.alarm_three_recyclerView);
        sRefresh = view.findViewById(R.id.sRefresh);
        context = getActivity();
        sRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
              initData();
                sRefresh.setRefreshing(false);
            }
        });
        sRefresh.setColorSchemeResources(
                R.color.colorAccent);
    }

    @Override
    protected void initData() {
        for (int i = 1; i < 10; i++) {
            AlarmOneBean bean = new AlarmOneBean("粤S8898" + i, "广东省" + i, "33：4" + i,
                    "这个十四岁开始垃圾分类收集宽大楼房拉卡" + i, "案件卡里工行卡是丢恶化" + i);
            data.add(bean);
        }
        initViewData(data);
    }
    private void initViewData(List<AlarmOneBean> data) {
        alarmRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        alarmRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new AlarmThreeAdapter(context, data);
        adapter.setOnItemClickListener(new AlarmThreeAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(context, AlarmTwoDetailActivity.class);
                startActivity(intent);
            }
        });
        alarmRecyclerView.setAdapter(adapter);
    }
    @Override
    protected void initListener() {

    }
}
