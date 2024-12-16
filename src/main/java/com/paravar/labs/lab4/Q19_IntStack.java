package com.paravar.labs.lab4;

public class Q19_IntStack {
    public static void main(String[] args) {
        IntStack stack = new IntStack(10);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        stack.push(80);
        stack.push(90);
        stack.push(100);
        stack.print();
        System.out.println("Popped: "+stack.pop());
        System.out.println("Popped: "+stack.pop());
        stack.print();
    }
}
class IntStack{
    private int maxSize;
    private int[] stackArray;
    private int position;

    public IntStack(int maxSize) {
        this.maxSize = maxSize;
        this.stackArray = new int[maxSize];

    }
    public void push(int j){
        if(position < maxSize)
        stackArray[position++] = j;
        else System.out.println("Stack is full");
    }
    public int pop(){
        if(position > 0){
            int value = stackArray[position-1];
            stackArray[position-1] = 0; // clean up
            position--;
            return value;
        }
        else
            return -1;
    }

    public void print(){
        for(int i = 0; i < position; i++){
            System.out.println(stackArray[i]);
        }
    }
}
