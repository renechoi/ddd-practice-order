package com.example.dddpracticeorder.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.order.item.OrderItemOptionGroup;

public interface OrderItemOptionGroupRepository extends JpaRepository<OrderItemOptionGroup, Long> {
}
