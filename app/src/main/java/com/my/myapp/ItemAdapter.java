package com.my.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends ArrayAdapter {
    private final int resourceId;
    public ItemAdapter(Context context, int textViewResourceId, List<Listitem> objects) {
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        //获取当前项的List_item实例
        Listitem item=(Listitem)getItem(position);
        //实例化一个对象
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        //获取布局内的文本和图片视图
        ImageView itemImage = (ImageView) view.findViewById(R.id.item_image);
        TextView itemName = (TextView) view.findViewById(R.id.item_name);
        //为文本和图片视图设置内容
        itemName.setText(item.getName());
        itemImage.setImageResource(item.getImageId());
        return view;
    }
}
