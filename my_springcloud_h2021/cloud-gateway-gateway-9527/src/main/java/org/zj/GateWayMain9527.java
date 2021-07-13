package org.zj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author jiezhou
 * @CalssName: GateWayMain9527
 * @Package org.zj
 * @Description: getway
 * @date 2021/7/13/14:23
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {

    public static void main(String[] args) {

        SpringApplication.run(GateWayMain9527.class, args);
    }
}
