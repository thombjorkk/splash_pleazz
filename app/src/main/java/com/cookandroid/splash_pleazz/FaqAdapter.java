package com.cookandroid.splash_pleazz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class FaqAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> array_Faq;
    private ViewHolder mViewHolder;

    public FaqAdapter(Context mContext, ArrayList<String> array_Faq){
        this.mContext = mContext;
        this.array_Faq = array_Faq;
    }


    @Override
    public int getCount() {
        return array_Faq.size();
    }

    @Override
    public Object getItem(int position) {
        return array_Faq.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.layout_faq_item, parent, false);
            mViewHolder = new ViewHolder(convertView);
            convertView.setTag(mViewHolder);
        }
        else{
            mViewHolder = (ViewHolder)convertView.getTag();
        }
        mViewHolder.txt_name.setText(array_Faq.get(position));

        return convertView;
    }
    public class ViewHolder{
        private TextView txt_name;

        public ViewHolder(View convertView){
            txt_name = (TextView)convertView.findViewById(R.id.txt_name);
        }
    }
}