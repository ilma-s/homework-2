package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TopSellingItemsReport {

    public static void generate(Map<Item, Integer> itemsPerNumSold) throws IOException {
        FileWriter fw = new FileWriter("TaskOneReport.csv");
        fw.write("Item Name, Quantity Sold \n");

        List<Map.Entry<Item, Integer>> listSort = MapUtil.getFirstN(itemsPerNumSold, itemsPerNumSold.size()); //sort

        if(listSort.size() < 10) {
            for (Map.Entry<Item, Integer> e : listSort) {
                fw.write(e.getKey().getName() + ", " + e.getValue() + "\n");
            }
        } else {
            for (int i = 0; i < 10; i++) {
                fw.write(listSort.get(i).getKey().getName() + ", " + listSort.get(i).getValue() + "\n");
            }
        }

        fw.close();
    }
}
