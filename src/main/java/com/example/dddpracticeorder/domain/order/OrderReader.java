package com.example.dddpracticeorder.domain.order;

public interface OrderReader {
    Order getOrder(String orderToken);
}
