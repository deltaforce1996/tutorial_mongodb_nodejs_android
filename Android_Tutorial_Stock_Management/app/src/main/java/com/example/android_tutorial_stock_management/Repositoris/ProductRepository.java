package com.example.android_tutorial_stock_management.Repositoris;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android_tutorial_stock_management.Api.ApiConnector;
import com.example.android_tutorial_stock_management.Models.FailedResponse;
import com.example.android_tutorial_stock_management.Models.Prodcut.ProductResponse;
import com.example.android_tutorial_stock_management.Models.SuccessResponse;
import com.example.android_tutorial_stock_management.Services.IProduct;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductRepository {
    private IProduct iProduct;
    public ProductRepository() {
        iProduct = ApiConnector.RetrofitConnector().create(IProduct.class);
    }

    public LiveData<SuccessResponse<List<ProductResponse>>> findListProduct(){
        MutableLiveData<SuccessResponse<List<ProductResponse>>> resultData = new MutableLiveData<>();
        iProduct.listProduct().enqueue(new Callback<SuccessResponse<List<ProductResponse>>>() {
            @Override
            public void onResponse(Call<SuccessResponse<List<ProductResponse>>> call, Response<SuccessResponse<List<ProductResponse>>> response) {
                if(response.isSuccessful()){
                    resultData.setValue(response.body());
                }else {
                    FailedResponse  errorResponse = new Gson().fromJson(response.errorBody().toString(), FailedResponse.class);
                }
            }

            @Override
            public void onFailure(Call<SuccessResponse<List<ProductResponse>>> call, Throwable t) {

            }
        });
        return resultData;
    }
}
