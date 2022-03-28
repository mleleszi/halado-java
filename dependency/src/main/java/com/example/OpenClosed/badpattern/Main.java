package com.example.OpenClosed.badpattern;

public class Main {

    public static void main(String[] args) {
        System.out.println(new BigQuestion().get(42));
        System.out.println(new BigQuestion().get(43));
        System.out.println(new BigQuestion().get(34));
        System.out.println(new BigQuestion().get(-10));
        System.out.println(new BigQuestion().get(100));
        System.out.println(new BigQuestion().get(-100));
    }
}
