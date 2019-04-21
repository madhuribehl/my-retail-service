package com.target.service;


import com.target.model.ProductPrice;
import com.target.model.ProductResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
class RetailServiceImpl implements RetailService{

    @Autowired
    ProductRetrofitUtil retrofitUtil;

    /**
     *
     * @param productId
     * @return ProductResponseDto containing product detailed info and pricing info
     */
    @Override
    public ProductResponseDto getProductById(Long productId) {
        return ProductResponseDto.builder().id(productId).product(retrofitUtil.getProductDetails(productId)).
                price(retrofitUtil.getProductPrice(productId)).build();
    }

    /**
     *
     * @param productRequest
     * @return similarRequest as a success indicator of save call
     */
    @Override
    public ProductResponseDto saveProductDetails(ProductResponseDto productRequest) {
       ProductResponseDto responseDto= retrofitUtil.saveProductDetails(productRequest.getId());
         return ProductResponseDto.builder().id(productRequest.getId()).product(responseDto.getProduct()).price(responseDto.getPrice()).build();
    }
}
