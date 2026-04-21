package com.mycompany.fourthlab;

public class FourthLab {
void compareCamera(Smartphone a, Smartphone b) {
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
    public static void main(String[] args) {
        Smartphone galaxy = new Smartphone(
            "Samsung", 
            "S25 Ultra",
            "Snapdragon 8 Elite",
            200);
        Smartphone iPhone = new Smartphone(
                "Apple",
                "17 Pro Max",
                "Apple A18 Pro",
                12.2);
        Smartphone.compareCamera(galaxy, iPhone);
    }
}
