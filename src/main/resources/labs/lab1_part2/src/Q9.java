public class Q9 {
    public static void main(String[] args) {
        System.out.println("divisble by 3 or 5 but not by both, between 1 to 100");
        for (int i = 0; i <= 100; i++) {
            if (isDivisible(i)) {
                System.out.println(i + " is divisble");
            }
        }


    }

    public static boolean isDivisible(int n){
        return n%3==0 ^ n%5==0;
    }

}