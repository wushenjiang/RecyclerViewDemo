package com.androidlearing.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearing.recyclerviewdemo.R;
import com.androidlearing.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @ProjectName: RecyclerViewDemo
 * @Package: com.androidlearing.recyclerviewdemo.adapter
 * @ClassName: ListViewAdapter
 * @Description: java类作用描述
 * @Author: 武神酱丶
 * @CreateDate: 2020/3/23 16:51
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/23 16:51
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class ListViewAdapter extends RecyclerViewBaseAdapter{
    //普通条目类型
    public static final  int TYPE_NORMAL = 0;
    //加载更多
    public static final int TYPE_LOADER_MORE = 1;
    private OnRefreshListener mUpPullRefreshListener;


    public ListViewAdapter(List<ItemBean> data)
    {
        super(data);
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = getSubView(parent,viewType);
        //根据ViewType来返回holder
        if(viewType == TYPE_NORMAL){
            return new InnerHolder(view);
        }else{
            return new LoaderMoreHolder(view);
        }

    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view;
        //根据类型来创建view
        if(viewType == TYPE_NORMAL){

            view = View.inflate(parent.getContext(),R.layout.item_list_view,null);
        }else{
            //这个是加载更多的
            view = View.inflate(parent.getContext(),R.layout.item_list_loader_more,null);
        }
        return view;
    }
    /**
     * 这个方法是用于绑定holder的，一般用来设置数据
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if(getItemViewType(position) == TYPE_NORMAL&& holder instanceof InnerHolder){
            //在这里设置数据
            ((InnerHolder) holder).setData(mData.get(position),position);
        }else if(getItemViewType(position) == TYPE_LOADER_MORE&& holder instanceof LoaderMoreHolder){
            ((LoaderMoreHolder) holder).update(LoaderMoreHolder.LOADER_STATE_LOADING);
        }

    }

    @Override
    public int getItemViewType(int position) {
        if(position == getItemCount()-1){
            //最后一个则返回加载更多
            return TYPE_LOADER_MORE;
        }
        return TYPE_NORMAL;
    }

    /**
     * 设置刷新的监听接口
     */
    public void setOnRefreshListener(OnRefreshListener listener) {
        this.mUpPullRefreshListener = listener;
    }
    //定义接口
    public interface OnRefreshListener{
        void onUpPullRefresh(LoaderMoreHolder loaderMoreHolder);
    }
    public class LoaderMoreHolder extends RecyclerView.ViewHolder{
        public static final int LOADER_STATE_LOADING = 0;
        public static final int LOADER_STATE_RELOAD= 1;
        public static final int LOADER_STATE_NORMAL = 2;
        private LinearLayout mLoading;
        private  TextView mReLoad;

        public LoaderMoreHolder(@NonNull View itemView) {
            super(itemView);
            mLoading = itemView.findViewById(R.id.loading);
            mReLoad = itemView.findViewById(R.id.reload);
            mReLoad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //这里面要去触发加载数据
                    update(LOADER_STATE_LOADING);
                }
            });
        }

        public void update(int state){
            //重置控件的状态
            mLoading.setVisibility(View.GONE);
            mReLoad.setVisibility(View.GONE);
            switch (state){
                case LOADER_STATE_LOADING:
                    mLoading.setVisibility(View.VISIBLE);
                    //触发加载数据
                    startLoaderMore();
                    break;
                case LOADER_STATE_RELOAD:
                    mReLoad.setVisibility(View.VISIBLE);
                    break;
                case LOADER_STATE_NORMAL:
                    mLoading.setVisibility(View.GONE);
                    mReLoad.setVisibility(View.GONE);
                    break;
            }
        }

        private void startLoaderMore() {
            if(mUpPullRefreshListener!=null){
                mUpPullRefreshListener.onUpPullRefresh(this);
            }
        }

    }
}

