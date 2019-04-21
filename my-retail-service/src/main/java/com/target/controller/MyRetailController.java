package com.target.controller;



import com.target.model.ProductPrice;
import com.target.model.ProductResponseDto;
import com.target.service.RetailService;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController

public class MyRetailController {

    @Autowired
    RetailService retailService;

    @GetMapping(value = "/product/{id}")
    /** gets product detailed info + pricing info for a given id
     * @param id -expects a test value-13860428 against which results are tested
     */
    public ProductResponseDto getProductByID(@PathVariable("id") Long productId) {
        return retailService.getProductById(productId);
    }


    @PostMapping(value = "/product/{id}")
    /** saves product info to external API ,generates mocked response
     * @param id- mocked response generated assuming an external POST API exists
     */
    public ProductResponseDto saveProductDetails(@RequestBody ProductResponseDto productRequest){
        return retailService.saveProductDetails(productRequest);
    }
}
