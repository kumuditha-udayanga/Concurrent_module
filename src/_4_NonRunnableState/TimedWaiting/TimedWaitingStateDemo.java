package _4_NonRunnableState.TimedWaiting;

public class TimedWaitingStateDemo {
    public static void main(String[] args) {
        Thread sleepingThread = new Thread(() -> {
            try {
                System.out.println("SleepingThread is sleeping.");
                Thread.sleep(4000);
                System.out.println("SleepThread woke up");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        sleepingThread.start();
    }
}
