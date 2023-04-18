package com.tekgs.nextgen.planettekness.data.cart;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tekgs.nextgen.planettekness.data.cart.PTCart;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PTCartRepository {
    private static final String PATH_TO_CART_DATA = "../source/src/data/cart.json";
    private List<PTCart> carts = new ArrayList<>();

    public static PTCartRepository getInstance() {
        return new PTCartRepository();
    }

    private void getLatestCartData(){
        try(Reader reader = Files.newBufferedReader(Paths.get(PATH_TO_CART_DATA))) {
            carts = new Gson().fromJson(reader, new TypeToken<List<PTCart>>() {
            }.getType());

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public PTCart query(CartDefinition cartDefinition) {
        getLatestCartData();
        if (carts == null) return null;
        for (PTCart cart : carts) {
            if (cart.equivalent(cartDefinition)) return cart;
        }
        return null;
    }
}
