package com.example.boredapi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyGetter {
    @GET("activity")
    Call<Message> getMessage();
}