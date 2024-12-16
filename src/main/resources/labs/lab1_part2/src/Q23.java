public class Q23 {
    public static void main(String[] args) {

        int x = 50;
        System.out.println(x);
        Test.process(x);
        System.out.println(x);


    }


}

class Test {
    static void process (int x){
        System.out.println("=========== in process before changing "+ x);
        x = 20;
        System.out.println("=========== in process after changing "+ x);
    }
}