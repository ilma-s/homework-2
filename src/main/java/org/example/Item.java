package org.example;

public class Item implements Comparable<Item>{
    private final String name;
    private final Double price;
    public Integer quantity;
    private final String category;

    public Item(String name, Double price, Integer quantity, String category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    String getName() {
        return this.name;
    }

    Double getPrice() {
        return this.price;
    }

    Integer getQuantity() {
        return this.quantity;
    }

    String getCategory() {
        return this.category;
    }

    @Override
    public String toString() {
        return "Item: {name: " + name + " price: " + price + " quantity: " + quantity + " category: " + category + '}';
    }


    public void setQuantity(int i) {
        this.quantity = i;
    }

    @Override
    public int compareTo(Item o) {
        return o.quantity.compareTo(this.quantity);
    }
}
