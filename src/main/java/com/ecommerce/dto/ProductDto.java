package com.ecommerce.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductDto {
    private String name;
    private String description;
    private String category;
    private List<String> imageUrl;
    private double price;
    private Long quantity;

}
