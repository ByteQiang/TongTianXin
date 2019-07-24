package com.ryan.tongtianxin.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ryan.tongtianxin.R;
import com.ryan.tongtianxin.bean.AlarmOneBean;

import java.util.List;

public class AlarmThreeAdapter extends RecyclerView.Adapter<AlarmThreeAdapter.ViewHoder> {
    private Context mContext;
    private LayoutInflater inflater;
    private List<AlarmOneBean> data;
    public OnItemClickListener mItemClickListener;

    public AlarmThreeAdapter(Context context) {
        this.mContext = context;
        this.inflater = LayoutInflater.from(mContext);
    }

    public AlarmThreeAdapter(Context context, List<AlarmOneBean> mData) {
        this.mContext = context;
        this.data = mData;
        this.inflater = LayoutInflater.from(mContext);
    }

    public interface OnItemClickListener {
        void onClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mItemClickListener = onItemClickListener;
    }

    public void addData(AlarmOneBean mData) {
        this.data.add(mData);
    }

    public List<AlarmOneBean> getData() {
        return data;
    }

    @Override
    public ViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.alarm_three_item, parent, false);
        ViewHoder viewHoder = new ViewHoder(view);
        return viewHoder;
    }

    @Override
    public void onBindViewHolder(ViewHoder holder, final int position) {
        if (position == 0) {
            holder.carNumber.setText(data.get(position).getCarNumber());
            holder.carNumber.setBackgroundColor(Color.RED);
            holder.risk.setText(data.get(position).getAddress());
            holder.llOne.setBackgroundColor(Color.RED);
        }
        if (position == 1) {
            holder.carNumber.setText(data.get(position).getCarNumber());
            holder.carNumber.setBackgroundColor(Color.YELLOW);
            holder.risk.setText(data.get(position).getAddress());
            holder.llOne.setBackgroundColor(Color.YELLOW);
        } else {
            holder.carNumber.setText(data.get(position).getCarNumber());
            holder.risk.setText(data.get(position).getAddress());
        }
        holder.driver.setText(data.get(position).getTime());
        holder.driveTime.setText(data.get(position).getContent());
        holder.riskTime.setText(data.get(position).getAlarmNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mItemClickListener != null) {
                    mItemClickListener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHoder extends RecyclerView.ViewHolder {
        private TextView carNumber;
        private TextView risk;
        private TextView driver;
        private TextView driveTime;
        private TextView riskTime;
        private LinearLayout llOne;

        public ViewHoder(View itemView) {
            super(itemView);
            carNumber = (TextView) itemView.findViewById(R.id.carNumber);
            risk = (TextView) itemView.findViewById(R.id.risk);
            driver = (TextView) itemView.findViewById(R.id.driver);
            driveTime = (TextView) itemView.findViewById(R.id.driveTime);
            riskTime = (TextView) itemView.findViewById(R.id.riskTime);
            llOne = itemView.findViewById(R.id.ll_one);
        }
    }
}

