package com.example.jiahuanxue20161124.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jiahuanxue20161124.R;
import com.example.jiahuanxue20161124.bean.Bean2;

import java.util.List;

/**
 * Created by 贾焕雪 on 2016-11-25.
 */
public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.Item1ViewHolder>{
    private Context context;
    private List<Bean2> li;
    private LayoutInflater inflater;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public void setmOnItemLongClickListener(OnItemLongClickListener mOnItemLongClickListener) {
        this.mOnItemLongClickListener = mOnItemLongClickListener;
    }
    public MyRecyclerViewAdapter(Context context, List<Bean2> li) {
        this.context = context;
        this.li = li;
        inflater=LayoutInflater.from(context);
    }

    @Override
    public Item1ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item,parent,false);
        Item1ViewHolder holder= new Item1ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final Item1ViewHolder holder, int position) {
        holder.mTextView.setText(li.get(position).getContent());
        //将数据保存在itemView的Tag中，以便点击时进行获取
        holder.itemView.setTag(li.get(position));

        //判断是否设置了监听器
        if(mOnItemClickListener != null){
            //为ItemView设置监听器
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = holder.getLayoutPosition(); // 1
                    mOnItemClickListener.onItemClick(holder.itemView,position); // 2
                }
            });
        }
        if(mOnItemLongClickListener != null){
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int position = holder.getLayoutPosition();
                    mOnItemLongClickListener.onItemLongClick(holder.itemView,position);
                    //返回true 表示消耗了事件 事件不会继续传递
                    return true;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return li.size();
    }

   public class Item1ViewHolder extends RecyclerView.ViewHolder{
        TextView mTextView;

        public Item1ViewHolder(View itemView) {
            super(itemView);
            mTextView = (TextView) itemView.findViewById(R.id.textView);
        }

    }
    public interface OnItemClickListener{
        void onItemClick(View view, int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View view, int position);
    }
}
