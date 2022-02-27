package com.store.product.controller;

import com.store.product.domain.entity.Product;
import com.store.product.domain.model.ProductRequest;
import com.store.product.domain.model.ProductResponse;
import com.store.product.domain.usecase.ProductUseCase;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static com.store.product.common.BuildProducts.*;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    @InjectMocks
    ProductsController productsController;

    @Mock
    ProductUseCase productUseCase;

    @Test
    void getProductsEmptyList() {
        when(productUseCase.getProducts()).thenReturn(new ArrayList<>());
        List<ProductResponse> response = productsController.getProducts();

        assertNotNull(response);
        assertEquals(0,response.size());
    }

    @Test
    void getProductsWithElements() {
        when(productUseCase.getProducts()).thenReturn(getProductsResponseMock());
        List<ProductResponse> response = productsController.getProducts();

        assertNotNull(response);
        assertEquals(2,response.size());
    }

    @Test
    void getProductsById() {
        when(productUseCase.getProductsById(PRODUCT_ID_ONE)).thenReturn(getProductResponseOne());
        ProductResponse response = productsController.getProducts(PRODUCT_ID_ONE);

        assertNotNull(response);
    }

    @Test
    void createProduct() throws URISyntaxException {
        when(productUseCase.save(any(ProductRequest.class))).thenReturn(getProductOne());
        ResponseEntity<Product> response = productsController.createProduct(getProductRequest());
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    void createProductBadRequestWithNameIncorrect() {
        assertThrows(Exception.class, () -> {
            productsController.createProduct(getProductRequestWithNameIncorrect());
        });
    }

    @Test
    void updateProduct() throws URISyntaxException {
        when(productUseCase.update(any(), any(ProductRequest.class))).thenReturn(getProductUpdate());
        ResponseEntity<Product> response = productsController.updateProduct(PRODUCT_ID_ONE, getProductRequestUpdate());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void deleteProduct() {
        productsController.deleteProduct(getProductOne().getId());
        verify(productUseCase).deleteProduct(getProductOne().getId());
    }
}