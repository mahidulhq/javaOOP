package com.mycompany.labproject;

//public final class Parent {
public class Parent {
    String name, address;

    public Parent(String name, String address) {
        this.name = name;
        this.address = address;
    }

    final void eat() {
        System.out.println(name 
                + " eats rice with their hand");
    }
    void eat(int number) {
        System.out.println(name + " eats " + number + " kg rice");
    }
}
