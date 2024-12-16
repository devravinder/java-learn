package com.paravar.labs.lab6;

public class Q1_TestDevice {
    public static void main(String[] args) {
        Device d = new Device("modern-device");
        //d.name = "Davy";
        d.doSomething();

        d = new Printer("HP");
        d.doSomething();


        Device tv = new Tv("LG");
        tv.doSomething();
        // tv.switchChannel(); gives error
        Tv lg = (Tv)tv;
        lg.switchChannel(); // works


        Tv sumsang = new Tv("Sumsang");
        sumsang.doSomething();
        sumsang.switchChannel();



        d = new MicroWave("MicroWave");
        d.doSomething();
        //============


        System.out.println(" d instanceof Device:"+ (d instanceof Device));
        System.out.println(" d instanceof MicroWave:"+ (d instanceof MicroWave));
        System.out.println(" d instanceof Tv:"+ (d instanceof Tv));
        System.out.println(" d instanceof Printer:"+ (d instanceof Printer));
        System.out.println(" d instanceof Object:"+ (d instanceof Object));
        // System.out.println(" d instanceof String:"+ (d instanceof String));
        // instance works only b/w related data types ( Is-A  relation )


        //==========


        Electrician electrician = new Electrician();

        Device d1 = new Device("Device-1");
        Device tv1 = new Tv("Tv-1");
        Printer p = new Printer("Printer-1");
        MicroWave mc1 = new MicroWave("MicroWave-1");

        electrician.testDevice(d1);
        electrician.testDevice(tv1);
        electrician.testDevice(p);
        electrician.testDevice(mc1);











    }
}
class Device {
    private String name;

    public Device() {
    }

    public Device(String name) {
        this.name = name;
        System.out.println("In Device arg constructor");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void doSomething(){
        System.out.println(name+" device is doing something");
    }
}

class Tv extends Device{

    public Tv(String name) {
        //  System.out.println("In Tv arg constructor"); // gives error
        super(name); // constructor chaining should be 1st statement i.e this() / super()
        System.out.println("In Tv arg constructor");
    }

    @Override
    public void doSomething() {
        System.out.println(getName()+" In Tv doSomething");
    }

    public void switchChannel(){
        System.out.println("Switching channel");
    }
}

class MicroWave extends Device{

    public MicroWave(String name) {
        super(name);
        System.out.println("In MicroWave arg constructor");
    }

    @Override
    public void doSomething() {
        System.out.println(getName()+ " In MicroWave doSomething");
    }
}
class Printer extends Device{
    public Printer(String name) {
        super(name);
        System.out.println("In Printer arg constructor");
    }

    @Override
    public void doSomething() {
        System.out.println(getName()+ " In Printer doSomething");
    }
}

class Electrician {

    public void  testDevice(Device d){
        d.doSomething();

        if(d instanceof Tv tv){
            // Tv tv = (Tv) d;
            tv.switchChannel();
        }
    }
}