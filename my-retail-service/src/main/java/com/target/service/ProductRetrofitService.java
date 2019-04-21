package com.target.service;

import com.target.model.Product;
import com.target.model.ProductPrice;
import com.target.model.ProductResponseDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * interface containing all external(third party) API calls
 */
interface ProductRetrofitService {

    /**
     * this is tested for product id 13860428
     * @param productId
     * @return Product info
     */
    @GET("tcin/{id}")
    Call<Product> getProductDetails(@Path(value = "id") Long productId);


    @GET("tcin/{id}/price")
    /**
     * assumption that such an API exists which returns pricing against a product
     * @param productId
     */
    Call<ProductPrice> getProductPrice(@Path(value = "id")Long productId);

    /**
     * assumption that such an API exists which saves product details and price details.These 2 can be segregated also as per requirement.
     * @param productId
     * @return Product (saved details dto)
     */
    @POST("tcin/{id}")
    Call<ProductResponseDto> saveProductDetails(@Path(value = "id") Long productId);




}
