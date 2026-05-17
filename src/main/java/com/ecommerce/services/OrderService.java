package com.ecommerce.services;

import com.ecommerce.entities.Order;
import com.ecommerce.entities.OrderItem;
import com.ecommerce.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void addOrder(Order order) {
        orderRepository.save(order);
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }



    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }

}
