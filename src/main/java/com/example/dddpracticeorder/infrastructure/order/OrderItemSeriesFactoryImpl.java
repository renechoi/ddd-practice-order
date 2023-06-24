package com.example.dddpracticeorder.infrastructure.order;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.dddpracticeorder.domain.item.ItemReader;
import com.example.dddpracticeorder.domain.order.Order;
import com.example.dddpracticeorder.domain.order.OrderCommand;
import com.example.dddpracticeorder.domain.order.OrderItemSeriesFactory;
import com.example.dddpracticeorder.domain.order.OrderStore;
import com.example.dddpracticeorder.domain.order.item.OrderItem;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderItemSeriesFactoryImpl implements OrderItemSeriesFactory {
    private final ItemReader itemReader;
    private final OrderStore orderStore;

    @Override
    public List<OrderItem> store(Order order, OrderCommand.RegisterOrder requestOrder) {
        return requestOrder.getOrderItemList().stream()
                .map(orderItemRequest -> {
                    var item = itemReader.getItemBy(orderItemRequest.getItemToken());
                    var initOrderItem = orderItemRequest.toEntity(order, item);
                    var orderItem = orderStore.store(initOrderItem);

                    orderItemRequest.getOrderItemOptionGroupList().forEach(orderItemOptionGroupRequest -> {
                        var initOrderItemOptionGroup = orderItemOptionGroupRequest.toEntity(orderItem);
                        var orderItemOptionGroup = orderStore.store(initOrderItemOptionGroup);

                        orderItemOptionGroupRequest.getOrderItemOptionList().forEach(orderItemOptionRequest -> {
                            var initOrderItemOption = orderItemOptionRequest.toEntity(orderItemOptionGroup);
                            orderStore.store(initOrderItemOption);
                        });
                    });
                    return orderItem;
                }).collect(Collectors.toList());
    }
}
