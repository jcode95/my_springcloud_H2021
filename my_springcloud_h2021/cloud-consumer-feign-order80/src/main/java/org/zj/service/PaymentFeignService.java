package org.zj.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.zj.comment.CommonResult;
import org.zj.entity.Payment;

/**
 * @author jiezhou
 * @InterfaceName: PaymentFeignService
 * @Package org.zj.service
 * @Description:
 * @date 2021/7/3/20:35
 */
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping(value = "/payment/get/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

}
