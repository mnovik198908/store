package com.store.product.domain;

import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Entity
@Valid
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    private String name;

    @NotNull
    @Min(1000000)
    @Max(99999999)
    private Integer sku;

    @NotBlank
    @NotNull
    @Size(min = 3, max = 50)
    private String brand;

    @NotNull
    private Integer size;

    @NotNull
    @Min(1)
    @Max(99999999)
    private Double price;

    @NotNull
    @URL
    private String principalImage;

    //private List<String> otherImages;

    public Product() {
    }

    public Product( String name, Integer sku, String brand, Integer size, Double price, String principalImage) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.principalImage = principalImage;
    }

    public Product(Long id, String name, Integer sku, String brand, Integer size, Double price, String principalImage) {
        this.id = id;
        this.name = name;
        this.sku = sku;
        this.brand = brand;
        this.size = size;
        this.price = price;
        this.principalImage = principalImage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSku() {
        return sku;
    }

    public void setSku(Integer sku) {
        this.sku = sku;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getPrincipalImage() {
        return principalImage;
    }

    public void setPrincipalImage(String principalImage) {
        this.principalImage = principalImage;
    }
}