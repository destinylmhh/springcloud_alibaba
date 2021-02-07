package com.tb.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan({"com.tb.springcloud.dao"})
public class MyBatisConfig {
}
