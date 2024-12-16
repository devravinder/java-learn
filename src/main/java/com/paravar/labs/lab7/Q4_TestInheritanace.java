package com.paravar.labs.lab7;

public class Q4_TestInheritanace {
    public static void main(String[] args) {
        A a = new B();
        System.out.println(a.name); // variables based on ref
        a.print(); // instance methods based on object,...within the instance method, the method refers to the object state
        a.display(); // static methods refer to the class state ( i.r reference class )
                    // static methods can't be overridden

        B b = new B();
        System.out.println(b.name); // variables based on ref
        b.print();
        b.display();

    }
}

class A {
    String name="A";
    static int count=10;
    A() {
        System.out.println(" in A constructor");
    }

    void print(){
        System.out.println("in A "+name);
    }

    static void display(){
        System.out.println("in A "+count);
    }

}
class B extends A {
    String name="B";
    static int count=20;
    B(){
        System.out.println(" in B constructor");
    }

    @Override
    void print() {
        System.out.println("in B "+name);
    }

    static void display() {
        System.out.println("in B "+count);
    }
}
