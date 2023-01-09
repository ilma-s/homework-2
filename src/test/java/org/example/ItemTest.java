package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void testConstructorAndGetters() {
        String name = "Bread";
        Double price = 0.0;
        Integer quantity = 15;
        String category = "Food";

        Item i = new Item(name, price, quantity, category);
        assertEquals(name, i.getName());
        assertEquals(price, i.getPrice());
        assertEquals(quantity, i.getQuantity());
        assertEquals(category, i.getCategory());
    }

    @Test
    public void testToString() {
        Item i = new Item("Bread", 2.5, 15, "Food");
        assertEquals("Item: {name: " + i.getName() + " price: " + i.getPrice() + " quantity: " + i.getQuantity() + " category: " + i.getCategory() + '}',
                i.toString());
    }

    @Test
    public void setQuantity() {
        Item i = new Item("Bread", 2.5, 15, "Food");

        Integer newQuantity = 8;
        i.setQuantity(newQuantity);

        assertEquals(newQuantity, i.getQuantity());
    }


}