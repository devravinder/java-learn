package com.paravar.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q6 {
    public static void main(String[] args) {

//        q1();
        q2();

    }

    public static void q1(){
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        for(int i=0; i<list.size(); i++){
            int j = list.remove(0);
            System.out.println("j "+j);
            i=i-1;
        }

        System.out.println(list);
    }

    public static void q2(){
        List<Integer> list = new ArrayList<>();

        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);


        Iterator<Integer> i = list.iterator();

        while (i.hasNext()){
            Integer n = i.next();
            i.remove();

//            list.remove(1); // gives ConcurrentModificationException

//            list.add(1); // gives ConcurrentModificationException
        }

    }
}
