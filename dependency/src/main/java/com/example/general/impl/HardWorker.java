package com.example.general.impl;

import com.example.general.Worker;

public class HardWorker implements Worker {
    @Override
    public void test() {
        System.out.println("HardWorker");
    }
}
