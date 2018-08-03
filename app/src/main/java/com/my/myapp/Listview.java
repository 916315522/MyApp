package com.my.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Listview extends Activity {
    private List<Listitem> itemList=new ArrayList<Listitem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        //初始化item数据
        initItem();
        ItemAdapter adapter = new ItemAdapter(Listview.this, R.layout.listview_son, itemList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        //跳转到gridview
        Button Togridview=(Button) findViewById(R.id.jump2);
        Togridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Listview.this, Gridview.class);
                startActivity(intent);
            }
        });

    }


    private void initItem() {
        Listitem a=new Listitem("山水画1",R.drawable.a);
        itemList.add(a);
        Listitem b=new Listitem("山水画2",R.drawable.a);
        itemList.add(b);
        Listitem c=new Listitem("山水画3",R.drawable.a);
        itemList.add(c);
        Listitem d=new Listitem("山水画4",R.drawable.a);
        itemList.add(d);
        Listitem e=new Listitem("山水画5",R.drawable.a);
        itemList.add(e);
        Listitem f=new Listitem("山水画6",R.drawable.a);
        itemList.add(f);
        Listitem g=new Listitem("山水画7",R.drawable.a);
        itemList.add(g);
        Listitem h=new Listitem("山水画8",R.drawable.a);
        itemList.add(h);
        Listitem i=new Listitem("山水画9",R.drawable.a);
        itemList.add(i);
        Listitem j=new Listitem("山水画0",R.drawable.a);
        itemList.add(j);

    }


}
