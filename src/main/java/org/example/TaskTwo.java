package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

//        System.out.println("Task 2: Customers Spent");
//        for (Map.Entry<java.Customer, Double> e : customerByMoneySpent.entrySet()) {
//            System.out.println("customer: " + e.getKey().getName() + " spent: " + e.getValue());
//        }

public class TaskTwo {
    public static void generate(Map<Customer, Double> customerByMoneySpent) throws IOException {
        FileWriter fw = new FileWriter("TaskTwoReport.csv");
        List<Map.Entry<Customer, Double>> listSort = MapUtil.getFirstN(customerByMoneySpent, customerByMoneySpent.size()); //sort

        fw.write("Customer, Money Spent \n");

        if(listSort.size() < 10) {
            for (Map.Entry<Customer, Double> customerDoubleEntry : listSort) {
                fw.write(customerDoubleEntry.getKey() + ", " + customerDoubleEntry.getValue() + "\n");
            }
        } else {
            for(int i = 0; i < 10; i++) {
                fw.write(listSort.get(i).getKey() + ", " + listSort.get(i).getValue() + "\n");
            }
        }

        fw.close();
    }
}
