package model;

public class Student{

    private int id;
    private String name;
    private int marks;

    //Constructor
    public Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }
}