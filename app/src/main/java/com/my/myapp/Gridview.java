package com.my.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Gridview extends Activity {
    private GridView gridView;
    private List<Map<String, Object>> dataList;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridview);
        gridView = (GridView) findViewById(R.id.grid_view);
        //初始化数据
        initData();
        String[] from={"img","text"};
        int[] to={R.id.img,R.id.text};
        adapter=new SimpleAdapter(this, dataList, R.layout.gridview_son, from, to);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                AlertDialog.Builder builder= new AlertDialog.Builder(Gridview.this);
                builder.setTitle("提示").setMessage(dataList.get(arg2).get("text").toString()).create().show();
            }
        });
        //跳转到recyclerview
        Button Togridview=(Button) findViewById(R.id.jump3);
        Togridview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Gridview.this, Recyclerview.class);
                startActivity(intent);
            }
        });


    }

    private void initData() {
        int icno[] = {R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a,
                R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a, R.drawable.a};
        String name[] = {"山水画1", "山水画2", "山水画3", "山水画4", "山水画5",
                "山水画6", "山水画7", "山水画8", "山水画9", "山水画0"};
        dataList = new ArrayList<Map<String, Object>>();
        for (int i = 0; i < icno.length; i++) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("img", icno[i]);
            map.put("text", name[i]);
            dataList.add(map);

        }
    }

}
