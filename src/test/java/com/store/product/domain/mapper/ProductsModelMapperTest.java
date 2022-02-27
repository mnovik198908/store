package com.store.product.domain.mapper;

import static com.store.product.common.BuildProducts.*;
import com.store.product.domain.model.ProductResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductsModelMapperTest {

    @InjectMocks
    ProductsModelMapper productsModelMapper;

    @Test
    void map() {
        List<ProductResponse> products = productsModelMapper.map(getProductsMock());
        assertNotNull(products);
        assertEquals(2,products.size());
    }

    @Test
    void mapProductWithOtherImages() {
        List<ProductResponse> products = productsModelMapper.map(getProductsWithOtherImagesMock());
        assertNotNull(products);
        assertEquals(1,products.size());
    }

    @Test
    void productModelMapper() {
        ProductResponse product = productsModelMapper.productModelMapper(getProductOne());
        assertNotNull(product);
        assertEquals(PRODUCT_NAME_ONE,product.getName());
    }
}