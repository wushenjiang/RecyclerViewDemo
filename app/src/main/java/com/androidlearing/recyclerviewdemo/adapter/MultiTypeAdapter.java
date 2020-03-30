package com.androidlearing.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearing.recyclerviewdemo.R;
import com.androidlearing.recyclerviewdemo.bean.MultiTypeBean;

import java.util.List;

/**
 * @ProjectName: RecyclerViewDemo
 * @Package: com.androidlearing.recyclerviewdemo.adapter
 * @ClassName: MultiTypeAdapter
 * @Description: java类作用描述
 * @Author: 武神酱丶
 * @CreateDate: 2020/3/30 11:12
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/30 11:12
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MultiTypeAdapter extends RecyclerView.Adapter {
    private final List<MultiTypeBean> mData;
    //定义三个常量标识,因为有三种类型
    public static final int TYPE_FULL_IMAGE = 0;
    public static final int TYPE_RIGHT_IMAGE = 1;
    public static final int TYPE_THREE_IMAGES = 2;

    public MultiTypeAdapter(List<MultiTypeBean> data) {
        this.mData = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //TODO:这里面去创建ViewHolder
        View view;
        if(viewType == TYPE_FULL_IMAGE){
           view = View.inflate(parent.getContext(), R.layout.item_type_full_image,null);
            return new FullImageHolder(view);
        }else if(viewType == TYPE_RIGHT_IMAGE){
            view = View.inflate(parent.getContext(), R.layout.item_type_left_title_right_image,null);
            return new RightImageHolder(view);
        }else{
            view = View.inflate(parent.getContext(), R.layout.item_type_three_image,null);
            return new ThreeImageHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            //TODO:这里就不设置数据了
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }
    //复写一个方法，这个方法是根据条件来返回条目类型


    @Override
    public int getItemViewType(int position) {
        MultiTypeBean multiTypeBean = mData.get(position);
        if(multiTypeBean.type ==0){
            //第0种
            return TYPE_FULL_IMAGE;
        }else if(multiTypeBean.type ==1){
            return TYPE_RIGHT_IMAGE;
        }else{
            return TYPE_THREE_IMAGES;
        }
    }
    private class FullImageHolder extends RecyclerView.ViewHolder{

        public FullImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    private class ThreeImageHolder extends RecyclerView.ViewHolder{

        public ThreeImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
    private class RightImageHolder extends RecyclerView.ViewHolder{

        public RightImageHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
