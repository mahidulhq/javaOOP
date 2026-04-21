package com.mycompany.zoomanagement;

public abstract class Animal {
    String name, species;
    double height;

    public Animal(String name, String species, double height) {
        this.name = name;
        this.species = species;
        this.height = height;
    }
    
    abstract void eat();
    abstract void eat(int time);
            
    void move() {
        System.out.println(name + " is moving");
    }
}
