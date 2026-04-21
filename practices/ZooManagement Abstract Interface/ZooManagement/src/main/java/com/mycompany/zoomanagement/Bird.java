package com.mycompany.zoomanagement;

public class Bird extends Animal {

    public Bird(String name, String species, double height) {
        super(name, species, height);
    }
    
    // Override optional
    void move() {
        System.out.println(name + " is flying.");
    }
    
    // Override mandatory
    void eat() {
        System.out.println(name + " eats insects");
    }
    
    void fly () {
        System.out.println(name + " is flying");
    }
    
    // Override mandatory
    void eat(int time) {
        System.out.println(name +
                " eats insects for " 
                + time + " hours");
    }
    
}
