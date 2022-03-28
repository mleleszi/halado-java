package com.example.general;

import com.example.general.impl.Worker;

// dependency IV
public class WeakUsage extends Worker {

    // dependency I
    Worker worker;

    // dependency II
    public void hello(Worker worker) {

    }

    // dependency III
    public void masik() {
        Worker worker = new Worker();
    }

}
