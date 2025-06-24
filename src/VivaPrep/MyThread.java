package VivaPrep;

import java.util.concurrent.Semaphore;

class MyThread implements Runnable {
    Semaphore sharedResource;
    public MyThread(Semaphore sharedResource) {
        this.sharedResource = sharedResource;
    }
    @Override
    public void run () {
        for (int i = 1; i <= 10; i++) {
            System.out.println("My thread " + i + " " + Thread.currentThread().getName());
            try {
                sharedResource.acquire();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sharedResource.release();
            }
        }
    }
}
