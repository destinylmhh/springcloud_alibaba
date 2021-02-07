package com.tb.springcloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tb.springcloud.entity.CommonResult;

public class CustomerBlcokHandler {

    public static CommonResult handlerException(BlockException ex){
        return new CommonResult(444,"按用户自定义的，global handlerException： " +ex.getClass().getCanonicalName()+"\t 服务不可用");
    }

    public static CommonResult handlerException2(BlockException ex){
        return new CommonResult(444,"按用户自定义的，global2 handlerException： " +ex.getClass().getCanonicalName()+"\t 服务不可用");
    }
}
