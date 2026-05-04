package com.mycompany.lectureone;


public class LectureOne {

    public static void main(String[] args) {
//        int age = 20;
//        double marks = 85.5;
//        char grade = 'A';
//        boolean passed = true;
//        String name = "@mahidul";
//
//        System.out.println("Hi, my handle is " + name + " and my age is "+ age + ".");
//        System.out.println("Im on second semester and my result is " + grade + ". The number i got on the course COA is "+ marks + ".");
//        System.out.println("Did i passed or failed? the system says: "+ passed);
//        
//        System.out.println("now we are learning loops on java.");
//        int n = 6;
//        for (int i = 1; i < n; i++) {
//            System.out.println(i);
//        }
//        
//        System.out.println("Now we are learning Array on Java:");
//        int arr[] = new int[5];
//        arr[0] = 5;
//        arr[1] = 1001;
//        arr[2] = 15;
//        arr[3] = 20;
//        arr[4] = 25;
//        
//        System.out.println(arr[1]);
        
        student s = new student();
        s.name = "Mahidul";
        s.id = "242-115-006";
        s.address = "syl, bd";
        s.write();
        System.out.println("student name is " + s.name);
        
        student w = new student();
        w.name = "Haque";
        w.id = "242-115-069";
        w.address = "syl, uganda";
        w.write();
        System.out.println("student name is " + w.name);
    }
}
