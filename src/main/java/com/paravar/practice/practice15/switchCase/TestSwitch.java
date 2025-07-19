package com.paravar.practice.practice15.switchCase;

public class TestSwitch {
    public static void main(String[] args) {

        Object d = new Demo();
        testSwitch(d);




    }

    public static String testSwitch(Object o){
        // in Java 17
        // switch express
       var res =  switch (o){
            case Integer i -> i.toString();
            case Show s -> s.demo();
            case Demo d -> d.demo();
            case null -> "no value";
            default -> "default value";

        };
       return res;
    }

}
class Demo{
    String name;
    public String demo(){
        System.out.println("---");
        return "hello";
    }
}

class Show extends  Demo{

}