package _6_ThreadScheduling.PeemptiveScheduling;

public class PreemptiveSchedulingDemo {
    public static void main(String[] args) {
        Thread mediumPriorityThread = new Thread(new MediumPriorityTask(), "Medium");
        mediumPriorityThread.setPriority(Thread.NORM_PRIORITY);

        mediumPriorityThread.start();

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread highPriorityThread = new Thread(new HighPriorityTask(), "High");
        highPriorityThread.setPriority(Thread.MAX_PRIORITY);

        highPriorityThread.start();
    }


    static class MediumPriorityTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " has started.");
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName() + " is working.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " has completed");
        }
    }

    static class HighPriorityTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " has started and preempts lower priority threads");
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " is working.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " has completed.");
        }
    }
}
