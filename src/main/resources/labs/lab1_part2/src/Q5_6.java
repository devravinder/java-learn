public class Q5_6 {
    public static void main(String[] args) {
        System.out.println("===============1 to 100 even numbers");
        for (int i = 0; i <= 100; i++) {
            if (isEven(i)) {
                System.out.println(i);
            }
        }

        System.out.println("===============1 to 100 odd numbers");
        for (int i = 0; i <= 100; i++) {
            if (isOdd(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isEven(int n){
        return n & 1 == 0;
    }

    public static boolean isOdd(int n){
        return n & 1 != 0;
    }
}