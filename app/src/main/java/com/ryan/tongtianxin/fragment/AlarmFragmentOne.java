package com.ryan.tongtianxin.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.activity.AlarmOneDetailActivity;
import com.ryan.tongtianxin.adapter.AlarmOneAdapter;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.ArrayList;
import java.util.List;

public class AlarmFragmentOne extends BaseFragment {
    private RecyclerView alarmRecyclerView;
    private SwipeRefreshLayout sRefresh;
    private Context context;
    List<AlarmOneBean> data = new ArrayList<>();
    private AlarmOneAdapter adapter;

    @Override
    protected int attachLayoutRes() {
        return R.layout.alarm_fragment_one;
    }

    @Override
    protected void initView(View view) {
        context = getActivity();
        alarmRecyclerView = view.findViewById(R.id.alarm_recyclerView);
        sRefresh = view.findViewById(R.id.sRefresh);
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
                    "这个十四岁开始垃圾分类收集宽大楼房拉卡拉可恢复打瞌睡JFK是大家看法和快速的就开始雕刻技法和数据库的发挥空间士大夫" + i, "1" + i);
            data.add(bean);
        }
        initViewData(data);
    }

    private void initViewData(List<AlarmOneBean> data) {
        alarmRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        alarmRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new AlarmOneAdapter((Activity) context, data);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
//                String id = String.valueOf(buyListBeans.getResult().getData().get(position).getId());
                Intent intent = new Intent(context, AlarmOneDetailActivity.class);
////                intent.putExtra("id", id);
                startActivity(intent);
            }
        });
        alarmRecyclerView.setAdapter(adapter);
    }

    @Override
    protected void initListener() {

    }
}
