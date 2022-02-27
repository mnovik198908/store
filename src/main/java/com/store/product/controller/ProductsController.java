package com.store.product.controller;

import com.store.product.domain.entity.Product;
import com.store.product.domain.model.ProductRequest;
import com.store.product.domain.model.ProductResponse;
import com.store.product.domain.usecase.ProductUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductUseCase productUseCase;

    public ProductsController(ProductUseCase productUseCase) {
        this.productUseCase = productUseCase;
    }

    @GetMapping
    public List<ProductResponse> getProducts() {
        return productUseCase.getProducts();
    }

    @GetMapping("/{id}")
    public ProductResponse getProducts(@PathVariable Long id) {
        return productUseCase.getProductsById(id);
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody ProductRequest product) throws URISyntaxException {
        Product savedProduct = productUseCase.save(product);
        return ResponseEntity.created(new URI("/product/" + savedProduct.getId())).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @Valid @RequestBody ProductRequest product) {
        Product currentProduct = productUseCase.update(id, product);

        return ResponseEntity.ok(currentProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productUseCase.deleteProduct(id);
        return ResponseEntity.ok().build();
    }

}
