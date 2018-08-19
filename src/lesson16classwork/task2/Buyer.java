package lesson16classwork.task2;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Buyer implements Runnable {

    private final Semaphore semaphore;
    private static final Random RANDOM = new Random();
    private static final Goods[] GOODS = Goods.values();
    private static final long TIME_FOR_ONE_BUY = 1000L;

    public Buyer(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        int numberOfGoods = RANDOM.nextInt(GOODS.length) + 1;
        try {
            semaphore.acquire();
            System.out.println(Thread.currentThread().getName() + " подошел к кассе\n");
            for (int i = 0; i < numberOfGoods; i++) {
                System.out.println(Thread.currentThread().getName() + " покупает " + GOODS[RANDOM.nextInt(GOODS.length)]);
                Thread.sleep(TIME_FOR_ONE_BUY);
            }
            System.out.println("\n" + Thread.currentThread().getName() + " покидает кассу\n");
            semaphore.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
