package com.example.studentmanagementsystem.model;
import javafx.beans.property.*;

// Student class definition
public class Student {
    // private instance variables
    public String name;
    private String ID;
    private int age;
    private String grade;

    // public constructor
    public Student(String name, String ID, int age, String grade) {
        this.name = name;
        this.ID = ID;
        this.age = age;
        this.grade = grade;
    }

    // public get and set methods
    @Override
    public String toString() {
        return this.name;  // or return this.getStudentName(); depending on your implementation
    }


    public void setName(String name) { this.name = name; }

    public String getID() { return ID; }
    public void setID(String ID) { this.ID = ID; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
    public StringProperty nameProperty() {
        return new SimpleStringProperty(name);
    }

    public StringProperty idProperty() {
        return new SimpleStringProperty(ID);
    }

    public IntegerProperty ageProperty() {
        return new SimpleIntegerProperty(age);
    }

    public StringProperty gradeProperty() {
        return new SimpleStringProperty(grade);
    }
}

