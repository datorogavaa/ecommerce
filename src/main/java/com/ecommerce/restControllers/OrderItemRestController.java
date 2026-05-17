package com.ecommerce.restControllers;

import com.ecommerce.services.OrderItemService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderItemRestController {

    OrderItemService orderItemService;

    public OrderItemRestController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }


}
