package com.techservices.productservice.controller;

import com.techservices.productservice.dto.ProductRequest;
import com.techservices.productservice.dto.ProductResponse;
import com.techservices.productservice.model.Product;
import com.techservices.productservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
@AllArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping(value = "/create")
    @ResponseStatus(value = HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest request){
        ProductResponse response = productService.createProduct(request);
        return response;
    }

    @GetMapping(value = "/getAll")
    @ResponseStatus(value = HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();
    }

}
