package com.ryan.tongtianxin.adapter;

import android.app.Activity;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.List;

public class AlarmTwoAdapter extends BaseQuickAdapter<AlarmOneBean, BaseViewHolder> {

    public AlarmTwoAdapter(Activity context, List<AlarmOneBean> data) {
        super(R.layout.alarm_two_item, data);
    }

    @Override
    protected void convert(BaseViewHolder helper,AlarmOneBean item) {
        helper.setText(R.id.flag_time, item.getCarNumber());
        helper.setText(R.id.textFlag_one, item.getAddress());
        helper.setText(R.id.textFlag_two, String.valueOf(item.getTime()));
        helper.setText(R.id.textFlag_detail, item.getContent());
    }

}