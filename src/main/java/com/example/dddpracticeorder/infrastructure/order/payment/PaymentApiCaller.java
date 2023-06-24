package com.example.dddpracticeorder.infrastructure.order.payment;

import com.example.dddpracticeorder.domain.order.OrderCommand;
import com.example.dddpracticeorder.domain.order.payment.PayMethod;

public interface PaymentApiCaller {
    boolean support(PayMethod payMethod);
    void pay(OrderCommand.PaymentRequest request);
}
