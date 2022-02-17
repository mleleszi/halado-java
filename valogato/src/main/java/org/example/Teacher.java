package org.example;

public class Teacher implements PersonChecker{
    private String name;
    private int age;
    float wordInMinutes;

    private static final int MAXIMUM_WORD_IN_MINUTES = 100;

    public Teacher() {
    }

    public Teacher(String name, int age, float wordInMinutes) {
        this.name = name;
        this.age = age;
        this.wordInMinutes = wordInMinutes;
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

    public float getWordInMinutes() {
        return wordInMinutes;
    }

    public void setWordInMinutes(float wordInMinutes) {
        this.wordInMinutes = wordInMinutes;
    }

    @Override
    public boolean isOk() {
        return wordInMinutes < MAXIMUM_WORD_IN_MINUTES;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", wordInMinutes=" + wordInMinutes +
                '}';
    }
}
