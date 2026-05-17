package com.ecommerce.services;

import com.ecommerce.entities.Basket;
import com.ecommerce.repositories.BasketRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService {
    BasketRepository basketRepository;

    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


    public void addBasket(Basket basket) {
        basketRepository.save(basket);
    }


    public void deleteBasketById(Long id) {
        basketRepository.deleteById(id);
    }
}
