package org.zj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zj.service.impl.PaymentFallbackService;

/**
 * @author jiezhou
 * @CalssName: PaymentHystrixService
 * @Package org.zj.service
 * @Description:
 * @date 2021/7/5/15:35
 */
@Component
//@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT")
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackService.class)//指定PaymentFallbackService类
public interface PaymentHystrixService {

    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentThread_200_Ok(@PathVariable("id") int id);

    @GetMapping("/payment/hystrix/time_out/{id}")
    public String paymentThread_500_TimeOut(@PathVariable("id") int id);





}
