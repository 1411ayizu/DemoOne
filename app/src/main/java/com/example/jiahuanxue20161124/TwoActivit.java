package com.example.jiahuanxue20161124;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.jiahuanxue20161124.adapter.MyRecyclerViewAdapter;
import com.example.jiahuanxue20161124.bean.Bean;
import com.example.jiahuanxue20161124.bean.Bean2;
import com.example.jiahuanxue20161124.gsondemo.Tools;
import com.example.jiahuanxue20161124.okhttp.OkHttp;
import com.example.jiahuanxue20161124.recyclerview.PullBaseView;
import com.example.jiahuanxue20161124.recyclerview.PullRecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import okhttp3.Request;

public class TwoActivit extends AppCompatActivity implements PullBaseView
        .OnHeaderRefreshListener,PullBaseView.OnFooterRefreshListener{
    private List<Bean2> list;
    PullRecyclerView recyclerView;
    MyRecyclerViewAdapter adapter;
    int page = 100;
    private  List<Bean2> listBean = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        init(page);
        recyclerView = (PullRecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setOnHeaderRefreshListener(this);//设置下拉监听
        recyclerView.setOnFooterRefreshListener(this);//设置上拉监听
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void init(int page) {
        //key=%20874ed931559ba07aade103eee279bb37%20&page=" + page + "&pagesize=10&sort=asc&time=1418745237
        Map<String,String> map = new HashMap<>();
        map.put("key","874ed931559ba07aade103eee279bb37");
        map.put("page",1+"");
        map.put("pagesize",10+"");
        map.put("sort","asc");
        map.put("time"," 1418745237");
        Log.i("--------------",map.toString());
        //获取网络
        OkHttp.getAsync( "http://japi.juhe.cn/joke/content/list.from?",
                new OkHttp.DataCallBack() {

            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                List<Bean2> lis = new ArrayList<Bean2>();
                Bean bean = Tools.parseJsonWithGson(result, Bean.class);
                List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                for (int i = 0; i < data.size(); i++) {
                    Bean.ResultBean.DataBean dataBean = data.get(i);
                    String content = dataBean.getContent();
                    Bean2 bean2 = new Bean2(content);
                    Log.i("--------------",content);
                    lis.add(bean2);
                }
                list = new ArrayList<Bean2>();
                list.addAll(lis);
                adapter = new MyRecyclerViewAdapter(TwoActivit.this,list);
                recyclerView.setAdapter(adapter);
                adapter.setmOnItemClickListener(new MyRecyclerViewAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(TwoActivit.this, "click" + list.get(position), Toast.LENGTH_SHORT).show();
                    }
                });

                adapter.setmOnItemLongClickListener(new MyRecyclerViewAdapter.OnItemLongClickListener() {
                    @Override
                    public void onItemLongClick(View view, final int position) {
                        Toast.makeText(TwoActivit.this, "Long click" + list.get(position), Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder builder = new AlertDialog.Builder(TwoActivit.this);
                        builder.setMessage("确认删除吗？");
                        builder.setTitle("提示");
                        builder.setPositiveButton("确认", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                adapter.notifyDataSetChanged();
                                list.remove(position);
                                dialog.dismiss();
                            }
                        });
                        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.create().show();
                    }
                });

            }
        });
    }

    @Override
    public void onFooterRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                init(page-=2);
                list.addAll(listBean);
                adapter.notifyDataSetChanged();
                recyclerView.onFooterRefreshComplete();
                // listBean.clear();
            }
        }, 1000);
    }

    @Override
    public void onHeaderRefresh(PullBaseView view) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                page+=2;
                init(page);
                adapter.notifyDataSetChanged();
                recyclerView.onHeaderRefreshComplete();
                listBean.addAll(list);
            }
        }, 1000);
    }
}
