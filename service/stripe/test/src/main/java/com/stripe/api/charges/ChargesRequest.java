package com.stripe.api.charges;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.Form;
import jakarta.ws.rs.core.Response;
import org.softwareonpurpose.Environment;

public class ChargesRequest {
    private static final String BASE_URL = Environment.getInstance().getBaseUrl();
    public static final String URI = String.format("%s/charges", BASE_URL);
    public static final String USD = "usd";
    public static final String SOURCE = "tok_amex";
    private final Client client = ClientBuilder.newBuilder().build();
    private final WebTarget target = client.target(URI);
    private final Invocation.Builder request = target.request();
    private final String stripeKey = Environment.getInstance().getStripeKey();
    private final Payment payment;

    public ChargesRequest(long amount) {
        this.payment = Payment.getInstance(amount, USD, SOURCE);
    }

    public static ChargesRequest getInstance(long amount) {
        return new ChargesRequest(amount);
    }

    public ChargesResponse post() {
        request.header("Authorization", "Bearer " + stripeKey);
        Entity<Form> form = createForm();
        System.out.printf("'POST' request to %s with %s%n", URI, payment);
        Response stripeResponse = request.post(form);
        ChargesResponse chargesResponse = ChargesResponse.getInstance(stripeResponse.readEntity(String.class));
        stripeResponse.close();
        return chargesResponse;
    }

    private Entity<Form> createForm() {
        Form chargeParams = new Form();
        chargeParams.param("amount", payment.getAmount());
        chargeParams.param("currency", payment.getCurrency());
        chargeParams.param("source", payment.getSource());
        return Entity.form(chargeParams);
    }
}
