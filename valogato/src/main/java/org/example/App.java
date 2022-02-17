package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    private static void printGoodUniversityCitizens(PersonChecker[] citizens) {
        for (PersonChecker citizen : citizens) {
            if (citizen.isOk()) {
                System.out.println(citizen);
            }
        }
    }

    public static void main( String[] args )
    {

        PersonChecker[] citizens = new PersonChecker[6];

        citizens[0] = new Student("student 1", 22, 2, 3.4F);
        citizens[1] = new Teacher("teacher 1", 62, 120);
        citizens[2] = new Student("student 2", 22, 0, 4.4F);
        citizens[3] = new Student("student 3", 22, 2, 4.4F);
        citizens[4] = new Student("student 4", 22, 2, 3.4F);
        citizens[5] = new Teacher("teacher 2", 62, 50);


        printGoodUniversityCitizens(citizens);
    }
}
