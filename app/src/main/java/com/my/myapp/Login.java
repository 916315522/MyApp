package com.my.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Login extends Activity {

    private TextView statename;
    private TextView statepwd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //显示当前用户账号密码
        statename= (TextView) findViewById(R.id.statename);
        statepwd= (TextView) findViewById(R.id.statepwd);
        String name=MainActivity.showname;
        String pass=MainActivity.showpwd;
        statename.setText(name);
        statepwd.setText(pass);
        //跳转到主页面
        Button Tomainview=(Button) findViewById(R.id.jump);
        Tomainview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(Login.this, Listview.class);
                startActivity(intent);
            }
        });

    }

}
