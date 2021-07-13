package org.zj.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


/**
 * @author jiezhou
 * @CalssName: GateWayConfig
 * @Package org.zj.config
 * @Description: gateway 配置
 * @date 2021/7/13/15:20
 */
@Configuration
public class GateWayConfig {
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu", new Function<PredicateSpec, Route.AsyncBuilder>() {
            @Override
            public Route.AsyncBuilder apply(PredicateSpec predicateSpec) {
                Route.AsyncBuilder builder = predicateSpec.path("/guonei").uri("http://news.baidu.com/guonei");
                return builder;
            }
        });
        return routes.build();
    }
}
