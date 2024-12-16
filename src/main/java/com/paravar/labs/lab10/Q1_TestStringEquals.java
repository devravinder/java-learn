package com.paravar.labs.lab10;

import java.util.ArrayList;
import java.util.Collection;

public class Q1_TestStringEquals {
    public static void main(String[] args) {

        String str1 = new String( "abc");
        String str2 = new String("abc");

        String str3 = new String("efg");
        String str4 = "efg";

        System.out.println(str1==str2);

        System.out.println(str1.equals(str2));

        Collection col = new ArrayList();
        col.add(str1);
        col.add(str2);
        
        col.add(str3);
        col.add(str4);

        System.out.println("col :"+col);
        System.out.println(col.contains(str1));

    }
}
