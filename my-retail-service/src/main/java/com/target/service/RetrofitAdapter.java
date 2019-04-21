package com.target.service;


import com.target.model.Item;
import com.target.model.Product;
import com.target.model.ProductClassification;
import com.target.model.ProductNameDto;
import com.target.model.ProductPrice;
import com.target.model.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


@Slf4j
@Component
public class RetrofitAdapter<T> {

    final static String baseUrl = "https://redsky.target.com/v2/pdp/";

    /**
     * builds RetrofitClient to interact with specified API.
     * @return RetrofitClient
     */
    public Retrofit buildRetrofitClient() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        return retrofit;
    }




}


