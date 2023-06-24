package com.example.dddpracticeorder.infrastructure.order.payment;

import org.springframework.stereotype.Component;

import com.example.dddpracticeorder.domain.order.OrderCommand;
import com.example.dddpracticeorder.domain.order.payment.PayMethod;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class TossPayApiCaller implements PaymentApiCaller {

    @Override
    public boolean support(PayMethod payMethod) {
        return PayMethod.TOSS_PAY == payMethod;
    }

    @Override
    public void pay(OrderCommand.PaymentRequest request) {
        // TODO - 구현
    }
}
