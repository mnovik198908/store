package com.store.product.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;
import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private List<ImageUrl> otherImages;
}