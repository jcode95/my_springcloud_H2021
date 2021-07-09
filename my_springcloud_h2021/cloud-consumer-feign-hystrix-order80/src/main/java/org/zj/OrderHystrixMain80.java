package org.zj;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author jiezhou
 * @CalssName: OrderHystrixMain80
 * @Package org.zj
 * @Description:
 * @date 2021/7/5/15:34
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix//开启降级服务激活注解
public class OrderHystrixMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderHystrixMain80.class, args);

    }
}
