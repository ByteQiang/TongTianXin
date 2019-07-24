package com.ryan.tongtianxin.activity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.adapter.AlarmTwoAdapter;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.ArrayList;
import java.util.List;

public class AlarmOneDetailActivity extends AppCompatActivity {
    private RecyclerView alarmRecyclerView;
    private SwipeRefreshLayout sRefresh;
    private Context context;
    List<AlarmOneBean> data = new ArrayList<>();
    private AlarmTwoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_one_detail);
        initView();
        getDetailData();
    }

    private void initView() {
        context = AlarmOneDetailActivity.this;
        alarmRecyclerView = findViewById(R.id.alarm_detail_recyclerView);
        sRefresh = findViewById(R.id.sRefresh);
        sRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
            }
        });
        sRefresh.setColorSchemeResources(
                R.color.colorAccent);
    }

    private void refreshData() {
        getDetailData();
        sRefresh.setRefreshing(false);
    }

    private void getDetailData() {
        for (int i = 1; i < 10; i++) {
            AlarmOneBean bean = new AlarmOneBean("06-17\n22:2" + i, "引擎失火" + i, "未知司机" + i,
                    "这个十四岁开始垃圾分类收集宽大楼房拉卡" +
                            "拉可恢复打瞌睡库哈斯客户反馈绝杀看见帝国海军杀害大哥JFK是大家看法和快速的就开始雕刻技法和数据库的发挥空间士大夫" + i, "1" + i);
            data.add(bean);
        }
        initViewData(data);
    }

    private void initViewData(List<AlarmOneBean> data) {
        alarmRecyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        alarmRecyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new AlarmTwoAdapter((Activity) context, data);
        alarmRecyclerView.setAdapter(adapter);
    }
}
