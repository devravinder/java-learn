public class Q26 {
    public static void main(String[] args) {
       x();
       Test1.z();

    }

    public static void x(){
        System.out.println("start in x");

        y();

        System.out.println("end in x");



    }

    public static void y(){
        System.out.println("start in y");

        System.out.println("end in y");

    }


}
class Test1 {
    public static void z(){
        System.out.println("start in z");

        System.out.println("end in z");

    }
}

