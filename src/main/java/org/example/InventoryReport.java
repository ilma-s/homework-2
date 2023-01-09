package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class InventoryReport {

    public static void generate(ArrayList<Item> allItems) throws IOException {
        FileWriter fw = new FileWriter("TaskFiveReport.csv");
        fw.write("Item Name, Quantity \n");

        Collections.sort(allItems);
        for (Item i : allItems) {
            fw.write(i.getName() + ", " + i.getQuantity() + "\n");
        }

        fw.close();
    }
}
