package com.logesh.eazystore.service;

import com.logesh.eazystore.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProducts();
}
