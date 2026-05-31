package com.ecommerce.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.util.List;

@Data
public class ProductDto {

    private Long id;
    @NotEmpty(message = "Product name cannot be empty")
    private String name;
    @NotEmpty(message = "Product description cannot be empty")
    private String description;
    @NotEmpty(message = "Product category cannot be empty")
    private String category;
    @NotEmpty(message = "Product image URL cannot be empty")
    private List<String> imageUrl;
    @NotNull
    @Positive(message = "Price must be positive")
    private Double price;
    @Positive(message = "Quantity must be positive")
    private Long quantity;
}
