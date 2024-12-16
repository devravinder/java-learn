package com.paravar.labs.lab5;

public class Q3_TestSong {
    public static void main(String[] args) {

        Song s1 = new Song("Hosanna", "Hosanna Hosanna Hosanna Hoooo Saa naa"); // new Song();
        s1.play();
        s1.setName("Once Again");
        s1.setLyrics("Once Again Hosanna Hosanna Hosanna Hoooo Saa naa");
        s1.play();

        Song s2 = new Song("Lalala", "Lala Laa laa lla alla");
        s2.play();

    }
}

class Song{
    private String name;
    private String lyrics;


    public Song() {
        System.out.println("No args constructor called");
    }

    public Song(String name, String lyrics) {
        this.setLyrics(lyrics);
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null || name.isEmpty()) {
            System.out.println("Name cannot be null or empty");
            return;
        }
        this.name = name;
    }

    public String getLyrics() {
        return lyrics;
    }

    public void setLyrics(String lyrics) {
        if(lyrics == null || lyrics.isEmpty()) {
            System.out.println("Lyrics cannot be null or empty");
            return;
        }
        this.lyrics = lyrics;
    }

    public void play() {
        System.out.println("Playing "+name+" - "+lyrics);
    }
}
