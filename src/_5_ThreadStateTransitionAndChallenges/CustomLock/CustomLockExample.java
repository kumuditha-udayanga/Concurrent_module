package _5_ThreadStateTransitionAndChallenges.CustomLock;

public class CustomLockExample {
    public static void main(String[] args) {
        final MyLock lock = new MyLock();

        Runnable task = () -> {
          lock.lock();
          try {
              System.out.println(Thread.currentThread().getName() + " acquired the lock.");
              Thread.sleep(2000);
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.unlock();
              System.out.println(Thread.currentThread().getName() + " released the lock.");
          }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");

        thread1.start();
        thread2.start();
    }
}
