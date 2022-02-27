package com.store.product.domain.model;

import com.store.product.domain.entity.ImageUrl;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequest {

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

    private List<ImageUrl> otherImages;
}