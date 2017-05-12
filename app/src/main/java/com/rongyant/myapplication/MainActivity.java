package com.rongyant.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.rongyant.recyclercommonadapter.MyDecoration;
import com.rongyant.recyclercommonadapter.MyItemTouchHelperCallback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            list.add(i + 1 + "");
        }
        MyAdapter adapter = new MyAdapter(this, list, recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));
        MyItemTouchHelperCallback<String> callback = new MyItemTouchHelperCallback<>(adapter);
        callback.setIsSwipeDragEnableListener(new MyItemTouchHelperCallback.IsSwipeDragEnableListener() {
            @Override
            public boolean isDragEnable() {
                return true;
            }

            @Override
            public boolean isSwipeEnable() {
                return false;
            }
        });

        recyclerView.setAdapter(adapter);
        adapter.addHeaderView(R.layout.item_recycler2);
        recyclerView.addItemDecoration(new MyDecoration(this, MyDecoration.VERTICAL));
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
