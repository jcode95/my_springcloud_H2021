package org.zj.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

/**
 * @author jiezhou
 * @CalssName: PaymentService
 * @Package org.zj.service
 * @Description:
 * @date 2021/7/5/11:25
 */
@Service
public class PaymentService {

    public String paymentThread_200_Ok(Integer id) {
        String var = " Thread pool name :" + Thread.currentThread().getName() + "paymentThread_200_Ok id :" + id;
        return var;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandler"/*指定善后方法名*/,
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
    public String paymentThread_500_TimeOut(Integer id) {
        int time = 3;
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String var = " Thread pool name :" + Thread.currentThread().getName() + "paymentThread_500_TimeOut id :" + id + "耗时（s）" + time;
        return var;
    }


    //用来善后的方法
    public String paymentInfo_TimeOutHandler(Integer id) {
        return "线程池:  " + Thread.currentThread().getName() + "  8001系统繁忙或者运行报错，请稍后再试,id:  " + id + "\t" + "o(╥﹏╥)o";
    }

    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),// 是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "20"),// 请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), // 时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")// 失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id < 0) {
            throw new RuntimeException("******id 不能负数");
        }
        String serialNumber = UUID.randomUUID().toString();

        return Thread.currentThread().getName()+"\t"+"调用成功，流水号: " + serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id) {
        return "id 不能负数，请稍后再试，/(ㄒoㄒ)/~~   id: " +id;
    }
}
