package com.mycompany.labproject;

public class LabProject {

    public static void main(String[] args) {
        final Parent p = new Parent("John", "USA");
        Child c = new Child("Tom", "USA", "RISE", "Botesshor");
        c.eat();
    }
}
