package _7_ThreadGroups;

public class ThreadGroupDemo {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Parent Group");


        Thread thread1 = new Thread(group, new Task(), "Thread 1");
        Thread thread2 = new Thread(group, new Task(), "Thread 2");
        Thread thread3 = new Thread(group, new Task(), "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int activeCount = group.activeCount();
        System.out.println("Active thread count: " + activeCount);

        Thread[] threads = new Thread[activeCount];
        group.enumerate(threads);

        for (Thread t: threads) {
            System.out.println("Thread Name: " + t.getName());
        }
    }


    static class Task implements Runnable {
        @Override
        public void run () {
            System.out.println(Thread.currentThread().getName() + " is running");
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
