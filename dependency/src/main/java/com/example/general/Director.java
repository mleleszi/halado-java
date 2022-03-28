package com.example.general;

public class Director {

    private final Worker worker;

    public Director(Worker worker) {
        this.worker = worker;
    }

    public void doIt(int value) {
        if (value > 0)
            worker.test();
    }
}
