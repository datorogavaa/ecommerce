package com.ecommerce.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @NotEmpty(message = "Product name cannot be empty")
    private String name;

    @NotEmpty(message = "Product description cannot be empty")
    private String description;

    @NonNull
    private Double price;

    @NotEmpty(message = "Product category cannot be empty")
    private String category;

    @NotEmpty(message = "Product image URL cannot be empty")
    private List<String> imageUrl;

    private Long quantity;

}
