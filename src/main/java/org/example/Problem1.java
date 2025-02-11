

package org.example;

import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    protected String name ;
    protected double price ;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getItemDetails() ;

}
class Electronics extends WarehouseItem {
    private String brand;
    public Electronics(String name, double price, String brand){
        super(name, price);
        this.brand = brand;
    }

    @Override
    public String getItemDetails() {
        return "\nItem Name: " + name + "\nItem Brand: " + brand + "\nItem Price: " + price ;
    }
}
class Groceries extends WarehouseItem {
    private String expiryDate ;

    public Groceries(String name, double price, String expiryDate){
        super(name, price);
        this.expiryDate = expiryDate;
    }

    @Override
    public String getItemDetails() {
        return "\nItem Name: " + name + "\nExpiry Date: " + expiryDate + "\nItem Price: " + price;
    }
}
class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material){
        super(name, price);
        this.material = material;
    }

    @Override
    public String getItemDetails() {
        return "\nItem Name: " + name + "\nType of Material: " + material + "\nItem Price: " + price;
    }
}
class Storage <T extends WarehouseItem> {
    private List <T> items ;

    public Storage (){
        items = new ArrayList<>();
    }

    //Method to add items
    public void addItem(T item){
        items.add(item);
    }

    //Method to remove items
    public void removeItem(T item) {
        items.remove(item);
    }

    //Method to get item
    public List<T> getItems(){
        return items;
    }
}
class WarehouseUtil {
    public static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item.getItemDetails());
        }
    }
}
public class Problem1 {
    public static void main(String[] args) {

        //Electronics Item Storage class
        Storage<Electronics> electronicItems = new Storage<>();
        electronicItems.addItem(new Electronics("Laptop", 52000, "Dell"));
        electronicItems.addItem(new Electronics("Smartphone", 18000, "Samsung"));

        //Groceries Item Storage class
        Storage<Groceries> groceryItems = new Storage<>();
        groceryItems.addItem(new Groceries("Bread", 45, "5 days from the date of manufacturing"));
        groceryItems.addItem(new Groceries("Milk", 66, "2 days from the date of manufacturing"));

        //Furniture Item Storage class
        Storage<Furniture> furnitureItems = new Storage<>();
        furnitureItems.addItem(new Furniture("Sofa Set", 15000, "Sandal Wood"));
        furnitureItems.addItem(new Furniture("Bed", 40000, "Red Wood"));

        // Display all stored items
        System.out.println("Electronics Storage:");
        WarehouseUtil.displayItems(electronicItems.getItems());

        System.out.println("\nGroceries Storage:");
        WarehouseUtil.displayItems(groceryItems.getItems());

        System.out.println("\nFurniture Storage:");
        WarehouseUtil.displayItems(furnitureItems.getItems());

    }
}