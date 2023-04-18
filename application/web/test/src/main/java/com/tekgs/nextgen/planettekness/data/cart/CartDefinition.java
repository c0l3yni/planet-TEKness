package com.tekgs.nextgen.planettekness.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.planettekness.data.cart.item.ItemDefinition;

import java.util.ArrayList;
import java.util.List;

public class CartDefinition {
    private Integer total;
    private final List<ItemDefinition> items = new ArrayList<>();

    public static CartDefinition getInstance() {
        return new CartDefinition();
    }

    public Integer getTotal() {
        return total;
    }

    public List<ItemDefinition> getItems() {
        return new ArrayList<>(this.items);
    }

    public CartDefinition withAmount(int amount) {
        total = amount;
        return this;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
