package _2_ThreadAttributesAndManagement;

public class ThreadNameTest {
    public static void main(String[] args) {
        SimpleThread thread1 = new SimpleThread("Alpha");
        SimpleThread thread2 = new SimpleThread("Beta");

        thread1.start();
        thread2.start();
    }
}
