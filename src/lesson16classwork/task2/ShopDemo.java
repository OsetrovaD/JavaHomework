package lesson16classwork.task2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ShopDemo {

    private static final int NUMBER_OF_CASH_DESKS = 5;
    private static final int NUMBER_OF_BUYERS = 15;

    public static void main(String[] args) {
        Semaphore cashDesk = new Semaphore(NUMBER_OF_CASH_DESKS);

        ExecutorService executorService = Executors.newFixedThreadPool(NUMBER_OF_BUYERS);
        for (int i = 0; i < NUMBER_OF_BUYERS; i++) {
            executorService.execute(new Buyer(cashDesk));
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1L, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
