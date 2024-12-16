package com.paravar.labs.lab8;

public class Q1_ArrayIndexOutOfBounds {
    public static void main(String[] args) {

        try {
            int[] arr = new int[5];
            arr[5] = 10;
        }
        catch (ArrayIndexOutOfBoundsException e) {
           e.printStackTrace();
        }
        catch (RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
