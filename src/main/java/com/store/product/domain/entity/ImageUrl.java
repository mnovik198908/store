package com.store.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Valid
@Table(name = "image_url")
public class ImageUrl {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @URL
    private String url;

    @ManyToOne
    @JoinColumn(name = "product", nullable = false, updatable = false)
    private Product product;
}