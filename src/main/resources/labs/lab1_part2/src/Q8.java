public class Q8 {
    public static void main(String[] args) {
        System.out.println("===============1 to 100");
        for (int i = 0; i <= 100; i++) {
            if (isEven(i)) {
                System.out.println(i+" is even");
            }else {
                System.out.println(i+" is odd");
            }
        }


    }

    public static boolean isEven(int n){
        return n % 2 == 0;
    }

}