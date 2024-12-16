package com.paravar.labs.lab3;

public class Q9_TestFish {
    public static void main(String[] args) {
        Croc c=new Croc();
        c.name="cocky";
        Fish f=new Fish();
        f.name="fishy";
        System.out.println(" before calling eat the fish name is"+"  "+f.name);
        c.eat(f);
        System.out.println(" after calling eat the fish name is"+"  "+f.name);//prints the older name itself cz f is still point to older object itself
        c.eat(null);//it compiles but in runtime gives null pointer exception
    }
}
class Fish {
    String name;
}
class Croc {
    String name;
    public void eat(Fish f)
    {
        System.out.println(" croc name is"+"  "+name+"  "+"fish name is"+"  "+f.name);
        //f=null;//it wont affects
        f=new Fish();//creating new fish object assaigning new name to it
        f.name="flippy";
        System.out.println(" after croc name is"+"  "+name+"  "+"fish name is"+"  "+f.name);
        //prints fish name as flippy
    }


}