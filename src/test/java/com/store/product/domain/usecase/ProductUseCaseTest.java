package com.store.product.domain.usecase;

import com.store.product.domain.entity.Product;
import com.store.product.domain.mapper.ProductsModelMapper;
import com.store.product.domain.model.ProductResponse;
import com.store.product.repository.ImageUrlRepository;
import com.store.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.store.product.common.BuildProducts.*;
import static org.mockito.ArgumentMatchers.any;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductUseCaseTest {

    @InjectMocks
    ProductUseCase productUseCase;

    @Mock
    ProductRepository productRepository;
    @Mock
    ImageUrlRepository imageUrlRepository;

    @Mock
    ProductsModelMapper productsModelMapper;

    @Test
    void getProductsEmptyList() {
        when(productRepository.findAll()).thenReturn(new ArrayList<>());
        List<ProductResponse> response = productUseCase.getProducts();

        assertNotNull(response);
        assertEquals(0,response.size());
    }

    @Test
    void getProductsWithElements() {
        when(productRepository.findAll()).thenReturn(getProductsMock());
        when(productsModelMapper.map(any())).thenReturn(getProductsResponseMock());
        List<ProductResponse> response = productUseCase.getProducts();

        assertNotNull(response);
        assertEquals(2,response.size());
    }

    @Test
    void getProductsById() {
        doReturn(Optional.of(getProductOne())).when(productRepository).findById(PRODUCT_ID_ONE);
        when(productsModelMapper.productModelMapper(any(Product.class))).thenReturn(getProductResponseOne());
        ProductResponse response = productUseCase.getProductsById(PRODUCT_ID_ONE);

        assertNotNull(response);
    }

    @Test
    public void whenIdIsNullInGetProductsById_thenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> Optional
                .ofNullable(productUseCase.getProductsById(null))
                .orElseThrow(RuntimeException::new));
    }

    @Test
    void createProduct() throws URISyntaxException {
        when(productRepository.save(any(Product.class))).thenReturn(getProductOne());
        Product response = productUseCase.save(getProductRequest());
        assertNotNull(response);
    }

    @Test
    void createProductWithOtherImages() throws URISyntaxException {
        when(productRepository.save(any(Product.class))).thenReturn(getProductWithOtherImagesOne());
        Product response = productUseCase.save(getProductWithOtherImagesRequestOne());
        assertNotNull(response);
        assertEquals(1,response.getOtherImages().size());
    }

    @Test
    void updateProduct() throws URISyntaxException {
        doReturn(Optional.of(getProductOne())).when(productRepository).findById(PRODUCT_ID_ONE);
        when(productRepository.save(any(Product.class))).thenReturn(getProductUpdate());
        Product response = productUseCase.update(PRODUCT_ID_ONE, getProductRequestUpdate());
        assertNotNull(response);
    }

    @Test
    void updateProductBadRequestWithNameIncorrect() {
        assertThrows(Exception.class, () -> {
            productUseCase.update(PRODUCT_ID_ONE, getProductRequesUpdatetWithNameIncorrect());
        });
    }

    @Test
    void updateProductWithOtherImages() throws URISyntaxException {
        doReturn(Optional.of(getProductOne())).when(productRepository).findById(PRODUCT_ID_ONE);
        when(productRepository.save(any(Product.class))).thenReturn(getProductWithOtherImagesOne());
        Product response = productUseCase.update(PRODUCT_ID_ONE, getProductWithOtherImagesRequestUpdateOne());
        assertNotNull(response);
        assertEquals(1,response.getOtherImages().size());
    }

    @Test
    public void whenIdIsNullInUpdateProductsById_thenExceptionIsThrown() {
        assertThrows(RuntimeException.class, () -> Optional
                .ofNullable(productUseCase.update(null, getProductRequestUpdate()))
                .orElseThrow(RuntimeException::new));
    }

    @Test
    void deleteProduct() {
        productUseCase.deleteProduct(getProductOne().getId());
        verify(productRepository).deleteById(getProductOne().getId());
    }
}