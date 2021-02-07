package com.tb.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routers=builder.routes();

        routers.route("path_route_tb",
                r->r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routers.build();
    }

    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes=builder.routes();

        routes.route("path_route_tb_guoji",
                r->r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }
}
