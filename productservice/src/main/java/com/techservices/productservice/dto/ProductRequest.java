package com.techservices.productservice.dto;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "product")
public class ProductRequest {
    @Id
    private String id;

    private String name;
    private String desc;

    private Double price;

}
