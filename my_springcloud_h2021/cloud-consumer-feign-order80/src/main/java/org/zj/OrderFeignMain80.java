package org.zj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jiezhou
 * @CalssName: OrderFeignMain80
 * @Package org.zj
 * @Description: feign 来做负载均衡
 * @date 2021/7/3/20:33
 */
@EnableFeignClients//开启feign功能
@SpringBootApplication
public class OrderFeignMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain80.class, args);
    }
}
