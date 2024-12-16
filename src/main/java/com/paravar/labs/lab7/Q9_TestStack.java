package com.paravar.labs.lab7;

public class Q9_TestStack {
    public static void main(String[] args) {
        Stack stack = new ArrayStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.printElements();
        System.out.println("Popped: "+stack.pop());
        System.out.println("Popped: "+stack.pop());
        stack.printElements();
    }
}
interface Stack {

    public void push(int i);
    public int pop();
    public int peek();
    public void printElements();
}

class ArrayStack implements Stack{

    final int[] elements;
    private int count = 0;
    ArrayStack(int size){
        elements = new int[size];
    }


    @Override
    public void push(int i) {
            if(count<elements.length){
                elements[count++] = i;
                System.out.println(" Pushed: "+i);
            }else System.out.println("Stack is full");
    }

    @Override
    public int pop() {
        int element = elements[count-1];
        elements[count-1] = 0;// clear
        count--;
        System.out.println("Popped: "+element);
        return element;
    }

    @Override
    public int peek() {
        System.out.println("returning top element"+elements[count-1]);
        return elements[count-1];
    }

    @Override
    public void printElements() {
        System.out.println("Printing elements");
        for (int i = 0; i < count; i++) {
            System.out.println(elements[i]);
        }
    }
}