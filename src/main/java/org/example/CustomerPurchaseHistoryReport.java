package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerPurchaseHistoryReport {

    public static void generate(ArrayList<Customer> allCustomerHistory) throws IOException {
        FileWriter fw = new FileWriter("TaskFourReport.csv");
        fw.write("Customer, Purchase History \n");

        for (Customer c : allCustomerHistory) {
            fw.write("Customer: " + c.getName() + " Purchase history: ");
            for (Purchase p : c.getPurchasedItems()) {
                fw.write(p.getItem().getName() + ": " + p.getNumOfPurchasedItems() * p.getItem().getPrice() + " ");
            }
            fw.write("\n");
       }

        fw.close();
    }
}
