package com.cookandroid.splash_pleazz;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ask extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        List<ExpandableListAdapter.Item> data = new ArrayList<>();

        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER,"택배"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"문 앞에 놓아주세요"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"누구세요"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"문 앞에 있습니다"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.HEADER,"택시"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"어디니?"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"현관 앞에서 기다릴게"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"얼마나 걸려?"));
        data.add(new ExpandableListAdapter.Item(ExpandableListAdapter.CHILD,"데리러 갈까?"));

        recyclerView.setAdapter(new ExpandableListAdapter(data));

    }
}
