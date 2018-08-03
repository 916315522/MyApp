package com.my.myapp;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;
import java.util.List;

public class Recyclerview extends Activity {
    private int countq=0;
    private List<String> data;
    private RecyclerView recyclerView;
   //自定义适配器，继承RecyclerView.Adapter
    private MyRecycleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        data = new LinkedList<String>();
        recyclerView = (RecyclerView) findViewById(R.id.recycle_view);

        // 设置布局管理器
        // 支持 单列线性排列，支持GridView模式，瀑布流模式

        //**********************list布局,参数1上下文，参数2垂直布局*********************//
       // LinearLayoutManager layoutManager =new LinearLayoutManager(
         //       this, LinearLayout.VERTICAL, false);

        //*********grid布局，参数1上下文，参数2每行显示的个数，参数3水平排列***********//
       //RecyclerView.LayoutManager layoutManager =new GridLayoutManager(
         //     this,2,GridLayoutManager.HORIZONTAL,false);

        //***************瀑布流，参数1梅钢显示个数，参数2垂直排列*******************//
       RecyclerView.LayoutManager layoutManager =new StaggeredGridLayoutManager(
               3, StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        // 设置 RecyclerView的Adapter
        // 注意一定在设置了布局管理器之后调用
        adapter = new MyRecycleAdapter(data);
        recyclerView.setAdapter(adapter);
    }
    //增加按钮事件
    public void btnAddItem(View view) {
        data.add(0,"山水画"+countq);
        adapter.notifyDataSetChanged();
        countq++;

    }
    //删除按钮事件
    public void btnRemoveItem(View view) {
        if (!data.isEmpty()) {
            data.remove(0);
        }
        adapter.notifyItemRemoved(0);
        countq--;
    }

    //继承RecyclerView.Adapter，用于显示数据
    private class MyRecycleAdapter extends RecyclerView.Adapter<ViewHolder>{
        private  int cot=0;
        private List<String> strings;
        public MyRecycleAdapter(List<String> strings) {
            this.strings = strings;
        }
        @Override
        public int getItemCount() {
            int ret = 0;
            if (strings != null) {
                ret = strings.size();
            }
            return ret;
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup,int i) {
            ViewHolder ret = null;
            // 不需要检查是否复用，因为只要进入此方法，必然没有复用
            // 因为RecyclerView 通过Holder检查复用
            int buit=cot%4;
            switch (buit){
                case 0:
                    View v = LayoutInflater.from(Recyclerview.this).inflate(R.layout.recyclerview_son, viewGroup, false);
                    ret = new ViewHolder(v);
                    break;
                case 1:
                    View v1 = LayoutInflater.from(Recyclerview.this).inflate(R.layout.recyclerview_son1, viewGroup, false);
                    ret = new ViewHolder(v1);
                    break;
                case 2:
                    View v2 = LayoutInflater.from(Recyclerview.this).inflate(R.layout.recyclerview_son2, viewGroup, false);
                    ret = new ViewHolder(v2);
                    break;
                case 3:
                    View v3 = LayoutInflater.from(Recyclerview.this).inflate(R.layout.recyclerview_son3, viewGroup, false);
                    ret = new ViewHolder(v3);
                    break;

            }
            cot++;
            return ret;
        }
        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            viewHolder.textView.setText(strings.get(i));
            int resId = R.drawable.ic_launcher_background;
            int index = i%5;
            switch (index){
                case 0:
                    resId = R.drawable.a;
                    break;
                case 1:
                    resId = R.drawable.a;
                    break;
                case 2:
                    resId = R.drawable.a;
                    break;
                case 3:
                    resId = R.drawable.a;
                    break;
                case 4:
                    resId = R.drawable.a;
                    break;
            }
            viewHolder.imageView.setImageResource(resId);
        }
    }

    //创建自己的ViewHolder,继承对应系统包
    private static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            // 通常ViewHolder的构造，就是用于获取控件视图的
            imageView = (ImageView) itemView.findViewById(R.id.item_icon);
            textView = (TextView) itemView.findViewById(R.id.item_title);
            // TODO 后续处理点击事件的操作
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Context context = imageView.getContext();
            Toast.makeText(context,"显示第"+position+"个项",Toast.LENGTH_SHORT).show();
        }
    }

}
