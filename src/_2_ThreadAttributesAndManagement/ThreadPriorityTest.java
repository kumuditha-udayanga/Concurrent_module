package _2_ThreadAttributesAndManagement;

public class ThreadPriorityTest {
    public static void main(String[] args) {
        SimpleThread thread1 = new SimpleThread("High Priority");
        SimpleThread thread2 = new SimpleThread("Low Priority");

        thread1.setPriority(Thread.MAX_PRIORITY);
        thread2.setPriority(Thread.MIN_PRIORITY);

        thread1.start();
        thread2.start();
    }
}
