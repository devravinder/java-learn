package com.paravar.labs.lab7;

public class Q8_TestDuck {
    public static void main(String[] args) {

        Chota chota = new Chota(Size.SMALL);
        chota.swim();
        Bada bada = new Bada(Size.MEDIUM);
        bada.swim();
        Biggest biggest = new Biggest(Size.BIG);
        biggest.swim();
    }
}

enum Size{
    SMALL(5), MEDIUM(10), BIG(15);
    final int size;
    Size(int size){
        this.size = size;
    }
}
abstract class Duck{
    final Size size;
    Duck(Size size){
        this.size = size;
    }
    public void swim(){
        switch (size){
            case SMALL:
                System.out.println("Swming slowly");
                break;
            case MEDIUM:
                System.out.println("Swimming fast");
                break;
            case BIG:
                System.out.println("Swimming very fast");
                break;
        }
    }
}

class Chota extends Duck{
    Chota(Size size){
        super(size);
    }
}

class Bada extends Duck{
    Bada(Size size){
        super(size);
    }
}
class Biggest extends Duck{
    Biggest(Size size){
        super(size);
    }
}
