package com.target.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private String dpci;
    private String upc;
    private String buy_url;
    private String country_of_origin;
    private String relationship_type_code;
    private boolean subscription_eligible;
    private ProductClassification product_classification;
}
