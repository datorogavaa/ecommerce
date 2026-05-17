package com.ecommerce.restControllers;

import com.ecommerce.repositories.BasketRepository;
import com.ecommerce.services.BasketService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasketRestController {
    BasketService basketService;
    public BasketRestController(BasketService basketService) {
        this.basketService = basketService;
    }


}
