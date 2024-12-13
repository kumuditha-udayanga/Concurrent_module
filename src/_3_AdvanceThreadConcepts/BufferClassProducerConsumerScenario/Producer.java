package _3_AdvanceThreadConcepts.BufferClassProducerConsumerScenario;

public class Producer implements Runnable{
    private Buffer buffer;
    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }
    @Override
    public void run(){
        int value = 0;
        while (true) {
            try {
                buffer.produce(value);
                value++;
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
