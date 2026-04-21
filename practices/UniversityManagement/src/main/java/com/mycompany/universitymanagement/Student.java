
package com.mycompany.universitymanagement;

public class Student {
    private String name, id, dept;
    private double cgpa;
    public static String uniName = "MU";

    public Student(String name, String id, String dept, double cgpa) {
        setName(name);
        this.id = id;
        this.dept = dept;
        this.cgpa = cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.equals("")) {
            System.out.println("Invalid name!");
        } else {
            this.name = name;
        }
    }
    
    
    
}
