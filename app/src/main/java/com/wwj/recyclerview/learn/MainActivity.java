package com.wwj.recyclerview.learn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private HomeBean homeBean;
    private RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();


    }

    private HomeBean initData() {
        BufferedReader bufferedReader = null;
        try {
            Gson gson = new Gson();
            bufferedReader = new BufferedReader(new InputStreamReader(getAssets().open("home_data.txt")));
            StringBuilder stringBuilder = new StringBuilder();
            String content;
            while ((content = bufferedReader.readLine()) != null) {
                stringBuilder.append(content);
            }
            homeBean = gson.fromJson(stringBuilder.toString(), HomeBean.class);
            return homeBean;
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
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL, false));
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,GridLayoutManager.VERTICAL,false));

        recyclerAdapter = new RecyclerAdapter(homeBean.getData(), this);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
