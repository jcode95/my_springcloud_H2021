package org.zj.controller;

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
    public String paymentThread_500_TimeOut(@PathVariable("id") int id) {
        return paymentHystrixService.paymentThread_500_TimeOut(id);
    }

}
