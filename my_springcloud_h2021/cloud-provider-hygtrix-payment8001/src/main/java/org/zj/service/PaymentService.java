package org.zj.service;

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
}
