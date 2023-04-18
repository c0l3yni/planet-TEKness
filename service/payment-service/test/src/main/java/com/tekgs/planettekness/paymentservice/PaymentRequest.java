package com.tekgs.planettekness.paymentservice;

import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

public class PaymentRequest {

    private final Payment payment;
    private final ResteasyWebTarget target;

    public PaymentRequest(Payment payment) {
        ResteasyClient client = (ResteasyClient) ClientBuilder.newBuilder().build();
        this.payment = payment;
        this.target = client.target("http://localhost:8080/purchase");
    }

    public static PaymentRequest getInstance(Payment payment) {
        return new PaymentRequest(payment);
    }

    public PaymentResponse post() {
        Entity<Payment> body = Entity.json(payment);
        PaymentResponse paymentResponse;
        try (Response response = target.request().post(body)) {
            paymentResponse = PaymentResponse.getInstance(response.readEntity(String.class), response.getStatus());
        }
        return paymentResponse;
    }
}
