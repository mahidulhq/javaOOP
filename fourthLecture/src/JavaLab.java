public class JavaLab {
    public static void main(String[] args) {
        SmartPhone galaxy = new SmartPhone("Realme", "17 pro max", "Snapdragon A17", 12.2);
        galaxy.takePhoto();
        galaxy.takePhoto(3);
        
        
        SmartPhone noCameraPhone = new SmartPhone("Nokia", "1100", "None", 0);
        noCameraPhone.takePhoto();
        noCameraPhone.takePhoto(5);
    }
}
