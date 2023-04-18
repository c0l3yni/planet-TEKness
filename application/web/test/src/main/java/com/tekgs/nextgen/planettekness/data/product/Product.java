package com.tekgs.nextgen.planettekness.data.product;

public class Product {
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public boolean equivalent(ProductDefinition productDefinition) {
        if(productDefinition == null) return false;
        return (this.price != null && price.equals(productDefinition.getPrice()));
    }
}
