package com.mycompany.zoomanagement;

public class ZooManagement {

    public static void main(String[] args) {
        Animal a;
        a = new Bird("Mithu", "Parrot", 10);
        a.eat();
        a = new Cow("Jersey", "Goru",
                30);
        a.eat();
    }
}
