package com.store.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {

    private Long id;
    private String name;
    private Integer sku;
    private String brand;
    private Integer size;
    private Double price;
    private String principalImage;
    private List<ImageUrlResponse> otherImages;
}