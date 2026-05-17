package com.ecommerce.repositories;

import com.ecommerce.entities.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BasketRepository extends JpaRepository<Basket, Long> {
}
