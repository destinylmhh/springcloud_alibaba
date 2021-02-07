package com.tb.springcloud.dao;


import com.tb.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface PaymentMapper {

    public int save(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
