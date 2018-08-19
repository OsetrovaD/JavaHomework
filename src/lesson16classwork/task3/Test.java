package lesson16classwork.task3;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Test {

    private static final Random RANDOM = new Random();
    private static final int BOUND_VALUE = 1_000_000;
    private static final int THRESHOLD = 1000;

    public static void main(String[] args) {
        int length = RANDOM.nextInt(BOUND_VALUE) + 1;
        int[] values = ArrayUtil.fillArray(ArrayUtil.createArray(length));

        ForkJoinPool tenThreads = new ForkJoinPool(10);
        ForkJoinPool oneThread = new ForkJoinPool(1);

        MaxValueFinder byTenThreads = new MaxValueFinder(values, THRESHOLD, 0, values.length);
        MaxValueFinder byOneThread = new MaxValueFinder(values, THRESHOLD, 0, values.length);


        long tenThreadsStartTime = System.nanoTime();
        int tenPoolsResult = tenThreads.invoke(byTenThreads);
        long tenThreadsFinishTime = System.nanoTime();

        long oneThreadStartTime = System.nanoTime();
        int onePoolResult = oneThread.invoke(byOneThread);
        long oneThreadFinishTime = System.nanoTime();

        System.out.println(tenPoolsResult);
        System.out.println("Время выполнения десятью потоками: " + (tenThreadsFinishTime - tenThreadsStartTime));
        System.out.println(onePoolResult);
        System.out.println("Время выполнения одним потоком: " + (oneThreadFinishTime - oneThreadStartTime));
        System.out.println(values.length);
    }
}
