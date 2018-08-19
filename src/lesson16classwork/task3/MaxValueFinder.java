package lesson16classwork.task3;

import lombok.AllArgsConstructor;
import java.util.concurrent.RecursiveTask;

@AllArgsConstructor
public class MaxValueFinder extends RecursiveTask<Integer> {

    private int[] values;
    private int threshold;
    private int startValue;
    private int endValue;

    @Override
    protected Integer compute() {
        int result;

        if ((endValue - startValue) < threshold) {
            result = findMaxValue(values, startValue, endValue);

        } else {
            int middleValue = (startValue + endValue) / 2;
            MaxValueFinder firstMaxValueFinder = new MaxValueFinder(values, threshold, startValue, middleValue);
            MaxValueFinder secondMaxValueFinder = new MaxValueFinder(values, threshold, middleValue, endValue);

            firstMaxValueFinder.fork();
            secondMaxValueFinder.fork();

            result = Math.max(firstMaxValueFinder.join(), secondMaxValueFinder.join());
        }

        return result;
    }

    private int findMaxValue(int[] values, int startValue, int endValue) {
        int result = 0;

        for (int i = startValue; i < endValue; i++) {
            if (values[i] > result) {
                result = values[i];
            }
        }

        return result;
    }
}
