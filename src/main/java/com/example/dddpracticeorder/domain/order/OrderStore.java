package com.example.dddpracticeorder.domain.order;

import com.example.dddpracticeorder.domain.order.item.OrderItem;
import com.example.dddpracticeorder.domain.order.item.OrderItemOption;
import com.example.dddpracticeorder.domain.order.item.OrderItemOptionGroup;

public interface OrderStore {
    Order store(Order order);
    OrderItem store(OrderItem orderItem);
    OrderItemOptionGroup store(OrderItemOptionGroup orderItemOptionGroup);
    OrderItemOption store(OrderItemOption orderItemOption);
}
