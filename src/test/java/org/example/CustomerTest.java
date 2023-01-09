package org.example;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class CustomerTest {

    @Test
    public void testConstructorAndGetters() {
        String name = "John";
        String email = "john@example.com";
        Customer c = new Customer(name, email);
        assertEquals(name, c.getName());
        assertEquals(email, c.getEmail());
    }

    @Test
    public void testAddPurchase() {
        Customer c = new Customer("John", "john@example.com");
        Item i = new Item("Egg", 6.0, 15, "Food");
        Purchase p = new Purchase(i, 10);
        c.addPurchase(p);

        assertEquals(1, c.getPurchasedItems().size());
        assertEquals(p, c.getPurchasedItems().get(0));
    }

    @Test
    public void testGetPurchasedItems() {
        Customer c = new Customer("John", "john@example.com");
        Item i = new Item("Egg", 6.0, 15, "Food");
        Purchase p = new Purchase(i, 10);
        Item i1 = new Item("Bread", 2.0, 35, "Food");
        Purchase p1 = new Purchase(i1, 3);
        c.addPurchase(p);
        c.addPurchase(p1);

        assertEquals(2, c.getPurchasedItems().size());
        assertEquals(p, c.getPurchasedItems().get(0));
    }

    @Test
    public void testTestToString() {
        Customer c = new Customer("John", "john@example.com");
        assertEquals("Customer{John john@example.com}", c.toString());
    }
}