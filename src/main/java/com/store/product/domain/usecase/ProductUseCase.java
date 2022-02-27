package com.store.product.domain.usecase;

import com.store.product.domain.entity.ImageUrl;
import com.store.product.domain.entity.Product;
import com.store.product.domain.mapper.ProductsModelMapper;
import com.store.product.domain.model.ProductRequest;
import com.store.product.domain.model.ProductResponse;
import com.store.product.repository.ImageUrlRepository;
import com.store.product.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductUseCase {

    private final ProductRepository productRepository;
    private final ImageUrlRepository imageUrlRepository;
    private final ProductsModelMapper productsModelMapper;

    public ProductUseCase(
            ProductRepository productRepository,
            ImageUrlRepository imageUrlRepository,
            ProductsModelMapper productsModelMapper) {
        this.productRepository = productRepository;
        this.imageUrlRepository = imageUrlRepository;
        this.productsModelMapper = productsModelMapper;
    }

    public List<ProductResponse> getProducts() {
        return productsModelMapper.map(productRepository.findAll());
    }

    public ProductResponse getProductsById(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return productsModelMapper.productModelMapper(product);
    }

    public Product save(ProductRequest product) {

        Product productNew = createProduct(product);
        Product savedProduct = productRepository.save(productNew);

        if(product.getOtherImages() != null && product.getOtherImages().size() > 0){
            for (ImageUrl imageUrl : product.getOtherImages()) {
                imageUrl.setProduct(savedProduct);
                imageUrlRepository.save(imageUrl);
            }
        }

        return savedProduct;
    }

    public Product update(Long id, ProductRequest product) {
        Product productUpdate = createProduct(product);
        Product currentProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
        currentProduct.setName(productUpdate.getName());
        currentProduct.setSku(productUpdate.getSku());
        currentProduct.setBrand(productUpdate.getBrand());
        currentProduct.setSize(productUpdate.getSize());
        currentProduct.setPrice(productUpdate.getPrice());
        currentProduct.setPrincipalImage(productUpdate.getPrincipalImage());

        currentProduct = productRepository.save(currentProduct);
        if(product.getOtherImages() != null && product.getOtherImages().size() > 0){
            for (ImageUrl imageUrl : product.getOtherImages()) {
                imageUrl.setProduct(currentProduct);
                imageUrlRepository.save(imageUrl);
            }
        }

        return currentProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    private Product createProduct(ProductRequest product) {
        return Product.builder()
                .name(product.getName())
                .sku(product.getSku())
                .brand(product.getBrand())
                .size(product.getSize())
                .price(product.getPrice())
                .principalImage((product.getPrincipalImage()))
                .build();
    }
}

