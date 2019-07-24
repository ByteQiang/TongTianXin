package com.ryan.tongtianxin.adapter;

import android.app.Activity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.List;

public class AlarmOneAdapter extends BaseQuickAdapter<AlarmOneBean, BaseViewHolder> {

    public AlarmOneAdapter(Activity context, List<AlarmOneBean> data) {
        super(R.layout.alarm_one_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper,AlarmOneBean item) {
        helper.setText(R.id.carNumber, item.getCarNumber());
        helper.setText(R.id.address, item.getAddress());
        helper.setText(R.id.time, String.valueOf(item.getTime()));
        helper.setText(R.id.content, item.getContent());
        helper.setText(R.id.alarmNumber,item.getAlarmNumber());
    }

}