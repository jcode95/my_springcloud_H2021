package org.zj.service;

import org.apache.ibatis.annotations.Param;
import org.zj.entity.Payment;

/**
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}

