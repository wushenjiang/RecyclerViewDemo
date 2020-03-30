package com.androidlearing.recyclerviewdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidlearing.recyclerviewdemo.adapter.MultiTypeAdapter;
import com.androidlearing.recyclerviewdemo.bean.Datas;
import com.androidlearing.recyclerviewdemo.bean.MultiTypeBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ProjectName: RecyclerViewDemo
 * @Package: com.androidlearing.recyclerviewdemo
 * @ClassName: MultiTypeActivity
 * @Description: java类作用描述
 * @Author: 武神酱丶
 * @CreateDate: 2020/3/30 11:00
 * @UpdateUser: 更新者
 * @UpdateDate: 2020/3/30 11:00
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 */
public class MultiTypeActivity extends AppCompatActivity {

    private static final String TAG = "MultiTypeActivity";
    private RecyclerView mRecyclerView;
    private List<MultiTypeBean> mData;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_type);
        //找到view
        mRecyclerView = this.findViewById(R.id.multi_type_list);

        //准备数据
        mData = new ArrayList<>();
        initDatas();
        //设置布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        //创建适配器
        MultiTypeAdapter adapter = new MultiTypeAdapter(mData);

        //设置适配器
        mRecyclerView.setAdapter(adapter);

    }

    private void initDatas() {

        Random random = new Random();

        for(int i=0;i<20;i++){
            MultiTypeBean data = new MultiTypeBean();
            data.pic = Datas.icons[i];
            data.type = random.nextInt(3);
            Log.d(TAG,"type=="+data.type);

            mData.add(data);
        }
    }
}
