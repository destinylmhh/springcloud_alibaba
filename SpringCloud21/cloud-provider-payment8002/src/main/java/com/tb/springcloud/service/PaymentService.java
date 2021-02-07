package com.tb.springcloud.service;

import org.apache.ibatis.annotations.Param;
import com.tb.springcloud.entity.Payment;

public interface PaymentService {
    public int save(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
