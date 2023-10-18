package de.ait.models;

public class User {
    private String firstName;
    private String secondName;
    private int age;
    private double height;

    public User(String firstName, String secondName, int age, double height) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.height = height;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }
}
