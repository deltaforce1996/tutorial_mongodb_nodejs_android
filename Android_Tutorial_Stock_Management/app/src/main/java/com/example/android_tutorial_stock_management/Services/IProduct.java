package com.example.android_tutorial_stock_management.Services;

import com.example.android_tutorial_stock_management.Models.Prodcut.ProductRequest;
import com.example.android_tutorial_stock_management.Models.Prodcut.ProductResponse;
import com.example.android_tutorial_stock_management.Models.SuccessResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IProduct {
    @GET("product")
    Call<SuccessResponse<List<ProductResponse>>> listProduct();

    @GET("product/{id}")
    Call<SuccessResponse<ProductResponse>> findProductById(@Path("id") String id);

    @POST("product")
    Call<SuccessResponse<ProductResponse>> createNewProduct(@Body ProductRequest newProduct);

    @PUT("product/{id}")
    Call<SuccessResponse<ProductResponse>> updatedProductById(@Body ProductRequest newProduct, @Path("id") String id);
    
}
