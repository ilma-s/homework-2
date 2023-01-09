package org.example;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class TopCustomersReportTest {

    @Test
    public void generate() throws IOException {
        Map<Customer, Double> map = new HashMap<>();
        map.put(new Customer("Alan", "alan@example.com"), 100.0);
        map.put(new Customer("Berth", "berth@example.com"), 150.0);
        map.put(new Customer("Jake", "jake@example.com"), 200.0);
        map.put(new Customer("Dave", "dave@example.com"), 300.0);
        map.put(new Customer("John", "john@example.com"), 500.0);

        TopCustomersReport.generate(map);

        BufferedReader r = new BufferedReader(new FileReader("TaskTwoReport.csv"));
        assertEquals("Customer, Money Spent ", r.readLine());
        assertEquals("Customer{John john@example.com}, 500.0", r.readLine());
        assertEquals("Customer{Dave dave@example.com}, 300.0", r.readLine());
        assertEquals("Customer{Jake jake@example.com}, 200.0", r.readLine());
        assertEquals("Customer{Berth berth@example.com}, 150.0", r.readLine());
        assertEquals("Customer{Alan alan@example.com}, 100.0", r.readLine());
    }

}