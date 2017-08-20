package com.diabin.imoocdaily;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextClock;
import android.widget.TextView;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by yons on 2017/8/20.
 */

public class CostlistAdapter extends BaseAdapter {


    private List<CostBean> mList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public CostlistAdapter(Context context, List<CostBean> mlist) {
        mContext= context;
        this.mList = mlist;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null){
            viewHolder = new ViewHolder();
            convertView = mLayoutInflater.inflate(R.layout.list_item,null);
            viewHolder.mTvCostTitle = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.mTvCostDate = (TextView) convertView.findViewById(R.id.tv_date);
            viewHolder.mTvCostMoney = (TextView) convertView.findViewById(R.id.tv_cost);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        CostBean bean = mList.get(position);
        viewHolder.mTvCostTitle.setText(bean.costTitle);
        viewHolder.mTvCostDate.setText(bean.costDate);
        viewHolder.mTvCostMoney.setText(bean.costMoney);

        return convertView;


        }



    }

        class ViewHolder{
        public TextView mTvCostTitle;
        public TextView mTvCostDate;
        public TextView mTvCostMoney;

}
