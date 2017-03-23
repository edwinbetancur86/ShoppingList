package com.mobileappsandroid.training.shoppinglist;

/**
 * Created by Android on 3/20/2017.
 */

public class ShoppingItem {

    private String name;
    private String des;

    public ShoppingItem() {
    }

    public ShoppingItem(String name, String des) {
        this.name = name;
        this.des = des;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
