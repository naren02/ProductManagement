package com.techservices.productservice.service;

import com.techservices.productservice.dto.ProductRequest;
import com.techservices.productservice.dto.ProductResponse;
import com.techservices.productservice.model.Product;
import com.techservices.productservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    @Autowired
    private final ProductRepository productRepository;

    public ProductResponse createProduct(ProductRequest product){
        log.info("product name {}", product.getName());
        log.info("product desc {}", product.getDesc());
        log.info("product price {}", product.getPrice());
        Product productRequest = Product.builder()
                .name(product.getName())
                .desc(product.getDesc())
                .price(product.getPrice())
                .build();
        ProductResponse response = ProductResponse.builder().build();
        BeanUtils.copyProperties(productRequest , response );
        productRepository.save(productRequest);
        log.info("Product Saved into DB Successfully {}", productRequest.getId());
        return response;
    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
      //  products.stream().map(this::mapProductToResponse).collect();
        return products.stream().map(this::mapProductToResponse).collect(Collectors.toList());

    }

    private ProductResponse mapProductToResponse(Product product){
        ProductResponse productResponse = ProductResponse.builder().build();
        BeanUtils.copyProperties(product, productResponse);
        return productResponse;
    }
}
