package com.target.service;


import com.target.model.ProductResponseDto;

 public interface RetailService {

    ProductResponseDto getProductById(Long productId);

    ProductResponseDto saveProductDetails(ProductResponseDto productRequest);
}
