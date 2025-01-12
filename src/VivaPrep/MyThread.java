package VivaPrep;

class MyThread implements Runnable {
    @Override
    public void run () {
        for (int i = 1; i <= 10; i++) {
            System.out.println("My thread " + i + " " + Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
