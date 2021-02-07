package com.tb.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;


@Slf4j
@RestController
public class FlowLimitController {

    @GetMapping("/testA")
    public String testA(){
//        try {
//            TimeUnit.MILLISECONDS.sleep(800);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return "test --------------A";
    }


    @GetMapping("/testB")
    public String testB(){
        return "test --------------B";
    }

    @GetMapping("/testD")
    public String testD(){
        //RT
//        try {
//            TimeUnit.MILLISECONDS.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        log.info("testD ceshi RT ");

        //异常比例  请求次数 5次/秒 && 程序出错
       // int result =10/0;

        //异常数


        return "test --------------D";
    }

    @GetMapping("/testE")
    public String testE(){

        int age =10/0;

        return "******************test E";
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false)String p1,
                             @RequestParam(value = "p2",required = false)String p2){


        return "******************test testHotKey";
    }

    public String deal_testHotKey(String p1, String p2, BlockException ex){
        return "-----------------deal_testHotKey";
    }
}
