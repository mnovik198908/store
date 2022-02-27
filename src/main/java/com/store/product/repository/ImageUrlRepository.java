package com.store.product.repository;

import com.store.product.domain.entity.ImageUrl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageUrlRepository extends JpaRepository<ImageUrl, Long> {
}