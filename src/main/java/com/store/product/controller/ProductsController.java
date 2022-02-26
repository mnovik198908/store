package com.store.product.controller;

import com.store.product.domain.Product;
import com.store.product.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductsController {

    private final ProductRepository productRepository;

    public ProductsController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getProducts(@PathVariable Long id) {
        return productRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createProduct(@Valid @RequestBody Product product) throws URISyntaxException {
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.created(new URI("/product/" + savedProduct.getId())).body(savedProduct);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        Product currentProduct = productRepository.findById(id).orElseThrow(RuntimeException::new);
        currentProduct.setName(product.getName());
        currentProduct.setSku(product.getSku());
        currentProduct.setBrand(product.getBrand());
        currentProduct.setSize(product.getSize());
        currentProduct.setPrice(product.getPrice());
        currentProduct.setPrincipalImage(product.getPrincipalImage());
        // currentProduct.setOtherImages(product.getOtherImages());
        currentProduct = productRepository.save(product);

        return ResponseEntity.ok(currentProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
