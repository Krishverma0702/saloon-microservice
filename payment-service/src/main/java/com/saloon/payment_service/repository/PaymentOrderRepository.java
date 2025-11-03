package com.saloon.payment_service.repository;

import com.saloon.payment_service.model.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentOrderRepository extends JpaRepository<PaymentOrder, Integer> {

    PaymentOrder findByPaymentLinkId(String paymentLinkId);
}
