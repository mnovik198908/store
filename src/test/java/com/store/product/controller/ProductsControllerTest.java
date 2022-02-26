package com.store.product.controller;

import com.store.product.domain.Product;
import com.store.product.repository.ProductRepository;
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
import java.util.Optional;

import static com.store.product.common.BuildProducts.*;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductsControllerTest {

    @InjectMocks
    ProductsController productsController;

    @Mock
    ProductRepository productRepository;

    @Test
    void getProductsEmptyList() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        List<Product> response = productsController.getProducts();

        assertNotNull(response);
        assertEquals(0,response.size());
    }

    @Test
    void getProductsWithElements() {
        when(productRepository.findAll()).thenReturn(getProductsMock());
        List<Product> response = productsController.getProducts();

        assertNotNull(response);
        assertEquals(2,response.size());
    }

    @Test
    void getProductsById() {
        doReturn(Optional.of(getProductOne())).when(productRepository).findById(PRODUCT_ID_ONE);
        Product response = productsController.getProducts(PRODUCT_ID_ONE);

        assertNotNull(response);
    }

    @Test
    public void whenIdIsNullInGetProductsById_thenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> Optional
                .ofNullable(productsController.getProducts(null))
                .orElseThrow(RuntimeException::new));
    }

    @Test
    void createProduct() throws URISyntaxException {
        when(productRepository.save(any(Product.class))).thenReturn(getProductOne());
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
        doReturn(Optional.of(getProductOne())).when(productRepository).findById(PRODUCT_ID_ONE);
        when(productRepository.save(any(Product.class))).thenReturn(getProductRequestUpdate());
        ResponseEntity<Product> response = productsController.updateProduct(PRODUCT_ID_ONE, getProductRequestUpdate());
        assertNotNull(response);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    void updateProductBadRequestWithNameIncorrect() {
        assertThrows(Exception.class, () -> {
            productsController.updateProduct(PRODUCT_ID_ONE, getProductRequesUpdatetWithNameIncorrect());
        });
    }

    @Test
    public void whenIdIsNullInUpdateProductsById_thenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> Optional
                .ofNullable(productsController.updateProduct(null, getProductRequestUpdate()))
                .orElseThrow(RuntimeException::new));
    }

    @Test
    void deleteProduct() {
        productsController.deleteProduct(getProductOne().getId());
        verify(productRepository).deleteById(getProductOne().getId());
    }
}