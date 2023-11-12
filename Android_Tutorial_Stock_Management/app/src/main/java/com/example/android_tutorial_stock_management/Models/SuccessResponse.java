package com.example.android_tutorial_stock_management.Models;

import com.google.gson.annotations.SerializedName;
public class SuccessResponse<T> {
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private T data;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
