package com.tb.springcloud.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.tb.springcloud.entity.Payment;

@Mapper
public interface PaymentMapper {

    public int save(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
