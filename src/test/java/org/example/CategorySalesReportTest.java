package org.example;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class CategorySalesReportTest {

    @Test
    public void generate() throws IOException {
        Map<String, Integer> salesByCategory = new HashMap<>();
        salesByCategory.put("Chocolate", 50);
        salesByCategory.put("Milk", 550);
        salesByCategory.put("Butter", 150);
        salesByCategory.put("Bread", 12);
        salesByCategory.put("Cheese", 480);

        CategorySalesReport.generate(salesByCategory);

        BufferedReader r = new BufferedReader(new FileReader("TaskThreeReport.csv"));
        assertEquals("Category, Total Sales ", r.readLine());
        assertEquals("Milk, 550", r.readLine());
        assertEquals("Cheese, 480", r.readLine());
        assertEquals("Butter, 150", r.readLine());
        assertEquals("Chocolate, 50", r.readLine());
        assertEquals("Bread, 12", r.readLine());


    }
}