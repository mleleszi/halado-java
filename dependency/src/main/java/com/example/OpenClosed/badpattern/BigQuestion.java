package com.example.OpenClosed.badpattern;

public class BigQuestion {
    public int get(int value){
        int rv;
        boolean odd = value % 2 == 0;

        if (value < 0) {
            if (value < -50) {
                return -2;
            } else {
                return -1;
            }
        }


        if (value > 35) {
            if (value == 100) {
                rv = (int) Math.round(Math.sqrt(value));
            } else {
                rv = value;
            }
        }

        else
            rv = 0;

        if (odd)
            rv *= 2;

        return rv;
    }
}
