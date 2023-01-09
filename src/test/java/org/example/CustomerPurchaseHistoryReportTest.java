package org.example;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class CustomerPurchaseHistoryReportTest {

    @Test
    public void generate() throws IOException {
        ArrayList<Customer> allCustomerHistory = new ArrayList<>();

        Customer c1 = new Customer("John", "john@example.com");
        c1.addPurchase(new Purchase(new Item("Milk", 2.5, 15, "Food"), 1));
        c1.addPurchase(new Purchase(new Item("Cheese", 3.0, 8, "Food"), 5));
        allCustomerHistory.add(c1);

        Customer c2 = new Customer("Jane", "jane@example.com");
        c2.addPurchase(new Purchase(new Item("Soup", 1.5, 10, "Food"), 2));
        c2.addPurchase(new Purchase(new Item("Bread", 3.5, 19, "Food"), 8));
        allCustomerHistory.add(c2);

        CustomerPurchaseHistoryReport.generate(allCustomerHistory);

        BufferedReader reader = new BufferedReader(new FileReader("TaskFourReport.csv"));

        assertEquals("Customer, Purchase History ", reader.readLine());
        assertEquals("Customer: John Purchase history: Milk: 2.5 Cheese: 15.0 ", reader.readLine());
        assertEquals("Customer: Jane Purchase history: Soup: 3.0 Bread: 28.0 ", reader.readLine());

    }
}