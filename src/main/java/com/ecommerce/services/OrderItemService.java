package com.ecommerce.services;

import com.ecommerce.entities.Order;
import com.ecommerce.entities.OrderItem;
import com.ecommerce.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class OrderItemService {
    OrderItemRepository orderItemRepository;
    public OrderItemService(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }
    public OrderItem getOrderItemById(Long id) {
        return orderItemRepository.findById(id).orElse(null);
    }
    public void updateOrderItem(OrderItem orderItem) {
        orderItemRepository.save(orderItem);
    }

    public void deleteOrderItem(Long id) {
        orderItemRepository.deleteById(id);
    }
}
