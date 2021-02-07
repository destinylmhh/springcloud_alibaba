package com.tb.springcloud.service;


import org.springframework.web.bind.annotation.PathVariable;

public interface HystrixService {
    public String paymentInfo_OK(Integer id);
    public String paymentInfo_TimeOut(Integer id);
    public String paymentCircuiBreaker(@PathVariable("id")Long id);
}
