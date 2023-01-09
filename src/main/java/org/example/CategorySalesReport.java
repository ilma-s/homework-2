package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CategorySalesReport {

    public static void generate(Map<String, Integer> salesByCategory) throws IOException {
        FileWriter fw = new FileWriter("TaskThreeReport.csv");
        fw.write("Category, Total Sales \n");

        salesByCategory.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).forEach(entry -> {
            try {
                fw.write(entry.getKey() + ", " + entry.getValue() + "\n");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });

        fw.close();
    }
}
