package _7_ThreadGroups.Excercises;

public class MaxPriorityDemo {
    public static void main(String[] args) {
        ThreadGroup parentGroup = new ThreadGroup("Parent Group");
//        parentGroup.setMaxPriority(Thread.MAX_PRIORITY);

        ThreadGroup childGroup = new ThreadGroup("Child Group");
        childGroup.setMaxPriority(Thread.NORM_PRIORITY);

//        ThreadGroup minGroup = new ThreadGroup("Min Group");
//        normalGroup.setMaxPriority(Thread.MIN_PRIORITY);

        Thread thread1 = new Thread(parentGroup, new Task(), "Thread 1 in parent Group");
        thread1.setPriority(Thread.MAX_PRIORITY);

        Thread thread2 = new Thread(childGroup, new Task(), "Thread 2 in child group");
        thread2.setPriority(Thread.MAX_PRIORITY);

        thread1.start();
        thread2.start();

        System.out.println(parentGroup.getName() + " priority " + thread1.getPriority());
        System.out.println(childGroup.getName() + " priority " + thread2.getPriority());
    }

    static class Task implements Runnable {
        @Override
        public void run () {
            System.out.println(Thread.currentThread().getName() + " is running with priority " + Thread.currentThread().getPriority());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
