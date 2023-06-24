package com.example.dddpracticeorder.infrastructure.order;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.order.item.OrderItemOption;

public interface OrderItemOptionRepository extends JpaRepository<OrderItemOption, Long> {
}
