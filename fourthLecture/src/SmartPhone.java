public class SmartPhone {
    String brand, model, processor;
    double cameraSize;
    
    
    public SmartPhone(String brand, String model, String processor, double cameraSize) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.cameraSize = cameraSize;
    }
    
    void takePhoto() { 
        if (cameraSize <= 0) {
            System.out.println("Phone does not have a camera");
        } else {
            System.out.println("Took photo with " + cameraSize + " megapixel camera.");
        }
    }
    
    void takePhoto(int numPhotos) { 
        if (cameraSize <= 0) {
            System.out.println("Phone has no camera");
        } else {
            System.out.println("Took " + numPhotos + " photos with " + cameraSize + " megapixel camera.");
        }
    }
}
