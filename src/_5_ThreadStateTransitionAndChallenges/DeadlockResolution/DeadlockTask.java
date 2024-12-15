package _5_ThreadStateTransitionAndChallenges.DeadlockResolution;

public class DeadlockTask implements Runnable{
    private Object firstResource;
    private Object secondResource;

    public DeadlockTask (Object firstResource, Object secondResource) {
        this.firstResource = firstResource;
        this.secondResource = secondResource;
    }


    @Override
    public void run() {
        synchronized (firstResource) {
            System.out.println(Thread.currentThread().getName() + " locked " + firstResource);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (secondResource) {
                System.out.println(Thread.currentThread().getName() + " locked " + secondResource);
            }
        }
    }
}
