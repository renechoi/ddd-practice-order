package com.example.dddpracticeorder.infrastructure.order;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dddpracticeorder.domain.order.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByOrderToken(String orderToken);
}
