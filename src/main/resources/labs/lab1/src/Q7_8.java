public class Q7_8 {
    public static void main(String[] args) {
        byte b = 50;
        int x = b; // why does this work?
        b = x; // why does this not work?
        //b = (byte) x;
        System.out.println(b);
    }
}