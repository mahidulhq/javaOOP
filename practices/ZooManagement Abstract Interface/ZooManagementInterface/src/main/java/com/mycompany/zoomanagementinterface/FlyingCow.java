package com.mycompany.zoomanagementinterface;

public class FlyingCow implements Bird, Cow {

    String name, species;

    public void eat() {
        System.out.println(name + " eats grass");
    }

    public void move() {
        System.out.println(name + " walks on grass");
    }

    public void move(int distance) {
        System.out.println(name + 
                " walks " + distance +
                " kilo on grass");
    }

    public void fly() {
        System.out.println(name + " is flying");
    }

    public void jaborKata() {
        System.out.println(name + " jabor kate.");
    }

}
