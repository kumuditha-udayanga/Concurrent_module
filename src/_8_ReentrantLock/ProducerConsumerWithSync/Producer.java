package _8_ReentrantLock.ProducerConsumerWithSync;

public class Producer implements Runnable{
    Buffer list;

    public Producer (Buffer list) {
        this.list = list;
    }

    @Override
    public void run () {
        int value = 1;
        System.out.println("Running producer");
        while (true) {
            try {
                list.produce(value);
                value++;
                Thread.sleep(500);
            }   catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
