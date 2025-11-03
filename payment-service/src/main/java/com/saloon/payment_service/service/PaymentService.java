package com.saloon.payment_service.service;

import com.razorpay.PaymentLink;
import com.razorpay.RazorpayException;
import com.saloon.payment_service.domain.PaymentMethod;
import com.saloon.payment_service.dto.request.BookingDTO;
import com.saloon.payment_service.dto.request.UserDTO;
import com.saloon.payment_service.dto.response.PaymentLinkResponse;
import com.saloon.payment_service.model.PaymentOrder;
import com.stripe.exception.StripeException;

public interface PaymentService {

    PaymentLinkResponse createOrder(UserDTO user, BookingDTO booking, PaymentMethod paymentMethod) throws StripeException, RazorpayException;

    PaymentOrder getPaymentOrderById(Integer id) throws Exception;

    PaymentOrder getPaymentOrderByPaymentId(String paymentId);

    PaymentLink createRazorpayPaymentLink(UserDTO user, Long amount, Integer orderId) throws RazorpayException;

    String createStripePaymentLink(UserDTO user, Long amount, Integer orderId) throws StripeException;

    Boolean proceedPayment(PaymentOrder paymentOrder, String paymentId, String paymentLinkId) throws RazorpayException;
}
