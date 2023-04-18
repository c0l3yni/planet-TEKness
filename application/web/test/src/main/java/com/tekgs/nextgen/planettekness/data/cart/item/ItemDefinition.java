package com.tekgs.nextgen.planettekness.data.cart.item;

import com.tekgs.nextgen.planettekness.data.product.ProductDefinition;

public class ItemDefinition {
    private ProductDefinition productDefinition;
    private Integer quantity;

    public ProductDefinition getProduct() {
        return productDefinition;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
