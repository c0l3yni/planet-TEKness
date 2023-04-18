package com.tekgs.nextgen.planettekness.data.cart;

public class PTCartProvider {

    private final PTCartRepository cartRepository = PTCartRepository.getInstance();

    public static PTCartProvider getInstance() {
        return new PTCartProvider();
    }

    public PTCart get(CartDefinition cartDefinition) {
        return cartRepository.query(cartDefinition);
    }

}
