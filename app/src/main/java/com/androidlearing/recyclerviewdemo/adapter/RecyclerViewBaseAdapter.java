package com.androidlearing.recyclerviewdemo.adapter;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.androidlearing.recyclerviewdemo.R;
import com.androidlearing.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @ProjectName: RecyclerViewDemo
 * @Package: com.androidlearing.recyclerviewdemo.adapter
 * @ClassName: RecyclerViewBaseAdapter
 * @Description: java类作用描述
 * @Author: 武神酱丶
 * @CreateDate: 2020/3/29 21:46
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/29 21:46
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public abstract class RecyclerViewBaseAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    protected  static List<ItemBean> mData;
    private onItemClickListener mOnItemClickListener;


    public RecyclerViewBaseAdapter(List<ItemBean> data)
    {
        this.mData = data;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getSubView(parent,viewType);
        return new InnerHolder(view);
    }

    protected abstract View getSubView(ViewGroup parent, int viewType);

    /**
     * 这个方法是用于绑定holder的，一般用来设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //在这里设置数据
        ((InnerHolder) holder).setData(mData.get(position),position);
    }

    /**
     * 返回条目的个数
     * @return
     */
    @Override
    public int getItemCount() {
        if(mData!=null){
            return mData.size();
        }
        return 0;
    }

    public void setOnItemClickListener(onItemClickListener Listener) {
        //设置一个监听，其实就是要设置一个接口，一个回调的接口
        this.mOnItemClickListener = Listener;
    }

    /**
     * 编写回调的步骤
     * 1.创建这个接口
     * 2.定义接口内部的方法
     * 3.提供设置接口的方法(外部实现)
     * 4.接口调用
     */
    public interface onItemClickListener{
        void onItemClick(int position);
    }

    public class InnerHolder extends RecyclerView.ViewHolder {
        private final ImageView mIcon;
        private final TextView mTitle;
        private int mPosition;

        public InnerHolder( View itemView) {
            super(itemView);

            //找到条目控件
            mIcon = itemView.findViewById(R.id.icon);
            mTitle = itemView.findViewById(R.id.title);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnItemClickListener!=null) {
                        mOnItemClickListener.onItemClick(mPosition);
                    }
                }
            });

        }

        /**
         * 这个方法用于设置数据
         * @param itemBean
         */
        public void setData(ItemBean itemBean,int position) {
            this.mPosition = position;
            //开始设置数据
            mIcon.setImageResource(itemBean.icon);
            mTitle.setText(itemBean.title);

        }
    }
}
