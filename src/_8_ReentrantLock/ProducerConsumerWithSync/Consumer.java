package _8_ReentrantLock.ProducerConsumerWithSync;

public class Consumer implements Runnable {
    Buffer list;

    public Consumer (Buffer list) {
        this.list = list;
    }

    @Override
    public void run () {
        while (true) {
            try {
                list.consume();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
