package com.target.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductPrice {

    private Double value;
    //can be converted to an enum if all codes are known
    private String currency_code;

}
