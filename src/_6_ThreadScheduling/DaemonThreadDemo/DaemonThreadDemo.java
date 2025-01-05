package _6_ThreadScheduling.DaemonThreadDemo;

public class DaemonThreadDemo {
    public static void main(String[] args) {
        Thread userTask = new Thread(new UserTask(), "UserTask");
        Thread daemonTask = new Thread(new DaemonTask(), "DaemonTask");
        daemonTask.setDaemon(true);

        userTask.start();
        daemonTask.start();

    }

    static class UserTask implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " is running");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class DaemonTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " is running");
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
