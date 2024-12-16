package com.paravar.labs.lab5;

public class Q4_TestJokes {
    public static void main(String[] args) {
            Joke j1 = new Joke("Why did the chicken cross the road?");
            j1.print();
            Joke j2 = new Joke("Where did the chicken go?");
            j2.print();
        System.out.println("Count = " + Joke.count);

    }
}
class Joke {
    private String text;
    static int count = 0;

    public Joke(String text) {
        this.text = text;
        count++;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void print(){
        System.out.println(this.text);
    }


}