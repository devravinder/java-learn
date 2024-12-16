public class A {
    public static void main(String[] args) {
        System.out.println("A");
    }
}
/*public*/  class B {
    public static void main(String[] args) {
        System.out.println("B");
    }
}
/*public*/ class C {
    public static void main(String[] args) {
        System.out.println("C");
    }
}

/*
to compile: javac -d ../cls A.java
to run A: java -cp ../cls A
to run B: java -cp ../cls B
to run C: java -cp ../cls C
* */
