package com.ryan.tongtianxin.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.adapter.AlarmTwoDetailAdapter;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.ArrayList;
import java.util.List;

public class AlarmTwoDetailActivity extends AppCompatActivity implements View.OnClickListener {
private RecyclerView recyclerView;
    List<AlarmOneBean> data = new ArrayList<>();
    private Activity context;
    private AlarmTwoDetailAdapter adapter;
    private int isShowLayout;
    private LinearLayout carDetail,carAllDetail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_two_detail);
       initView();
    }

    private void initView() {
        context = AlarmTwoDetailActivity.this;
        isShowLayout = 1;
        recyclerView = findViewById(R.id.alarm_two_detail_recyclerView);
        carDetail = findViewById(R.id.carDetail_ll);
        carAllDetail = findViewById(R.id.carAllDetail_ll);
        carDetail.setOnClickListener(this);
        getDetailData();
    }
    private void getDetailData() {
        for (int i = 1; i < 10; i++) {
            AlarmOneBean bean = new AlarmOneBean("FCW-前碰撞预警" + i, "当时车速：37km/h" + i, "2019-07-12 17:31:09" + i,
                    "这个十四岁开始垃圾分类收集宽大楼房拉卡" +
                            "拉可恢复打瞌睡库哈斯客户反馈绝杀看见帝国海军杀害大哥JFK是大家看法和快速的就开始雕刻技法和数据库的发挥空间士大夫" + i, "1" + i);
            data.add(bean);
        }
        initViewData(data);
    }

    private void initViewData(final List<AlarmOneBean> data) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        adapter = new AlarmTwoDetailAdapter((Activity) context, data);
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                Intent intent = new Intent(context,TabTestActivity.class);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.carDetail_ll :
                switchSelect();
                break;
        }
    }

    private void switchSelect() {
        if(isShowLayout == 1){
            carAllDetail.setVisibility(View.VISIBLE);
            isShowLayout = 2;
        }else if(isShowLayout == 2){
            carAllDetail.setVisibility(View.GONE);
            isShowLayout = 1;
        }
    }
}
