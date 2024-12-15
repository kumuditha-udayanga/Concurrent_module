package _4_NonRunnableState.WaitingStateDemo;

public class WaitingStateDemo {
    public static void main(String[] args) {
        final Object monitor = new Object();

        Thread waitingThread = new Thread(()->{
            synchronized (monitor) {
                try {
                    System.out.println("WaitingThread is waiting");
                    monitor.wait();
                    System.out.println("WaitingThread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread notifying = new Thread(()-> {
           try {
               Thread.sleep(2000);
               synchronized (monitor) {
                   System.out.println("NotifyingThread is notifying");
                   monitor.notify();
               }
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        });

        waitingThread.start();
        notifying.start();
    }

}
