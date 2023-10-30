package com.example.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private List<Item> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 假设你已经获取到了 JSON 数据并解析为 Item 对象列表
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetchDataFromJson();
            }
        });


    }

    // 解析 JSON 数据并返回 Item 对象列表的方法
    private void fetchDataFromJson() {

            ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
            Call<QuizBean> call = apiService.getQuestions(3, 11, "easy");

            call.enqueue(new Callback<QuizBean>() {
                @Override
                public void onResponse(Call<QuizBean> call, Response<QuizBean> response) {
                    if (response.isSuccessful()) {
                        QuizBean data = response.body();
                        // 处理从 API 获取的数据
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                adapter = new ItemAdapter(data.getResults());
                                recyclerView.setAdapter(adapter);
                            }
                        });
                    } else {
                        // 处理请求失败的情况
                    }
                }

                @Override
                public void onFailure(Call<QuizBean> call, Throwable t) {
                    // 处理请求失败的情况
                }
            });

    }
}
