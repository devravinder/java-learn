package com.paravar.interview;

public class Q4 {

    public static void main(String[] args) {

        Multi multi = (a,b)->a*b;

        int res = multi.multiple(1,2);

        System.out.println(res);

        System.out.println("=============");

        int[] arr = { 1, 2, 2, 3, 4, 4, 4, 5 };

        duplicates(arr);

    }

    public static void duplicates(int... arr){

        boolean isDuplicate=false;
        for(int i=0; i<arr.length; i++){
            isDuplicate=false;
            for(int j=0; j<arr.length; j++){
                if(arr[i]==arr[j] && j!=i){
                    if(j<i)
                    {
                        break;
                    }
                    isDuplicate = true;

                }
            }

            if(isDuplicate)
                System.out.println(arr[i]);
        }

    }



}


@FunctionalInterface
interface Multi{
    int multiple(int a, int b);
}