package com.paravar.labs.lab2.part2;

public class Q6 {
    public static void main(String[] args) {
        noOfDaysInMonth(2, 2020);
        noOfDaysInMonth(2, 2100);
        noOfDaysInMonth(3, 2020);
        noOfDaysInMonth(13, 2020);
        noOfDaysInMonth(2, 2000);

    }
    public static void noOfDaysInMonth(int month, int year){
       switch (month){
           case 1: case 3: case 5: case 7: case 8: case 10: case 12:
               System.out.println(31);
               break;
           case 4: case 6: case 9: case 11:
               System.out.println(30);
               break;
           case 2:
               if(isLeapYear(year))
                   System.out.println(29);
               else
                   System.out.println(28);
               break;
           default:
               System.out.println("Invalid month");
               break;
       }
    }
    public static boolean isLeapYear(int year){
       return (year%4==0 && year%100!=0) || year%400==0;
    }
}
