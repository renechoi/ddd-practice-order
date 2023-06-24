package com.example.dddpracticeorder.domain.order;

import java.util.List;

import com.example.dddpracticeorder.domain.order.item.OrderItem;

public interface OrderItemSeriesFactory {
    List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder);
}
