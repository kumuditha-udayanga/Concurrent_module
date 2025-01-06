package _8_ReentrantLock.ProducerConsumerWithSync;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread producer =  new Thread(new Producer(buffer), "Producer Thread");
        Thread consumer =  new Thread(new Consumer(buffer), "Producer Thread");

        consumer.start();
        producer.start();
    }
}
