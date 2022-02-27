package com.store.product.common;


import com.store.product.domain.entity.ImageUrl;
import com.store.product.domain.entity.Product;
import com.store.product.domain.model.ImageUrlResponse;
import com.store.product.domain.model.ProductRequest;
import com.store.product.domain.model.ProductResponse;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class BuildProducts {

    public static Long PRODUCT_ID_ONE = Long.valueOf(1);
    public static String PRODUCT_NAME_ONE = "Prueba";
    public static Integer PRODUCT_SKU_ONE = 1000000;
    public static String PRODUCT_BRAND_ONE = "Test";
    public static Integer PRODUCT_SIZE_ONE = 0;
    public static Double PRODUCT_PRICE_ONE = 2.04;
    public static String PRODUCT_PRINCIPAL_IMAGE_ONE = "http://imagen.com";

    public static Long PRODUCT_ID_TWO = Long.valueOf(1);
    public static String PRODUCT_NAME_TWO = "Prueba";
    public static Integer PRODUCT_SKU_TWO = 1000001;
    public static String PRODUCT_BRAND_TWO = "Test";
    public static Integer PRODUCT_SIZE_TWO = 0;
    public static Double PRODUCT_PRICE_TWO = 2.04;
    public static String PRODUCT_PRINCIPAL_IMAGE_TWO = "http://imagen.com";

    public static String PRODUCT_NAME_INCORRECT_ONE = "Pr";

    public static Product getProductOne() {
        return Product.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }

    public static Product getProductTwo() {
        return Product.builder()
                .id(PRODUCT_ID_TWO)
                .name(PRODUCT_NAME_TWO)
                .sku(PRODUCT_SKU_TWO)
                .brand(PRODUCT_BRAND_TWO)
                .size(PRODUCT_SIZE_TWO)
                .price(PRODUCT_PRICE_TWO)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_TWO))
                .build();
    }

    public static ProductResponse getProductResponseOne() {
        return ProductResponse.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }

    public static ProductResponse getProductResponseTwo() {
        return ProductResponse.builder()
                .id(PRODUCT_ID_TWO)
                .name(PRODUCT_NAME_TWO)
                .sku(PRODUCT_SKU_TWO)
                .brand(PRODUCT_BRAND_TWO)
                .size(PRODUCT_SIZE_TWO)
                .price(PRODUCT_PRICE_TWO)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_TWO))
                .build();
    }

    public static ProductRequest getProductRequest() {
        return ProductRequest.builder()
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }

    public static ProductRequest getProductRequestWithNameIncorrect() {
        return ProductRequest.builder()
                .name(PRODUCT_NAME_INCORRECT_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }

    public static Product getProductUpdate() {
        return Product.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_TWO)
                .sku(PRODUCT_SKU_TWO)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }

    public static ProductRequest getProductRequestUpdate() {
        return ProductRequest.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_TWO)
                .sku(PRODUCT_SKU_TWO)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }


    public static ProductRequest getProductRequesUpdatetWithNameIncorrect() {
        return ProductRequest.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_INCORRECT_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .build();
    }

    public static List<Product> getProductsMock() {
        return Arrays.asList(getProductOne(), getProductTwo());
    }

    public static List<ProductResponse> getProductsResponseMock() {
        return Arrays.asList(getProductResponseOne(), getProductResponseTwo());
    }

    public static List<ProductResponse> getProductsResponseWithOtherImagesMock() {
        return Arrays.asList(getProductResponseOne(), getProductResponseTwo());
    }

    public static ImageUrl getImageUrlDtoOne() {
        return ImageUrl.builder()
                .url(PRODUCT_PRINCIPAL_IMAGE_ONE)
                .build();
    }
    public static ImageUrl getImageUrlOne() {
        return ImageUrl.builder()
                .url(PRODUCT_PRINCIPAL_IMAGE_ONE)
                .product(getProductOne())
                .id(Long.valueOf(1))
                .build();
    }

    public static ImageUrlResponse getImageUrlResponseOne() {
        return ImageUrlResponse.builder()
                .url(PRODUCT_PRINCIPAL_IMAGE_ONE)
                .id(Long.valueOf(1))
                .build();
    }

    public static List<ImageUrl> getImageUrlRequestMock() {
        return Arrays.asList(getImageUrlDtoOne());
    }

    public static List<ImageUrl> getImageUrlMock() {
        return Arrays.asList(getImageUrlOne());
    }

    public static List<ImageUrlResponse> getImageUrlResponseMock() {
        return Arrays.asList(getImageUrlResponseOne());
    }

    public static Product getProductWithOtherImagesOne() {
        return Product.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .otherImages(getImageUrlMock())
                .build();
    }

    public static ProductRequest getProductWithOtherImagesRequestOne() {
        return ProductRequest.builder()
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .otherImages(getImageUrlRequestMock())
                .build();
    }

    public static ProductRequest getProductWithOtherImagesRequestUpdateOne() {
        return ProductRequest.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .otherImages(getImageUrlRequestMock())
                .build();
    }

    public static ProductResponse getProductResponseWithOtherImagesOne() {
        return ProductResponse.builder()
                .id(PRODUCT_ID_ONE)
                .name(PRODUCT_NAME_ONE)
                .sku(PRODUCT_SKU_ONE)
                .brand(PRODUCT_BRAND_ONE)
                .size(PRODUCT_SIZE_ONE)
                .price(PRODUCT_PRICE_ONE)
                .principalImage((PRODUCT_PRINCIPAL_IMAGE_ONE))
                .otherImages(getImageUrlResponseMock())
                .build();
    }

    public static List<Product> getProductsWithOtherImagesMock() {
        return Arrays.asList(getProductWithOtherImagesOne());
    }
}
