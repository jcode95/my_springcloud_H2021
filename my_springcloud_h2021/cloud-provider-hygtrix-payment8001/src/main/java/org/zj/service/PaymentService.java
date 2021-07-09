package org.zj.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

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
}
