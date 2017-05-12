package com.rongyant.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.rongyant.recyclercommonadapter.CommonAdapter;
import com.rongyant.recyclercommonadapter.ViewHolder;

import java.util.List;

/**
 * Created by XRY on 2017/5/13.
 */

public class MyAdapter extends CommonAdapter<String> {


    public MyAdapter(Context context, List<String> list, RecyclerView recyclerView) {
        super(context, list, recyclerView);

    }

    @Override
    public int setLayoutId(int position) {
        return R.layout.item_recycler;
    }

    @Override
    public void onBindVH(ViewHolder viewHolder, String item, int position) {
        viewHolder.setText(R.id.recycler_text, item);
    }
}
