package com.tekgs.nextgen.planettekness.data.cart.item;

import com.tekgs.nextgen.planettekness.data.product.Product;

public class PTItem {
    private final Product product;
    private final Integer quantity;

    public PTItem() {
        this.product = null;
        this.quantity = null;
    }

    public Integer getSubtotal() {
        return product != null && quantity != null ? product.getPrice() * quantity : 0;
    }

    private Integer getQuantity() {
        return quantity;
    }

    private Product getProduct() {
        return product;
    }

    public boolean equivalent(ItemDefinition comparatorItem) {
        if(comparatorItem == null) return false;
        boolean isEquivalent = comparatorItem.getProduct() == null || (this.product != null && this.product.equivalent(comparatorItem.getProduct()));
        isEquivalent &= comparatorItem.getQuantity() == null || (this.quantity != null && this.quantity.equals(comparatorItem.getQuantity()));
        return isEquivalent;
    }
}
