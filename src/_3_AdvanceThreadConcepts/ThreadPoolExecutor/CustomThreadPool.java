package _3_AdvanceThreadConcepts.ThreadPoolExecutor;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
    private final int poolSize;
    private final Worker[] workers;
    private final BlockingQueue<Runnable> taskQueue;

    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        workers = new Worker[poolSize];
        taskQueue = new LinkedBlockingQueue<>();

        for (int i = 0; i < poolSize; i++) {
            workers[i] = new Worker("Worker - "+ i);
            workers[i].start();
        }
    }

    public void execute(Runnable task) {
        try {
            taskQueue.put(task);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class Worker extends Thread {
        public Worker(String name) {
            super(name);
        }

        @Override
        public void run () {
            while (true) {
                try {
                    Runnable task = taskQueue.take();
                    System.out.println(Thread.currentThread().getName()+ " executing task.");
                    task.run();
                }   catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
