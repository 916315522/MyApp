package com.my.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button reg;
    private Button login;
    private EditText count;
    private EditText pwd;
    private TextView state;
    public static String showname;
    public static String showpwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reg= (Button) findViewById(R.id.regin);
        login= (Button) findViewById(R.id.login);
        count= (EditText) findViewById(R.id.count);
        pwd= (EditText) findViewById(R.id.pwd);
        state= (TextView) findViewById(R.id.state);
        //注册监听
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=count.getText().toString().trim();
                String pass=pwd.getText().toString().trim();
                User user=new User();
                user.setUsername(name);
                user.setUserpwd(pass);
                int result=SqliteDB.getInstance(getApplicationContext()).saveUser(user);

                if (result==1){
                    state.setText("注册成功！");
                }else  if (result==-1)
                {
                    state.setText("用户名已经存在！");
                }
                else
                {
                    state.setText("！");
                }
            }
        });
        //登陆监听
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String name=count.getText().toString().trim();
                String pass=pwd.getText().toString().trim();
                int result=SqliteDB.getInstance(getApplicationContext()).Quer(pass,name);
                Intent intent =new Intent(MainActivity.this, Login.class);
                if (result==1)
                {
                    state.setText("登录成功！");
                    showname=name;
                    showpwd=pass;
                    startActivity(intent);
                }
                else if (result==0){
                    state.setText("用户名不存在！");
                }
                else if(result==-1)
                {
                    state.setText("密码错误！");
                }
            }

        });
    }
}
