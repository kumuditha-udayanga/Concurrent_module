package _7_ThreadGroups;

public class ThreadGroupManagementDemo {
    public static void main(String[] args) {
        ThreadGroup rootGroup = new ThreadGroup("Root Group");

        ThreadGroup groupA = new ThreadGroup(rootGroup, "Group A");
        ThreadGroup groupB = new ThreadGroup(rootGroup, "Group B");

        ThreadGroup subGroupA1 = new ThreadGroup(groupA, "SubGroupA1");

        new Thread(groupA, new Task(), "Thread A1").start();
        new Thread(groupB, new Task(), "Thread B1").start();
        new Thread(subGroupA1, new Task(), "Thread A1.1").start();

        rootGroup.list();
    }

    static class Task implements Runnable {
        @Override
        public void run () {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
