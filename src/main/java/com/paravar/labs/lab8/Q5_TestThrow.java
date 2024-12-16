package com.paravar.labs.lab8;

public class Q5_TestThrow {
    public static void main(String[] args) throws Exception {

        try {
            System.out.println("Going to use throws");

            if(1==1)
            //throw new NullPointerException("Null");
                throw  new MyException("Some invalid data");

            System.out.println("after throw");
        } catch (MyException e) {
            System.out.println("Message :-"+e.getMessage());
            e.printStackTrace();
        }
    }
}

class MyException extends Exception{

    MyException(){}
    public MyException(String msg) {
        super(msg);
    }


}
