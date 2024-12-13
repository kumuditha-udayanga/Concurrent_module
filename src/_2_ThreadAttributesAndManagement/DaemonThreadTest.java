package _2_ThreadAttributesAndManagement;

public class DaemonThreadTest {
    public static void main(String[] args) {
        SimpleThread daemonThread = new SimpleThread("Daemon Thread");
        daemonThread.setDaemon(true);
        daemonThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Main thread exiting");
    }
}
