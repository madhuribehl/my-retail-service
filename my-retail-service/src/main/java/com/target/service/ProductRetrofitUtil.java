package com.target.service;

import com.target.model.Item;
import com.target.model.Product;
import com.target.model.ProductClassification;
import com.target.model.ProductNameDto;
import com.target.model.ProductPrice;
import com.target.model.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

@Slf4j
@Component
public class ProductRetrofitUtil {

    @Autowired
    RetrofitAdapter retrofitAdapter;

    /**
     *
     * @param productId
     * @return Product (all details of product)
     */
    public Product getProductDetails(Long productId) {
        ProductRetrofitService service=buildProductRetrofitClient();
        Call<Product> callSync = service.getProductDetails(productId);
        try {
            Response<Product> response = callSync.execute();
            return response.body();
        } catch (Exception ex) {
            log.error("Error while executing retrofit call to fetch product details", ex, ex.getStackTrace());
        }

        return null;
    }

    /**
     *
     * @param productId
     * @return ProductPrice (pricing info of product)
     */
    public ProductPrice getProductPrice(Long productId){
        ProductRetrofitService service=buildProductRetrofitClient();
        Call<ProductPrice> callSync = service.getProductPrice(productId);
        try {
            /*would be needed if the external API actually exists*/
            Response<ProductPrice> response = callSync.execute();
            return getMockedProductPrice();
        } catch (Exception ex) {
            log.error("Error while executing retrofit call to fetch product price", ex, ex.getStackTrace());
        }

        return null;
    }

    /**
     *
     * @param productId
     * @return ProductResponseDto (saved details of a product)
     */
    public ProductResponseDto saveProductDetails(Long productId) {
        ProductRetrofitService service=buildProductRetrofitClient();
        Call<ProductResponseDto> callSync = service.saveProductDetails(productId);
        try {
             /*would be needed if the external API actually exists*/
            Response<ProductResponseDto> response = callSync.execute();
            ProductResponseDto mockedResponse = mockResponse();
            return mockedResponse;
        } catch (Exception ex) {
            log.error("Error while executing retrofit call", ex, ex.getStackTrace());
        }

        return null;
    }

    /**
     *
     * @return RetrofitObject
     */
    private ProductRetrofitService buildProductRetrofitClient(){
        Retrofit retrofit = retrofitAdapter.buildRetrofitClient();
        return retrofit.create(ProductRetrofitService.class);

    }

    /**
     *
     * @return ProductPrice(mocked)
     */
    private ProductPrice getMockedProductPrice() {
        return ProductPrice.builder().value(13.49).currency_code("USD").build();
    }

    /**
     *
     * @return ProductResponseDto(mocked)
     */
    private ProductResponseDto mockResponse() {
        return ProductResponseDto.builder().id(13860428L).
                product(Product.builder().product(ProductNameDto.builder().
                        item(Item.builder().product_classification(ProductClassification.builder().
                                product_type("542").product_type_name("ELECTRONICS").item_type_name("MOVIES").
                                build()).build()).build()).build()).price(ProductPrice.builder().value(13.49).currency_code("USD").
                build()).build();
    }
}
