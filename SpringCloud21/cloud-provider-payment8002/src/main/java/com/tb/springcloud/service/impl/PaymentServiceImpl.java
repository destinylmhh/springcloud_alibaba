package com.tb.springcloud.service.impl;

import com.tb.springcloud.dao.PaymentMapper;
import com.tb.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tb.springcloud.entity.Payment;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentMapper paymentMapper;

    @Override
    public int save(Payment payment) {
        return paymentMapper.save(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentMapper.getPaymentById(id);
    }
}
