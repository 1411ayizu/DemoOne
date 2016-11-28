package com.example.jiahuanxue20161124;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiahuanxue20161124.bean.Bean;
import com.example.jiahuanxue20161124.bean.Bean2;
import com.example.jiahuanxue20161124.gsondemo.Tools;
import com.example.jiahuanxue20161124.okhttp.OkHttp;
import com.example.jiahuanxue20161124.xlistview.XListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;

public class OneActivity extends AppCompatActivity {

    private List<Bean2> bean2list = new ArrayList<>();
    private XListView xListView;
    private  int page= 0;
    private List<Bean2> list;
    MyAdapter adapter;
    private TextView xlistview_footer_hint_textview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        xListView = (XListView) findViewById(R.id.XlistView);
        init();
        xlistview_footer_hint_textview = (TextView) findViewById(R.id.xlistview_footer_hint_textview);
       /* xlistview_footer_hint_textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                init();
                adapter = new MyAdapter(OneActivity.this,bean2list);
                xListView.setAdapter(adapter);
                stopXlistView();
            }
        });*/
        //下拉加载
        xListView.setXListViewListener(new XListView.IXListViewListener() {
            @Override
            public void onRefresh() {
               // page++;
                init();

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter.notifyDataSetChanged();
                    }
                });
                stopXlistView();
            }
//上加载
            @Override
            public void onLoadMore() {
                Toast.makeText(OneActivity.this
                        ,"aaa",Toast.LENGTH_LONG).show();
            }
        });
        xListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view,int position, long id) {

                if (position<0){
                    position++;
                    position++;
                    list.remove(position-1);
                    adapter.notifyDataSetChanged();
                }
                new AlertDialog.Builder(OneActivity.this)
                        .setMessage("删除噢")

                        .setNegativeButton("已经删除了！！！亲！！！",new AlertDialog.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface arg0, int arg1) {
// TODO Auto-generated method stub


                            }
                        })

                        .show();
                list.remove(position-1);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
    public void init(){
        page++;
        //获取网络
        OkHttp.getAsync("http://japi.juhe.cn/joke/content/list.from?key=%20874ed931559ba07aade103eee279bb37%20&page="+page+"&pagesize=10&sort=asc&time=1418745237", new OkHttp.DataCallBack() {
            @Override
            public void requestFailure(Request request, IOException e) {

            }

            @Override
            public void requestSuccess(String result) throws Exception {
                List<Bean2> lis = new ArrayList<Bean2>();
                Bean bean = Tools.parseJsonWithGson(result, Bean.class);
                List<Bean.ResultBean.DataBean> data = bean.getResult().getData();
                for (int i=0;i<10;i++){
                    Bean.ResultBean.DataBean dataBean = data.get(i);
                    String content = dataBean.getContent();
                    Bean2 bean2 = new Bean2(content);
                    lis.add(bean2);
                }
                list = new ArrayList<Bean2>();
                list.addAll(lis);
                adapter = new MyAdapter(OneActivity.this,list);
                xListView.setAdapter(adapter);

                bean2list.addAll(list);
            }
        });
    }
   class MyAdapter extends BaseAdapter{
       private Context context;
       private List<Bean2> li;

       public MyAdapter(Context context, List<Bean2> li) {
           this.context = context;
           this.li = li;
       }

       @Override
       public int getCount() {
           return li.size();
       }

       @Override
       public Object getItem(int position) {
           return li.get(position);
       }

       @Override
       public long getItemId(int position) {
           return position;
       }

       @Override
       public View getView(int position, View convertView, ViewGroup parent) {
           convertView = View.inflate(context,R.layout.item,null);
           TextView textView = (TextView) convertView.findViewById(R.id.textView);
           textView.setText(li.get(position).getContent());
           return convertView;
       }
   }
    //停止刷新
    public  void stopXlistView(){
        xListView.setRefreshTime("000-00-00");
        xListView.stopLoadMore();
        xListView.stopRefresh();
    }
}
