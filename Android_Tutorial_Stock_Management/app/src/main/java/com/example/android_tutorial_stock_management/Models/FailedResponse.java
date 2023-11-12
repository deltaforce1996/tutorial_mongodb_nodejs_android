package com.example.android_tutorial_stock_management.Models;

import com.google.gson.annotations.SerializedName;

public class FailedResponse {
    public FailedResponse(String message) {
        this.message = message;
    }

    @SerializedName("message")
    private String message;
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
