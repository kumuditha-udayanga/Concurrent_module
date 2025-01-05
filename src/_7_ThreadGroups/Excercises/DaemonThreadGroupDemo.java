package _7_ThreadGroups.Excercises;

public class DaemonThreadGroupDemo {
    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("Monitoring Group");

        // Worker threads
        Thread worker1 = new Thread(group, new WorkerTask(), "Worker 1");
        Thread worker2 = new Thread(group, new WorkerTask(), "Worker 2");

        // Daemon monitoring thread
        Thread monitor = new Thread(group, new MonitorTask(group), "Monitor");
        monitor.setDaemon(true); // Set as daemon

        worker1.start();
        worker2.start();
        monitor.start();
    }

    static class WorkerTask implements Runnable {
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " is working.");
            try {
                Thread.sleep(200); // Simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " has finished work.");
        }
    }

    static class MonitorTask implements Runnable {
        private ThreadGroup group;

        public MonitorTask(ThreadGroup group) {
            this.group = group;
        }

        @Override
        public void run() {
            while (group.activeCount() > 0) {
                System.out.println("Monitor: Active threads = " + group.activeCount());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Monitor: No active threads remaining.");
        }
    }

}
