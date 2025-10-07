package com.logesh.eazystore.repository;

import com.logesh.eazystore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
  }
