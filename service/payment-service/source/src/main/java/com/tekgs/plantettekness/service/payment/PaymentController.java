package com.tekgs.plantettekness.service.payment;

import com.tekgs.plantettekness.service.payment.data.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping("/purchase")
    public PaymentResponse post(@RequestBody Payment payment) {
        return paymentService.post(payment);
    }
}
