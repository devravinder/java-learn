package com.paravar.labs.lab6;

public class Q4_TestBag {
    public static void main(String[] args) {

        Bag bag = new Bag("Bag", 5);
        Item pen = new Pen("Pen", 10);
        Item notebook = new NoteBook("Notebook", 100);
        bag.add(pen);
        bag.add(notebook);
        System.out.println(bag.getTotal());
        System.out.println(bag.searchItem("Pen"));
        System.out.println(bag.getItemPrice("Notebook"));
        Item second = bag.getItem(1);
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
    public Item getItem(int position){
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

class Pen extends Item{

    public Pen(String name, double price) {
        super(name, price);
    }
}

class NoteBook extends Item{
    public NoteBook(String name, double price) {
        super(name, price);
    }
}