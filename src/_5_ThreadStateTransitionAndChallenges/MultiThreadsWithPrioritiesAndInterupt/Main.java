package _5_ThreadStateTransitionAndChallenges.MultiThreadsWithPrioritiesAndInterupt;

public class Main {
    public static void main(String[] args) {
        Runnable task = new InterruptableTask();

        Thread highPriorityThread = new Thread(task, "HighPriorityThread");
        Thread lowPriorityThread = new Thread(task, "LowPriorityThread");

        highPriorityThread.setPriority(Thread.MAX_PRIORITY);
        lowPriorityThread.setPriority(Thread.MIN_PRIORITY);

        highPriorityThread.start();
        lowPriorityThread.start();

        try {
            Thread.sleep(5000);
            highPriorityThread.interrupt();
            lowPriorityThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
