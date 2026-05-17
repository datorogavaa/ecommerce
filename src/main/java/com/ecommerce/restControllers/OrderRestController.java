package com.ecommerce.restControllers;

import com.ecommerce.entities.Order;
import com.ecommerce.entities.OrderItem;
import com.ecommerce.services.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class OrderRestController {
        OrderService orderService;

        public OrderRestController(OrderService orderService) {
            this.orderService = orderService;
        }

        @PostMapping("/addOrder")
        public ResponseEntity<String> addOrder(@RequestBody Order order) {
            orderService.addOrder(order);
            return ResponseEntity.status(201).body("Order created successfully");
        }

        @GetMapping("/order/{id}")
        public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
            return ResponseEntity.status(200).body(orderService.getOrderById(id));
        }


        @DeleteMapping("/deleteOrder/{id}")
        public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
            orderService.deleteOrder(id);
            return ResponseEntity.status(204).body("Order deleted successfully");
        }

}
