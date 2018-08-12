package lesson15;

import lesson15.robot.Detail;
import lesson15.util.MapTestUtil;
import lombok.Getter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Helper extends Thread {

    private final Map<Detail, Integer> dump;
    @Getter
    private Map<Detail, Integer> details = new HashMap<>();
    private static final int NUMBER_OF_NIGHTS = 100;
    private static final int MAX_NUMBER_OF_GETTING_DETAILS = 3;

    public Helper(Map<Detail, Integer> dump) {
        this.dump = dump;
    }

    @Override
    public void run() {
        for (int j = 0; j < NUMBER_OF_NIGHTS; j++) {
            System.out.println(getName() + " проснулся");
            synchronized (dump) {
                System.out.println(MapTestUtil.sumOfValues(dump));
                System.out.println(getName() + " пришел на свалку");

                Random random = new Random();
                int numberOfGettingDetails = random.nextInt(MAX_NUMBER_OF_GETTING_DETAILS) + 1;

                if (dump.size() == 0) {
                    System.out.println(getName() + " принес 0 деталей и ждет следующей ночи");
                    System.out.println("В коллекции ученого, которому помогает " + getName() + ": " + details.entrySet());
                    System.out.println("На свалке после помощника: " + dump.entrySet());

                } else if (numberOfGettingDetails >= MapTestUtil.sumOfValues(dump)) {
                    System.out.println(getName() + " принес " + MapTestUtil.sumOfValues(dump) + " деталей и ждет");

                    dump.forEach((a, b) -> details.merge(a, b, (oldVal, newVal) -> oldVal + newVal));
                    dump.clear();

                    System.out.println("В коллекции ученого, которому помогает " + getName() + ": " + details.entrySet());
                    System.out.println("На свалке: " + dump.entrySet());
                } else {
                    for (int i = 1; i <= numberOfGettingDetails; i++) {
                        int indexOfDump = random.nextInt(Detail.values().length);

                        if (dump.containsKey(Detail.values()[indexOfDump])) {
                            details.merge(Detail.values()[indexOfDump], 1, (oldVal, newVal) -> oldVal + newVal);
                            MapTestUtil.decrementValue(dump, Detail.values()[indexOfDump]);
                        } else {
                            i--;
                        }
                    }
                    System.out.println(getName() + " принес " + numberOfGettingDetails + " деталей и ждет");
                    System.out.println("В коллекции ученого, которому помогает " + getName() + ": " + details.entrySet());
                    System.out.println("На свалке: " + dump.entrySet());
                }
                try {
                    dump.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
