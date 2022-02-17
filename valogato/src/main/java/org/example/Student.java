package org.example;

public class Student implements PersonChecker {
    private String name;
    private int age;
    private int cheatNumber;
    float average;

    private static final double GOOD_AVERAGE_MINIMUM = 4.0;

    public Student() {
    }

    public Student(String name, int age, int cheatNumber, float average) {
        this.name = name;
        this.age = age;
        this.cheatNumber = cheatNumber;
        this.average = average;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCheatNumber() {
        return cheatNumber;
    }

    public void setCheatNumber(int cheatNumber) {
        this.cheatNumber = cheatNumber;
    }

    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }

    @Override
    public boolean isOk() {
        return average > GOOD_AVERAGE_MINIMUM && cheatNumber == 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cheatNumber=" + cheatNumber +
                ", average=" + average +
                '}';
    }
}
