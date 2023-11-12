package com.example.android_tutorial_stock_management.Models.Prodcut;

import com.google.gson.annotations.SerializedName;

public class ProductRequest {
    public ProductRequest(String productName, Integer productAmount, String productExp, Integer productPrice) {
        this.productName = productName;
        this.productAmount = productAmount;
        this.productExp = productExp;
        this.productPrice = productPrice;
    }

    @SerializedName("product_name")
    private String productName;
    @SerializedName("product_amount")
    private Integer productAmount;
    @SerializedName("product_exp")
    private String productExp;
    @SerializedName("product_price")
    private Integer productPrice;


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(Integer productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductExp() {
        return productExp;
    }

    public void setProductExp(String productExp) {
        this.productExp = productExp;
    }

    public Integer getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Integer productPrice) {
        this.productPrice = productPrice;
    }
}
