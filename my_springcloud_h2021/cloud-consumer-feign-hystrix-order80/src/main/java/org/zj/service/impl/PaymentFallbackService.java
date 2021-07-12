package org.zj.service.impl;

import org.springframework.stereotype.Component;
import org.zj.service.PaymentHystrixService;

/**
 * @author jiezhou
 * @CalssName: PaymentFallbackService
 * @Package org.zj.service.impl
 * @Description:
 * @date 2021/7/9/20:17
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentThread_200_Ok(int id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentThread_500_TimeOut(int id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
