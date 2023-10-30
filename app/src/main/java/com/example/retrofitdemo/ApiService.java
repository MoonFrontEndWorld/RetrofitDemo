package com.example.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    // 定义一个 GET 请求方法，用于获取数据
    @GET("api.php")
    Call<QuizBean> getQuestions(
            @Query("amount") int amount,       // 问题数量
            @Query("category") int category,   // 问题类别
            @Query("difficulty") String difficulty  // 问题难度
    );
}

