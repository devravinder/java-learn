package com.paravar.labs.lab3;


/*
  Steps to program

  Test Cases:-
  'F'a'S't  'B'a'L'l
    Failure check
    Single Check
    Boundary Check
    Logic Check


  refer is prime
* */
public class LogicalPrgrams {
    public static void main(String[] args) {

        System.out.println("is 23, non 3 multiple ends with odd? "+isNon3MultipleEndsWithOdd(23));
        System.out.println("is 21, non 3 multiple ends with odd? "+isNon3MultipleEndsWithOdd(21));

        System.out.println("is 27, power of 3? "+isPowerOf3(27));
        System.out.println("is 21, power of 3? "+isPowerOf3(21));
        System.out.println("is 18, power of 3? "+isPowerOf3(18));


        System.out.println("sum of 123 & its reverse = "+sumOfNumAndReverse(123));

        System.out.println("random string "+ randonmString(5));

        System.out.println("123 is increasing Num "+ isIncreasingNum(123));
        System.out.println("234 is increasing Num "+ isIncreasingNum(234));
        System.out.println("546 is increasing Num "+ isIncreasingNum(546));

        System.out.println(" is 19, prime? "+ isPrime(19));
        printPrimes(100);

        System.out.println("noOf1Bits in 3 is "+noOf1Bits(3));

        System.out.println("is 121 polindrom? "+isPolindrom(121));

        System.out.println(" is square 9? "+isSquare(9));


    }


    /*
    WAM to test whether a given number ends with an odd digit not divisible by 3. Follow steps to program
    *
    // check if it is odd ( ends wit odd )
    // check is it 3 multiple
    * */

    public static boolean isNon3MultipleEndsWithOdd(int num){

        if(isOdd(num) && !is3Multiple(num))
            return true;
        else return false;
    }
    public static boolean isOdd(int num){
        return (num & 1) !=0;
    }
    public static boolean is3Multiple(int num){
        return (num % 3) == 0;
    }

    /*
    WAM to test whether number given is a power of 3
    (Repetitively divide by 3 and its   quotient and check if remainder is 0 until quotient becomes <3)

    * */

    public static boolean isPowerOf3(int num){

        int quotient = num / 3;
        while (quotient >= 3){
            quotient = quotient / 3;
        }
        return quotient==1;
    }

    /*
    WAM to add a number and its reversed digits number and return the sum,
    ex: if input is 1234 then add 1234+4321 and return the sum.
    * */
    public static int sumOfNumAndReverse(int num){
        return num + reverse(num);
    }
    public static int reverse(int num) {
        int reverse = 0;

        while (num != 0) {
            int lastDigit = num % 10;
            reverse = reverse * 10 + lastDigit;
            num = num / 10;
        }
        return reverse;
    }

    /*
    Generate a String with random number of 10 digits in it and return it.
    * */
    public static String randonmString(int length){
        String str = "";
        while (length > 0) {
            str += (int)(Math.random()*10);
            length--;
        }
        return str;
    }

    /*
    Check if a number contains increasing digits. Ex: 1234, 156, 1239, etc.
    The number should not even contain equal digits.
    **/
    public static boolean isIncreasingNum(int num){

        int last = num % 10;
        num = num/10;

        while (num > 0){
            int current = num % 10;
            if(current > last)
                return false;
            last = current;
            num = num/10;
        }
        return true;
    }

    /*
        WAP to test if a given number is prime.
    * */
    public static boolean isPrime(int num){
        if(num < 2) // failure check
            return false;
        if(num == 2) // single check
            return true;
        // logic check
        if(!isOdd(num))
            return false;

        for(int n = 3 ; n < num / 2 ; n += 2){
            if(num % n == 0)
                return false;
        }
        return  true;
    }

    public static void printPrimes(int range){
        for (int i = 2; i < range; i++) {
            if(isPrime(i))
                System.out.println(i);
        }
    }

    /*
    WAP to test number of bits set to 1 in a positive int given.
    * */
    public static int noOf1Bits(int num){
        int count=0;

        while (num > 0){
            if((num & 1) == 1) //do you understand this?
                count++;
            num = num >> 1;
        }

        return count;
    }

    public static  boolean isSquare(int num){

        /*
        double sqrt = Math.sqrt(num);
        return sqrt - (int)sqrt == 0;
        */


        int sqrt = (int)Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static boolean isPolindrom(int num) {
        return reverse(num) == num;
    }

    public static boolean haveSameDigits(){
        // need to know array's first
        return  false;
    }

    public static  int gcd(int first, int second){
        /*
         gcd is always smaller than the small number & dived the both numbers
        */

        int small = first < second ? first : second;

        while (small != 0){
            if(first % small == 0 && second % small == 0)
                return small;
            small--;
        }
        return  -1; // not found

        /*
        if(second == 0)
            return first;
        else
            return gcd(second, first % second);
        */
    }
}
