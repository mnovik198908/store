package com.store.product.common;


import com.store.product.domain.Product;

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
        return new Product(PRODUCT_ID_ONE, PRODUCT_NAME_ONE, PRODUCT_SKU_ONE,
                PRODUCT_BRAND_ONE, PRODUCT_SIZE_ONE, PRODUCT_PRICE_ONE, PRODUCT_PRINCIPAL_IMAGE_ONE);
    }

    public static Product getProductTwo() {
        return new Product(PRODUCT_ID_TWO, PRODUCT_NAME_TWO, PRODUCT_SKU_TWO,
                PRODUCT_BRAND_TWO, PRODUCT_SIZE_TWO, PRODUCT_PRICE_TWO, PRODUCT_PRINCIPAL_IMAGE_TWO);
    }

    public static Product getProductRequest() {
        return new Product(PRODUCT_NAME_ONE, PRODUCT_SKU_ONE,
                PRODUCT_BRAND_ONE, PRODUCT_SIZE_ONE, PRODUCT_PRICE_ONE, PRODUCT_PRINCIPAL_IMAGE_ONE);
    }

    public static Product getProductRequestWithNameIncorrect() {
        return new Product(PRODUCT_NAME_INCORRECT_ONE, PRODUCT_SKU_ONE,
                PRODUCT_BRAND_ONE, PRODUCT_SIZE_ONE, PRODUCT_PRICE_ONE, PRODUCT_PRINCIPAL_IMAGE_ONE);
    }

    public static Product getProductRequestUpdate() {
        return new Product(PRODUCT_ID_ONE, PRODUCT_NAME_TWO, PRODUCT_SKU_TWO,
                PRODUCT_BRAND_ONE, PRODUCT_SIZE_ONE, PRODUCT_PRICE_ONE, PRODUCT_PRINCIPAL_IMAGE_ONE);
    }

    public static Product getProductRequesUpdatetWithNameIncorrect() {
        return new Product(PRODUCT_ID_ONE, PRODUCT_NAME_INCORRECT_ONE, PRODUCT_SKU_ONE,
                PRODUCT_BRAND_ONE, PRODUCT_SIZE_ONE, PRODUCT_PRICE_ONE, PRODUCT_PRINCIPAL_IMAGE_ONE);
    }

    public static List<Product> getProductsMock() {
        return Arrays.asList(getProductOne(), getProductTwo());
    }
}
