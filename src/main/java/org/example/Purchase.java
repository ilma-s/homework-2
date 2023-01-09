package org.example;

public class Purchase {
    private final Item purchased_item;
    private final Integer number_of_purchased_items;

    public Purchase(Item purchased_item, Integer number_of_purchased_items) {
        this.purchased_item = purchased_item;
        this.number_of_purchased_items = number_of_purchased_items;
    }

    Item getItem() {
        return this.purchased_item;
    }

    Integer getNumOfPurchasedItems() {
        return this.number_of_purchased_items;
    }


    @Override
    public String toString() {
        return "Purchase {purchased item: " + purchased_item + " number of purchased items: " + number_of_purchased_items + "}";
    }
}
