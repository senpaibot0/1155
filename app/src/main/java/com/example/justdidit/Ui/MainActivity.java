package com.example.justdidit.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.justdidit.R;
import com.example.justdidit.Ui.MyAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView dataList;
    List<String> titles;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataList = findViewById(R.id.dataList);

        titles = new ArrayList<>();

        titles.add("tache1");
        titles.add("tache2");
        titles.add("tache3");
        titles.add("tache4");
        titles.add("tache5");
        titles.add("tache6");
        titles.add("tache7");
        titles.add("tache8");
        titles.add("tache9");
        titles.add("tache10");

        adapter = new MyAdapter(this, titles);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,1, GridLayoutManager.VERTICAL,false);

        dataList.setLayoutManager(gridLayoutManager);
        dataList.setAdapter(adapter);
    }
}