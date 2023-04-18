package com.tekgs.plantettekness.service.payment;

import com.tekgs.plantettekness.service.payment.data.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@PropertySource("application.properties")
public class PaymentService {

    @Value("${STRIPE_URI}")
    private String STRIPE_URI;
    @Value("${BEARER_TOKEN}")
    private String BEARER_TOKEN;

    public PaymentResponse post(Payment payment) {
        return getPaymentResponse(payment);
    }

    private PaymentResponse getPaymentResponse(Payment payment) {
        return WebClient.builder().build()
                .post()
                .uri(STRIPE_URI)
                .header("Authorization", BEARER_TOKEN)
                .body(BodyInserters.fromFormData(create(payment)))
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(PaymentResponse.class))
                .block();
    }

    private MultiValueMap<String, String> create(Payment payment) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("currency", payment.getCurrency());
        map.add("source", payment.getSource());
        map.add("amount", String.valueOf(payment.getAmount()));
        return map;
    }
}
