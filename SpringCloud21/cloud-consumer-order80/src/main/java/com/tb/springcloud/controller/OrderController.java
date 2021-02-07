package com.tb.springcloud.controller;

import com.tb.springcloud.entity.CommonResult;
import com.tb.springcloud.entity.Payment;
import com.tb.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@Slf4j
@RestController
public class OrderController {
    //public static  final String PAYMENT_URL="http://localhost:8001";
    public static  final String PAYMENT_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    RestTemplate restTemplate;

    @Resource
    private LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("create:"+payment.toString());
        return restTemplate.postForObject(PAYMENT_URL+"/payment",payment,CommonResult.class);
    }

    @GetMapping("/comsumer/payment/createentity")
    public CommonResult<Payment> create1(Payment payment){

        ResponseEntity<CommonResult> entity = restTemplate.postForEntity(PAYMENT_URL + "/payment", payment, CommonResult.class);

        if(entity.getStatusCode().is2xxSuccessful()){
            return entity.getBody();
        }else {
            return new CommonResult<>(500,"操作失败");
        }
    }

    @GetMapping("/comsumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id")Long id){
        log.info("get:"+id.toString());
        return  restTemplate.getForObject(PAYMENT_URL+"/payment/"+id,CommonResult.class);
    }

    @GetMapping("/comsumer/payment/getforEntity/{id}")
    public CommonResult<Payment> getPayment1(@PathVariable("id")Long id){
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/" + id, CommonResult.class);

        if(forEntity.getStatusCode().is2xxSuccessful()){
            return forEntity.getBody();
        }else {
            return new CommonResult<>(500,"操作失败");
        }
    }

    @
    GetMapping(value = "/comsumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size()<=0){
            return null;
        }

        ServiceInstance instance=loadBalancer.instance(instances);

        URI uri = instance.getUri();

        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        String result=restTemplate.getForObject("http://localhost:8001"+"/payment/zipkin",String.class);
        return result;
    }
}
