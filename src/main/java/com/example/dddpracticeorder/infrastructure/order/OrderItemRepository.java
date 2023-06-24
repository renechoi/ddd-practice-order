package com.example.dddpracticeorder.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.order.item.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
