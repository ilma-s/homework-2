package org.example;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;


public class TopSellingItemsReportTest {

    @Test
    public void generate() throws IOException {
        Map<Item, Integer> itemsPerNumSold = new HashMap<>();
        itemsPerNumSold.put(new Item("Milk", 2.5, 15, "Food"), 12);
        itemsPerNumSold.put(new Item("Butter", 6.0, 15, "Food"), 5);
        itemsPerNumSold.put(new Item("Egg", 5.0, 65, "Food"), 13);
        itemsPerNumSold.put(new Item("Cheese", 3.0, 54, "Food"), 50);
        itemsPerNumSold.put(new Item("Chocolate", 2.0, 47, "Food"), 25);

        TopSellingItemsReport.generate(itemsPerNumSold);

        BufferedReader r = new BufferedReader(new FileReader("TaskOneReport.csv"));
        assertEquals("Item Name, Quantity Sold ", r.readLine());
        assertEquals("Cheese, 50", r.readLine());
        assertEquals("Chocolate, 25", r.readLine());
        assertEquals("Egg, 13", r.readLine());
        assertEquals("Milk, 12", r.readLine());
        assertEquals("Butter, 5", r.readLine());


        r.close();
    }
}