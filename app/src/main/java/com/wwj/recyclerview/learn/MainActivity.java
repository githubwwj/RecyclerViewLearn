package com.wwj.recyclerview.learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TuiJianBean tuiJianBean;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();


    }

    private TuiJianBean initData() {
        BufferedReader bufferedReader = null;
        try {
            Gson gson = new Gson();
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("tui_jian.txt")));
            StringBuilder stringBuilder = new StringBuilder();
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                stringBuilder.append(content);
            }
            tuiJianBean = gson.fromJson(stringBuilder.toString(), TuiJianBean.class);
            return tuiJianBean;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    private void initView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.HORIZONTAL, false));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,GridLayoutManager.VERTICAL,false));

        recyclerAdapter = new RecyclerAdapter(tuiJianBean.getTuijian(), this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
