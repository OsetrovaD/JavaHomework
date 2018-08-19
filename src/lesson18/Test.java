package lesson18;

import lesson18.utils.ScheduleUtil;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {

    private static int k = 0;

    public static void main(String[] args) {
        Path schedule = Paths.get("src", "lesson18", "schedule.txt");

        ScheduleUtil.createStatistic(schedule);
        ScheduleUtil.createScheduleWithIntervals(schedule);
    }
}
