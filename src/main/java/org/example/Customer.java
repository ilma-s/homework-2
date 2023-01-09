package org.example;

import java.util.ArrayList;

public class Customer {
    public String name;
    private final String email;
    public ArrayList<Purchase> purchased_items;

    public Customer(String name, String email) {
        this.name = name;
        this.email = email;
        this.purchased_items = new ArrayList<>();
    }

    String getName() {
        return this.name;
    }
    String getEmail() {
        return this.email;
    }

    ArrayList<Purchase> getPurchasedItems() {
        return this.purchased_items;
    }
    public void addPurchase(Purchase p) {
        this.purchased_items.add(p);
    }

    @Override
    public String toString() {
        return "Customer{" + name + " " + email + "}";
    }
}
