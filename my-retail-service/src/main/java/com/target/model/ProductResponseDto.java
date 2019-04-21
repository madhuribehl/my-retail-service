package com.target.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ProductResponseDto {

    private Long id;
    private Product product;
    private ProductPrice price;
}
