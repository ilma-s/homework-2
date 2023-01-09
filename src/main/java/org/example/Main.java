package org.example;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        File customersFile = new File("customers.csv");
        Scanner customersScanner = new Scanner(customersFile);
        customersScanner.nextLine();

        File itemsFile = new File("items.csv");
        Scanner itemsScanner = new Scanner(itemsFile);
        itemsScanner.nextLine();

        File purchasesFile = new File("purchases.csv");
        Scanner purchasesScanner = new Scanner(purchasesFile);
        purchasesScanner.nextLine();

        Map<String, String> customerInfo = new HashMap<>();
        Map<Customer, Double> customerByMoneySpent = new HashMap<>();
        Map<String, Integer> salesByCategory = new HashMap<>();
        ArrayList<Item> allItems = new ArrayList<>();
        ArrayList<Customer> allCustomerHistory = new ArrayList<>();
        ArrayList<Item> currentInventory = new ArrayList<>();
        Map<String, ArrayList<String>> itemByCategory = new HashMap<>();
        Map<Item, Integer> itemsPerNumSold = new HashMap<>();

        while(customersScanner.hasNextLine()) {
            String line = customersScanner.nextLine();
            String parts[] = line.split(",");
            String name = parts[0].trim();
            String email = parts[1].trim();

            customerInfo.put(name, email); //map the customer with their email
        }

        while(itemsScanner.hasNextLine()) {
            String line = itemsScanner.nextLine();
            String parts[] = line.split(",");
            String name = parts[0].trim();
            Double price = Double.parseDouble(parts[1].trim());
            Integer quantity = Integer.parseInt(parts[2].trim());
            String category = parts[3].trim();

            Item i = new Item(name, price, quantity, category);
            allItems.add(i); //create an item and add it to the list of all items


            //key: category, value: item name - map the items by category
            if(!itemByCategory.containsKey(category)) {
                itemByCategory.put(category, new ArrayList<>());
            }
            itemByCategory.get(category).add(name);

            //map all the categories and set their initial value of sold items to 0
            if(!salesByCategory.containsKey(category)) {
                salesByCategory.put(category, 0);
            }

            //map all the items and set their initial value of sold items to 0
            if(!itemsPerNumSold.containsKey(i)) {
                itemsPerNumSold.put(i, 0);
            }
        }

        while(purchasesScanner.hasNextLine()) {
            String line = purchasesScanner.nextLine();
            String parts[] = line.split(",");
            String customerName = parts[0].trim();
            String itemName = parts[1].trim();
            Integer quantity = Integer.parseInt(parts[2].trim()); //number of items bought

            //total sales for each category
            for (Map.Entry<String, ArrayList<String>> e :itemByCategory.entrySet()) {
                if(e.getValue().contains(itemName)) {
                    if(!salesByCategory.containsKey(e.getKey())) {
                        salesByCategory.put(e.getKey(), quantity);
                    } else {
                        Integer newQuantity = salesByCategory.get(e.getKey()) + quantity;
                        salesByCategory.put(e.getKey(), newQuantity);
                    }
                }
            }

            Purchase p = null;
            Item i = null;

            //set the new quantity of the item after the purchase
            for (Item i1 : allItems) {
                if(itemName.equals(i1.getName())) {
                    i = i1;
                    i.setQuantity(i.getQuantity() - quantity);
                    p = new Purchase(i, quantity);
                    break;
                }
            }

            currentInventory.add(i);

            //set/update the number of sold items
            if(!itemsPerNumSold.containsKey(i)) {
                itemsPerNumSold.put(i, quantity);
            } else {
                Integer numSold = quantity + itemsPerNumSold.get(i);
                itemsPerNumSold.put(i, numSold);
            }

            //set/update the customers and their purchase history
            boolean found = false;
            for (Map.Entry<String, String> e : customerInfo.entrySet()) {
                if(e.getKey().equals(customerName)) {
                    for (Customer c : allCustomerHistory) {
                        if(c.getName().equals(customerName)) {
                            found = true;
                            c.purchased_items.add(p);
                        }
                    }

                    if(!found) {
                        Customer c = new Customer(customerName, e.getValue());
                        c.purchased_items.add(p);
                        allCustomerHistory.add(c);
                    }
                }
            }

        }

        //calculate the total amount of money spent per customer
        for (Customer c : allCustomerHistory) {
            double totalValue = 0;
            for (Purchase p : c.getPurchasedItems()) {
                totalValue += p.getNumOfPurchasedItems() * p.getItem().getPrice();
            }

            if(!customerByMoneySpent.containsKey(c)) {
                customerByMoneySpent.put(c, totalValue);
            }
        }

        TaskOne.generate(itemsPerNumSold);
        TaskTwo.generate(customerByMoneySpent);
        TaskThree.generate(salesByCategory);
        TaskFour.generate(allCustomerHistory);
        TaskFive.generate(allItems);

    }
}