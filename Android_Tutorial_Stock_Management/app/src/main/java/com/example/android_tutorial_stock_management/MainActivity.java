package com.example.android_tutorial_stock_management;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android_tutorial_stock_management.Api.ApiConnector;
import com.example.android_tutorial_stock_management.Models.FailedResponse;
import com.example.android_tutorial_stock_management.Models.Prodcut.ProductRequest;
import com.example.android_tutorial_stock_management.Models.Prodcut.ProductResponse;
import com.example.android_tutorial_stock_management.Models.SuccessResponse;
import com.example.android_tutorial_stock_management.Services.IProduct;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private TextView mTvResponse;
    private IProduct iProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTvResponse = (TextView) findViewById(R.id.tvResponse);
        iProduct = ApiConnector.RetrofitConnector().create(IProduct.class);
    }

    private void findListProduct(){
        iProduct.listProduct().enqueue(new Callback<SuccessResponse<List<ProductResponse>>>() {
            @Override
            public void onResponse(Call<SuccessResponse<List<ProductResponse>>> call, Response<SuccessResponse<List<ProductResponse>>> response) {
                if(response.isSuccessful()){
                    mTvResponse.setText(response.body().getMessage());
                }else{
                    FailedResponse errorResponse = new Gson().fromJson(response.errorBody().charStream(), FailedResponse.class);
                    mTvResponse.setText(errorResponse.getMessage());
                }
            }
            @Override
            public void onFailure(Call<SuccessResponse<List<ProductResponse>>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    private void findProductById(String id){
        iProduct.findProductById(id).enqueue(new Callback<SuccessResponse<ProductResponse>>() {
            @Override
            public void onResponse(Call<SuccessResponse<ProductResponse>> call, Response<SuccessResponse<ProductResponse>> response) {
                if(response.isSuccessful()){
                    mTvResponse.setText(response.body().getMessage());
                }else{
                    FailedResponse errorResponse = new Gson().fromJson(response.errorBody().charStream(), FailedResponse.class);
                    mTvResponse.setText(errorResponse.getMessage());
                }
            }
            @Override
            public void onFailure(Call<SuccessResponse<ProductResponse>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    private void createNewProduct(String Name, Integer Amount, String Exp, Integer Price){
        ProductRequest NewProduct = new ProductRequest(Name,Amount,Exp,Price);
        iProduct.createNewProduct(NewProduct).enqueue(new Callback<SuccessResponse<ProductResponse>>() {
            @Override
            public void onResponse(Call<SuccessResponse<ProductResponse>> call, Response<SuccessResponse<ProductResponse>> response) {
                if(response.isSuccessful()){
                    mTvResponse.setText(response.body().getMessage());
                }else{
                    FailedResponse errorResponse = new Gson().fromJson(response.errorBody().charStream(), FailedResponse.class);
                    mTvResponse.setText(errorResponse.getMessage());
                }
            }
            @Override
            public void onFailure(Call<SuccessResponse<ProductResponse>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    private void updateNewProduct(String Name, Integer Amount, String Exp, Integer Price, String Id){
        ProductRequest NewProduct = new ProductRequest(Name,Amount,Exp,Price);
        iProduct.updatedProductById(NewProduct, Id).enqueue(new Callback<SuccessResponse<ProductResponse>>() {
            @Override
            public void onResponse(Call<SuccessResponse<ProductResponse>> call, Response<SuccessResponse<ProductResponse>> response) {
                if(response.isSuccessful()){
                    mTvResponse.setText(response.body().getMessage());
                }else{
                    FailedResponse errorResponse = new Gson().fromJson(response.errorBody().charStream(), FailedResponse.class);
                    mTvResponse.setText(errorResponse.getMessage());
                }
            }
            @Override
            public void onFailure(Call<SuccessResponse<ProductResponse>> call, Throwable t) {
                Log.e("onFailure", t.getMessage());
            }
        });
    }

    public void ClickedFetchAll(View view) {
        findListProduct();
    }

    public void ClickUpdated(View view) {
        updateNewProduct("PC", 5, "2023-01-01", 1000, "654e7c1a414c1b5cc58958b4");
    }

    public void ClickedNewProduct(View view) {
        createNewProduct("PC", 5, "2023-01-01", 1000);
    }

    public void ClickedFindProduct(View view) {
        findProductById("654cfc6962edd9e77be8c79b");
    }
}