package com.mycompany.zoomanagement;

public class Cow extends Animal {

    public Cow(String name, String species, double height) {
        super(name, species, height);
    }
    
    void jaborKata() {
        System.out.println(name + " jabor kate");
    }
    
    void eat() {
        System.out.println(name + " eats grass");
    }

    void eat(int time) {
        System.out.println(name + 
                " eats grass for " 
                + time + " hours");
    }
    
}
