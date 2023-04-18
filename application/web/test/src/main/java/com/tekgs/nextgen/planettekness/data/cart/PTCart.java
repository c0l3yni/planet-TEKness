package com.tekgs.nextgen.planettekness.data.cart;

import com.google.gson.Gson;
import com.tekgs.nextgen.planettekness.data.cart.item.ItemDefinition;
import com.tekgs.nextgen.planettekness.data.cart.item.PTItem;

import java.util.ArrayList;
import java.util.List;

public class PTCart {
    private final String id;
    private final List<PTItem> items = new ArrayList<>();

    public PTCart(String id) {
        this.id = id;
    }

    public boolean equivalent(CartDefinition cartDefinition) {
        if (cartDefinition == null) return false;
        boolean isEquivalent = cartDefinition.getTotal() == null || this.getTotal().equals(cartDefinition.getTotal());
        isEquivalent &= itemsAreEquivalent(cartDefinition.getItems());
        return isEquivalent;
    }

    private boolean itemsAreEquivalent(List<ItemDefinition> comparatorItems) {
        List<PTItem> thisItems = new ArrayList<>(items);
        for(ItemDefinition comparatorItem : comparatorItems){
            PTItem itemFound = null;
            for(PTItem candidate : thisItems){
                if(candidate.equivalent(comparatorItem)){
                    itemFound = candidate;
                    break;
                }
            }
            if(itemFound == null){
                return false;
            }
        }
        return true;
    }

    public Integer getTotal() {
        int total = 0;
        for (PTItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public boolean isEmpty(){
       return items.isEmpty();
    }

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
