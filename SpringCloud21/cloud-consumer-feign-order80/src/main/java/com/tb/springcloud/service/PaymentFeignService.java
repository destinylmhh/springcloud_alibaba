package com.tb.springcloud.service;

import com.tb.springcloud.entity.CommonResult;
import com.tb.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id")Long id);

    @PostMapping("/payment")
    public CommonResult savePayment(@RequestBody Payment payment);

    @GetMapping(value = "/payment/feign/timeout")
    public String getPaymentFeignTimeout();
}
