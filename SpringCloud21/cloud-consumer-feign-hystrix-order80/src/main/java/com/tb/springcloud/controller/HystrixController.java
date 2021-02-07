package com.tb.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tb.springcloud.service.HystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Slf4j
@RestController
@DefaultProperties(defaultFallback = "payment_Global_fallback")
public class HystrixController {

    @Resource
    HystrixService service;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id)
    {
        String result = service.paymentInfo_OK(id);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")
//    })
    @HystrixCommand
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id)
    {
       // int age = 10/0;
        String result = service.paymentInfo_TimeOut(id);
        return result;
    }

    public String paymentInfo_TimeOutHandler(@PathVariable("id") Integer id){
        return "I'm order 80 ,对方系统繁忙请10秒钟后再试或者自己运行异常！";
    }

    public String payment_Global_fallback(){
        return "Global ,对方系统繁忙请10秒钟后再试或者自己运行异常！";
    }


}
