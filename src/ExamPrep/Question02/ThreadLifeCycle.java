package ExamPrep.Question02;

public class ThreadLifeCycle {

    public static void main(String[] args) {
//        NEW state
        Thread newThread = new Thread(() -> {
//          RUNNABLE State
            System.out.println("The is in RUNNABLE state");

            for (int i = 0; i < 3; i++) {
                System.out.println("Executing");
                try {
                    Thread.sleep(500);
//                  TIMED_WAITING State
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

//          BLOCKED
            synchronized (ThreadLifeCycle.class) {
                System.out.println("Thread is in BLOCKED state (synchronized block)");
            }

            synchronized (ThreadLifeCycle.class) {
                try {
                    System.out.println("Thread is in WAITING state (waiting for a notification)");
//                  WAITING
                    ThreadLifeCycle.class.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                System.out.println("Thread is TIMED_WAITING state (sleeping for 3 seconds)");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Thread is in TERMINATED state");
        });

        newThread.start();

//      NOTIFY the waiting thread to move from WAITING to RUNNABLE
        synchronized (ThreadLifeCycle.class) {
            System.out.println("Notify the waiting thread");
            ThreadLifeCycle.class.notify();
        }

        try {
            newThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
