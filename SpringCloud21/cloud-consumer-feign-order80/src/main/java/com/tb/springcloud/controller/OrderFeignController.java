package com.tb.springcloud.controller;

import com.tb.springcloud.entity.CommonResult;
import com.tb.springcloud.entity.Payment;
import com.tb.springcloud.service.PaymentFeignService;
import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Log
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService service;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id){
         return service.getPaymentById(id);
    }

    @PostMapping("/consumer/payment")
    public CommonResult savePayment(Payment payment){
        return service.savePayment(payment);
    }

    @GetMapping(value = "/comsumer/payment/feign/timeout")
    public String getPaymentFeignTimeout(){
        return service.getPaymentFeignTimeout();
    }
}
