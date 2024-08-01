package com.ourproject.auctionsystem.service;

import java.util.List;
import com.ourproject.auctionsystem.pojo.Payment;

public interface IPaymentService {
    void processPayment(Payment payment);
    Payment getPaymentById(int paymentId);
    List<Payment> getAllPayments();
    void deletePayment(int paymentId);
}