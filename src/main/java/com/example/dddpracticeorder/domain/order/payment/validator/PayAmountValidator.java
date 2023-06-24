package com.example.dddpracticeorder.domain.order.payment.validator;

import org.springframework.stereotype.Component;

import com.example.dddpracticeorder.common.exception.InvalidParamException;
import com.example.dddpracticeorder.domain.order.Order;
import com.example.dddpracticeorder.domain.order.OrderCommand;

@org.springframework.core.annotation.Order(value = 1)
@Component
public class PayAmountValidator implements PaymentValidator {

    @Override
    public void validate(Order order, OrderCommand.PaymentRequest paymentRequest) {
        if (!order.calculateTotalAmount().equals(paymentRequest.getAmount()))
            throw new InvalidParamException("주문가격이 불일치합니다");
    }
}
