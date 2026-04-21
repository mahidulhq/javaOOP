package com.mycompany.fourthlab;

public class Smartphone {

    String brand, model, processor;
    double cameraSize;

    public Smartphone(String brand, String model, String processor, double cameraSize) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.cameraSize = cameraSize;
    }

    // overload Smartphone constructor
    public Smartphone(String brand, String model, String processor) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
    }

    void takePhoto() {
        System.out.println("Took photo with "
                + cameraSize + " megapixel camera.");
    }

    void takePhoto(int numPhotos) {
        System.out.println("Took "
                + numPhotos + " photos with "
                + cameraSize + " megapixel camera.");
    }

    static void compareCamera(Smartphone a, Smartphone b) {
        if (a.cameraSize >= b.cameraSize) {
            System.out.println(a.brand + " " + a.model
                    + " has a better camera with "
                    + a.cameraSize + " megapixels");
        } else {
            System.out.println(b.brand + " " + b.model
                    + " has a better camera with "
                    + b.cameraSize + " megapixels");
        }
    }
}
