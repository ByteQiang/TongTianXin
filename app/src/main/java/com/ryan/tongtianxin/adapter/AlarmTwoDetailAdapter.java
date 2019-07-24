package com.ryan.tongtianxin.adapter;

import android.app.Activity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.List;

public class AlarmTwoDetailAdapter extends BaseQuickAdapter<AlarmOneBean, BaseViewHolder> {

    public AlarmTwoDetailAdapter(Activity context, List<AlarmOneBean> data) {
        super(R.layout.alarm_two_detail, data);
    }

    @Override
    protected void convert(BaseViewHolder helper,AlarmOneBean item) {
        helper.setText(R.id.title, item.getCarNumber());
        helper.setText(R.id.speed, item.getAddress());
        helper.setText(R.id.time,item.getTime());
        helper.addOnClickListener(R.id.image_record);
    }

}