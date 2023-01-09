package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class PurchaseTest {

    @Test
    public void testConstructorAndGetters() {
        Item i = new Item("Egg", 6.0, 15, "Food");
        Integer quantity = 7;
        Purchase p = new Purchase(i, quantity);

        assertEquals(i, p.getItem());
        assertEquals(quantity, p.getNumOfPurchasedItems());
    }

    @Test
    public void testToString() {
        Item i = new Item("Egg", 6.0, 15, "Food");
        Integer quantity = 7;
        Purchase p = new Purchase(i, quantity);

        assertEquals("Purchase {purchased item: Item: {name: Egg price: 6.0 quantity: 15 category: Food} number of purchased items: 7}",
                p.toString());
    }
}