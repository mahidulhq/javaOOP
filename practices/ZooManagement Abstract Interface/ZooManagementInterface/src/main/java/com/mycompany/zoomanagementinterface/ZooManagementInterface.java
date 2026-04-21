package com.mycompany.zoomanagementinterface;

public class ZooManagementInterface {

    public static void main(String[] args) {
        FlyingCow goru = new FlyingCow();
        goru.name = "Hamba";
        goru.eat();
        goru.move(3);
        goru.fly();
        goru.jaborKata();
    }
}
