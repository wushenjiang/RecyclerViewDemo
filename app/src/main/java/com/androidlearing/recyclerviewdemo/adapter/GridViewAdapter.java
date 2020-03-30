package com.androidlearing.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearing.recyclerviewdemo.R;
import com.androidlearing.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @ProjectName: RecyclerViewDemo
 * @Package: com.androidlearing.recyclerviewdemo.adapter
 * @ClassName: GridViewAdapter
 * @Description: java类作用描述
 * @Author: 武神酱丶
 * @CreateDate: 2020/3/24 11:21
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/24 11:21
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class GridViewAdapter extends RecyclerViewBaseAdapter {

    public GridViewAdapter(List<ItemBean> data){
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_grid_view, null);
        return view;
    }

}
