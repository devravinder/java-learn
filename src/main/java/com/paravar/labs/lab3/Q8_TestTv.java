package com.paravar.labs.lab3;

public class Q8_TestTv {
    public static void main(String[] args) {
        Tv tv = new Tv();
        tv.turnOn();
        tv.setChannel(30);
        tv.increaseVolume();
        tv.display();
        tv.decreaseVolume();
        tv.decreaseChannel();
        tv.display();
        tv.decreaseChannel();
        tv.increaseChannel();
        tv.decreaseChannel();
        tv.setChannel(120);
        tv.display();
        tv.turnOff();
        tv.display();
    }
}
class  Tv{
    boolean isOn = false;
    int channel = 1;
    int volumeLevel = 1;
    void turnOn(){
        isOn = true;
    }
    void turnOff(){
        isOn = false;
    }
    void setChannel(int newChannel){
        if(isOn && newChannel >= 1 && newChannel <= 120)
            channel = newChannel;
    }
    void increaseVolume(){
        if(isOn && volumeLevel < 7)
            volumeLevel++;
    }
    void decreaseVolume(){
        if(isOn && volumeLevel > 1)
            volumeLevel--;
    }
    void increaseChannel(){
        if(isOn && channel < 120)
            channel++;
    }
    void decreaseChannel(){
        if(isOn && channel > 1)
            channel--;
    }
    void display(){
        if(isOn)
        System.out.println("Channel: "+channel+" Volume: "+volumeLevel);
    }

}