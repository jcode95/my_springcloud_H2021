package org.zj.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.zj.service.PaymentService;

import java.util.logging.Logger;

/**
 * @author jiezhou
 * @CalssName: PaymentController
 * @Package org.zj.controller
 * @Description:
 * @date 2021/7/5/14:09
 */
@RestController
@Slf4j
public class PaymentHystrixController {
    Logger log = Logger.getLogger("PaymentHystrixController");

    @Autowired
    PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;


    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentThread_200_Ok(@PathVariable("id") int id){
        String s = paymentService.paymentThread_200_Ok(id);
        log.info("result-------------"+s);
        return s;
    }
    @GetMapping("/payment/hystrix/time_out/{id}")
    public String paymentThread_500_TimeOut(@PathVariable("id") int id){
        String s = paymentService.paymentThread_500_TimeOut(id);
        log.info("result-------------"+s);
        return s;
    }



}
