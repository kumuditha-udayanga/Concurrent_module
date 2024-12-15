package _6_ThreadScheduling;

public class ThreadPriorityDemo {
    public static void main(String[] args) {
        Thread maxPriority = new Thread(new Task(), "Max Priority Thread");
        Thread normPriority = new Thread(new Task(), "Normal Priority Thread");
        Thread minPriority = new Thread(new Task(), "Min Priority Thread");

        maxPriority.setPriority(Thread.MAX_PRIORITY);
        normPriority.setPriority(Thread.NORM_PRIORITY);
        minPriority.setPriority(Thread.MIN_PRIORITY);

        minPriority.start();
        normPriority.start();
        maxPriority.start();
    }
}
