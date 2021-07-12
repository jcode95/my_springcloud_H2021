package org.zj.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zj.service.PaymentHystrixService;

import javax.annotation.Resource;

/**
 * @author jiezhou
 * @CalssName: PaymentHystrixController
 * @Package org.zj.controller
 * @Description:
 * @date 2021/7/5/15:37
 */
@RestController
@Slf4j
public class PaymentHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentThread_200_Ok(@PathVariable("id") int id) {
        return paymentHystrixService.paymentThread_200_Ok(id);
    }

    @GetMapping("/consumer/payment/hystrix/time_out/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",
//            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    @HystrixCommand//用全局的fallback方法
    public String paymentThread_500_TimeOut(@PathVariable("id") int id) {
        return paymentHystrixService.paymentThread_500_TimeOut(id);
    }

    //善后方法
    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    // 下面是全局fallback方法
    public String payment_Global_FallbackMethod()
    {
        return "Global异常处理信息，请稍后再试，/(ㄒoㄒ)/~~";
    }

}
