package edu.mum.cs544.apigateway.service;

import edu.mum.cs544.apigateway.domain.PaymentDetail;
import org.json.JSONException;

public interface PaymentService {
    public String makePayment(Double amount, String product);
    public PaymentDetail logTransaction(String transactionId, String token, String payerId) throws JSONException;
}
