package _6_ThreadScheduling.PeemptiveScheduling;

public class PreemptiveSchedulingDemo {
    public static void main(String[] args) {

    }


    static class MediumPriorityTask implements Runnable {

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " has started.");
        }
    }
}
