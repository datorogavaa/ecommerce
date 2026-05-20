package com.ecommerce.services;

import com.ecommerce.entities.Basket;
import com.ecommerce.entities.BasketItem;
import com.ecommerce.repositories.BasketRepository;
import com.ecommerce.repositories.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class BasketService {
    BasketRepository basketRepository;
    ProductRepository productRepository;
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }


    public void addBasket(Basket basket) {
        basketRepository.save(basket);
    }

    public void deleteBasketById(Long id) {
        basketRepository.deleteById(id);
    }

    public Basket getBasketById(Long id) {
        return basketRepository.findById(id).orElseThrow(() -> new RuntimeException("Basket not found with id: " + id));
    }


    @Transactional
    public void addProductToBasket(Long basketId, BasketItem basketItem) {

        Basket basket = getBasketById(basketId);

        if (basket.getBasketItemList() == null) {
            basket.setBasketItemList(new ArrayList<>());
        }

        Optional<BasketItem> existingItem = basket.getBasketItemList().stream()
                .filter(item -> item.getProduct().getId()
                        .equals(basketItem.getProduct().getId()))
                .findFirst();

        if (existingItem.isPresent()) {
            existingItem.get().setQuantity(
                    existingItem.get().getQuantity() + basketItem.getQuantity()
            );

        } else {
            basketItem.setBasket(basket);
            basket.getBasketItemList().add(basketItem);
        }

        basketRepository.save(basket);
    }


    @Transactional
    public void removeProductFromBasket(Long basketId, Long productId) {
        Basket basket = getBasketById(basketId);

        if (basket.getBasketItemList() != null) {
            basket.getBasketItemList().removeIf(item -> item.getProduct().getId().equals(productId));
            basketRepository.save(basket);
        }
    }
}
