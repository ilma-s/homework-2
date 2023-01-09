package org.example;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;


public class InventoryReportTest {

    @Test
    public void generate() throws IOException {
        ArrayList<Item> allItems = new ArrayList<>();
        allItems.add(new Item("Milk", 2.5, 15, "Food"));
        allItems.add(new Item("Bread", 2.0, 19, "Food"));
        allItems.add(new Item("Egg", 6.5, 105, "Food"));
        allItems.add(new Item("Chocolate", 4.5, 54, "Food"));
        allItems.add(new Item("Banana", 3.0, 18, "Food"));

        InventoryReport.generate(allItems);

        BufferedReader reader = new BufferedReader(new FileReader("TaskFiveReport.csv"));
        assertEquals("Item Name, Quantity " , reader.readLine());
        assertEquals("Egg, 105" , reader.readLine());
        assertEquals("Chocolate, 54" , reader.readLine());
        assertEquals("Bread, 19" , reader.readLine());
        assertEquals("Banana, 18" , reader.readLine());
        assertEquals("Milk, 15" , reader.readLine());
    }
}