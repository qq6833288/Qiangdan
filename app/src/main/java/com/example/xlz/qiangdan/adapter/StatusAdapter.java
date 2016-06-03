package com.example.xlz.qiangdan.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.xlz.qiangdan.R;
import com.example.xlz.qiangdan.entity.Status;

import java.util.List;

/**
 * Created by xlz on 2016/5/25.
 */
public class StatusAdapter extends ArrayAdapter<Status> {

    private Context context;

    private List<Status> datas;

    private int resourceId;

    public StatusAdapter(Context context, int textViewResourceId, List<Status> datas) {
        super(context, textViewResourceId,datas);
        this.context = context;
        this.datas = datas;
        resourceId = textViewResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Status status = getItem(position);
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(resourceId, null);

            viewHolder.ll_content = (LinearLayout) convertView.findViewById(R.id.ll_content);
            viewHolder.tv_content = (TextView) convertView.findViewById(R.id.tv_content);
            viewHolder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            viewHolder.ll_time_bottom = (LinearLayout) convertView.findViewById(R.id.ll_time_bottom);
            viewHolder.tv_time_bottom = (TextView) convertView.findViewById(R.id.tv_time_bottom);
            viewHolder.ll_number_bottom = (LinearLayout) convertView.findViewById(R.id.ll_number_bottom);
            viewHolder.tv_number_bottom = (TextView) convertView.findViewById(R.id.tv_number_bottom);
            viewHolder.ll_day_bottom = (LinearLayout) convertView.findViewById(R.id.ll_day_bottom);
            viewHolder.tv_day_bottom = (TextView) convertView.findViewById(R.id.tv_day_bottom);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.tv_content.setText(status.getContent());
        viewHolder.tv_price.setText(status.getPrice());
        viewHolder.tv_time_bottom.setText(status.getTime());
        viewHolder.tv_number_bottom.setText(status.getNumber());
        viewHolder.tv_day_bottom.setText(status.getDay());

        return convertView;
    }

    public static class ViewHolder {
        public LinearLayout ll_content;
        public TextView tv_content;
        public TextView tv_price;
        public LinearLayout ll_time_bottom;
        public TextView tv_time_bottom;
        public LinearLayout ll_number_bottom;
        public TextView tv_number_bottom;
        public LinearLayout ll_day_bottom;
        public TextView tv_day_bottom;
    }
}
