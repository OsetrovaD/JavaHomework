package lesson15;

import lesson15.robot.Detail;
import java.util.Map;
import java.util.Random;

public class Factory extends Thread {

    private static final int MAX_NUMBER_OF_PRODUCING_DETAILS = 3;
    private static final int NUMBER_OF_DETAILS_AT_THE_BEGINNING = 20;
    private static final long ONE_DAY = 100L;
    private static final int NUMBER_OF_NIGHTS = 100;
    private final Map<Detail, Integer> dump;

    public Factory(Map<Detail, Integer> dump) {
        this.dump = dump;
        throwOutFirstTwentyDetails();
    }

    private void throwOutDetail(int numberOfDetails) {
        for (int i = 1; i <= numberOfDetails; i++) {
            produceDetail();
        }
    }

    private void throwOutFirstTwentyDetails() {
        for (int i = 1; i <= NUMBER_OF_DETAILS_AT_THE_BEGINNING; i++) {
            produceDetail();
        }
    }

    private void produceDetail() {
        Random random = new Random();
        int numberOfDetail = random.nextInt(Detail.values().length);
        dump.merge(Detail.values()[numberOfDetail], 1, (oldVal, newVal) -> oldVal + newVal);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(ONE_DAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < NUMBER_OF_NIGHTS; i++) {
            synchronized (dump) {
                try {
                    System.out.println("Завод начал производство");
                    Random random = new Random();
                    int number = random.nextInt(MAX_NUMBER_OF_PRODUCING_DETAILS) + 1;
                    throwOutDetail(number);
                    System.out.println("Завод выкинул на свалку " + number + " деталей");
                    System.out.println("На свалке: " + dump.entrySet());
                    dump.notifyAll();
                    dump.wait(100L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
