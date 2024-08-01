package com.ourproject.auctionsystem.service;

import java.util.ArrayList;
import java.util.List;
import com.ourproject.auctionsystem.pojo.Payment;

public class PaymentService implements IPaymentService {
    private List<Payment> payments = new ArrayList<>();

    @Override
    public void processPayment(Payment payment) {

    }

    @Override
    public Payment getPaymentById(int paymentId) {
        return payments.stream()
                .filter(payment -> payment.getPaymentID() == paymentId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Payment> getAllPayments() {
        return new ArrayList<>(payments);
    }

    @Override
    public void deletePayment(int paymentId) {
        payments.removeIf(payment -> payment.getPaymentID() == paymentId);
    }
}
