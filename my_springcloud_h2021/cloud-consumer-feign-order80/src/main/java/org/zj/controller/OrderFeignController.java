package org.zj.controller;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zj.comment.CommonResult;
import org.zj.entity.Payment;
import org.zj.service.PaymentFeignService;

import javax.annotation.Resource;

/**
 * @author jiezhou
 * @CalssName: OrferFeignController
 * @Package org.zj.controller
 * @Description:
 * @date 2021/7/3/20:43
 */
@RestController
@Slf4j
public class OrderFeignController {


    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
       return paymentFeignService.getPaymentById(id);
    }

    /**
     * 超时测试
     */
    @GetMapping(value = "/consumer/payment/feign/timeout")
    public String paymentFeignTimeout(){
        return paymentFeignService.paymentFeignTimeout();
    }

}
