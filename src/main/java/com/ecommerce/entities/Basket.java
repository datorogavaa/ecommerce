package com.ecommerce.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Basket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "basket_id")
    private Long id;

    @OneToOne
    private User user;

    @OneToMany(mappedBy = "basket", cascade = CascadeType.ALL , orphanRemoval = true)
    private List<OrderItem> orderItemList;

}
