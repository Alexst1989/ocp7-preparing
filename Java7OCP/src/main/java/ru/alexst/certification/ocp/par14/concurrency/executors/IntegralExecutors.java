package ru.alexst.certification.ocp.par14.concurrency.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class IntegralExecutors {

    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        System.out.println(rt.availableProcessors());
        ExecutorService ex = Executors.newFixedThreadPool(10);
        ex.shutdown();

        ThreadPoolExecutor tpe = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
        tpe.setCorePoolSize(8);
        tpe.setMaximumPoolSize(8);

    }

}
