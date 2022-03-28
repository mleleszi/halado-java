package com.example.general;

import com.example.general.impl.HardWorker;
import com.example.general.impl.NewWorker;
import com.example.general.impl.Worker;

public class Main {
    public static void main(String[] args) {
        new Director(new Worker()).doIt(5);
        new Director(new HardWorker()).doIt(10);
        new Director(new NewWorker()).doIt(10);

        // run(new NewWorker());
    }

    public static void run (Worker worker) {
        worker.test();
    }
}
