package com.ecommerce.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
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

}
