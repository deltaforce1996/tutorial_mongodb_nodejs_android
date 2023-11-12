package com.example.android_tutorial_stock_management.Api;

import android.content.Context;

import com.example.android_tutorial_stock_management.R;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiConnector {
    public static Retrofit RetrofitConnector(){
        // Create a logging interceptor
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        // Create an OkHttpClient and add the logging interceptor
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();
        // Build the Retrofit instance
        return new Retrofit.Builder()
                .baseUrl("http://10.0.2.2:4000/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();
    }
}
