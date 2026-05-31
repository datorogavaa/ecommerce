package com.ecommerce.restControllers;

import com.ecommerce.entities.BasketItem;
import com.ecommerce.services.BasketService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
public class BasketRestController {
    BasketService basketService;
    public BasketRestController(BasketService basketService) {
        this.basketService = basketService;
    }


    @PatchMapping("/addToBasket/{basketId}")
    public void addToBasket(@PathVariable Long basketId,@Valid @RequestBody BasketItem basketItem) {
        basketService.addProductToBasket(basketId, basketItem);
    }

    @PatchMapping("removeFromBasket/{basketId}")
    public void removeFromBasket(@PathVariable Long basketId, @Valid @RequestBody Long productId) {
        basketService.removeProductFromBasket(basketId, productId);
    }

}
