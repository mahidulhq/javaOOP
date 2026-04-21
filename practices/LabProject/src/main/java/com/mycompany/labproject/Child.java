package com.mycompany.labproject;

public class Child extends Parent {
    String schoolName;
    String address;

    String getAddress() {
        return address;
    }
    
    String getAddressP() {
        return super.address;
    }
    
    public Child(String name, String address,
            String schoolName, String schoolAddress) {
        super(name, address);
        this.schoolName = schoolName;
        this.address = schoolAddress;
    }

    void study() {
        System.out.println(name
                + " is studying at " + schoolName);
    }
    
//    void eat() {
//        System.out.println(name + " eats noodles with fork");
//    }
    
    void eat(int number) {
        System.out.println(name + " eats " + number + " bowls of noodles");
    }
}
