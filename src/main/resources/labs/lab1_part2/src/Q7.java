public class Q7 {
    public static void main(String[] args) {
        System.out.println("===============1 to 100 => 3 multiples");
        for (int i = 0; i <= 100; i++) {
            if (is3Multiple(i)) {
                System.out.println(i);
            }
        }


    }

    public static boolean is3Multiple(int n){
        return n % 3 == 0;
    }

}