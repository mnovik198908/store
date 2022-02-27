package com.store.product.domain.mapper;

import com.store.product.domain.entity.Product;
import com.store.product.domain.model.ImageUrlResponse;
import com.store.product.domain.model.ProductResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductsModelMapper {

    public List<ProductResponse> map(List<Product> products) {
        return products.stream().map(product -> productModelMapper(product)).collect(Collectors.toList());
    }

    public ProductResponse productModelMapper(Product product) {

        List<ImageUrlResponse> imageUrlsMap = product.getOtherImages() != null && product.getOtherImages().size() > 0
                ? product.getOtherImages().stream().map(imageUrl -> (ImageUrlResponse.builder()
                    .id(imageUrl.getId())
                    .url(imageUrl.getUrl())
                    .build())
        ).collect(Collectors.toList())
                : new ArrayList<ImageUrlResponse>();

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .sku(product.getSku())
                .brand(product.getBrand())
                .size(product.getSize())
                .price(product.getPrice())
                .principalImage((product.getPrincipalImage()))
                .otherImages(imageUrlsMap)
                .build();
    }

}
