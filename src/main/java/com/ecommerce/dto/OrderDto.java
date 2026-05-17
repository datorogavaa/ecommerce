package com.ecommerce.dto;

import com.ecommerce.entities.OrderItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderDto {
    private Long userId;
    private Long orderId;
    private List<OrderItem> orderItems;

}
