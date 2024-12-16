package com.paravar.labs.lab5;

public class Q6_TestBag {
    public static void main(String[] args) {
        Item item1 = new Item("Apple", 10);
        Item item2 = new Item("Orange", 20);
        Item item3 = new Item("Pen", 30);
        Item item4 = new Item("Pencil", 40);

        Bag bag = new Bag("American",5);
        bag.add(item1);
        bag.add(item2);
        bag.add(item3);
        bag.add(item4);
        System.out.println("Total Items cost: "+bag.getTotal());
        System.out.println(bag.searchItem("Pencil"));
        System.out.println(bag.getItemPrice("Pencil"));
        Item second = bag.getItem(2);
        System.out.println(second.name);
    }
}

class  Bag{

    String name;
    Item[] items;
    int count;

    public Bag(String name, int maxSize) {
        this.name = name;
        this.items = new Item[maxSize];
    }
    public void add(Item item){
        if (count<items.length){
            items[count++] = item;
        }else System.out.println("Bag is full");

    }
    public boolean searchItem(String name){
        for (int i = 0; i < count; i++) {
            if (items[i].name.equals(name)){
                return true;
            }
        }
        return false;
    }
    public double getItemPrice(String name){
        for (int i = 0; i < count; i++) {
            if (items[i].name.equals(name)){
                return items[i].price;
            }
        }
        return -1;
    }
    public Item getItem( int position){
        return position < count ? items[position] : null;
    }

    public double getTotal(){
        double total = 0;
        for (Item i: items)
            total+=i.price;
        return total;

    }
}
class Item{
    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

