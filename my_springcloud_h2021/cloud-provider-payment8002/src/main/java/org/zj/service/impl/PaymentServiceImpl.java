package org.zj.service.impl;

import org.springframework.stereotype.Service;
import org.zj.dao.PaymentDao;
import org.zj.entity.Payment;
import org.zj.service.PaymentService;

import javax.annotation.Resource;

/**
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
