package com.androidlearing.recyclerviewdemo.adapter;

import android.view.View;
import android.view.ViewGroup;

import com.androidlearing.recyclerviewdemo.R;
import com.androidlearing.recyclerviewdemo.bean.ItemBean;

import java.util.List;

/**
 * @ProjectName: RecyclerViewDemo
 * @Package: com.androidlearing.recyclerviewdemo.adapter
 * @ClassName: StaggerAdapter
 * @Description: java类作用描述
 * @Author: 武神酱丶
 * @CreateDate: 2020/3/29 22:07
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/29 22:07
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class StaggerAdapter extends RecyclerViewBaseAdapter {

    public StaggerAdapter(List<ItemBean> data) {
        super(data);
    }

    @Override
    protected View getSubView(ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.item_stagger, null);
        return view;
    }
}
