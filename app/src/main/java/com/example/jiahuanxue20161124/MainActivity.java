package com.example.jiahuanxue20161124;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * autour: 贾焕雪
 * date: 2016-11-24 9:24
 * update: 2016-11-24
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //停留三秒跳转
        //创建一个线程
        new Thread(){
            public void run() {
                try {
//睡2秒
                    sleep(1000);
//跳转到首页面
                    Intent intent=new Intent(MainActivity.this,TwoActivit.class);
//开始跳转
                    startActivity(intent);
                } catch (Exception e) {
// TODO Auto-generated catch block
                    e.printStackTrace();
                }
            };
        }.start();
    }

}
