package lesson18.utils;

import lesson18.activities.Activity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScheduleUtil {

    private static final Pattern TIME = Pattern.compile("(^\\d{2}:\\d{2})");
    private static final Pattern ACTIVITY = Pattern.compile("[А-Я][а-я ]+$");
    private static final String END = "Конец";
    private static final String LECTURE = "Лекции";
    private static final Activity[] ACTIVITIES = Activity.values();
    private static final int PER_CENT = 100;
    private static int j = 1;
    private static int k = 0;

    public static void createScheduleWithIntervals(Path path) {
        Path newFilePath = Paths.get("src", "lesson18", "scheduleWithInterval.txt");
        try {
            List<List<String>> daysSchedule = replaceAllTimeByInterval(parseScheduleToDays(Files.readAllLines(path),
                    createListOfDaysSchedule(daysCounter(Files.readAllLines(path)))));

            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFilePath.toFile()))) {
                for (List<String> strings : daysSchedule) {
                    for (String string : strings) {
                        bufferedWriter.write(string);
                        bufferedWriter.newLine();
                    }
                    bufferedWriter.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createStatistic(Path path) {
        Path newFilePath = Paths.get("src", "lesson18", "scheduleStatistic.txt");
        try {
            List<List<String>> lists = parseScheduleToDays(Files.readAllLines(path),
                    createListOfDaysSchedule(daysCounter(Files.readAllLines(path))));
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(newFilePath.toFile()))) {
                for (List<String> strings : lists) {
                    Map<String, Integer> activitiesWithIntervals = countActivityTime(strings);
                    List<Double> perCent = activitiesTimeInPerCent(activitiesWithIntervals, TimeUtil.timeToMinutes(getTimeFromSchedule(strings)));
                    Set<String> acts = activitiesWithIntervals.keySet();

                    for (String act : acts) {
                        if (EqualsUtil.isWordInList(ACTIVITIES, act) || act.equals(LECTURE)) {
                            bufferedWriter.write(act + ": " + activitiesWithIntervals.get(act)
                                    + " минут " + perCent.get(k) + "%");
                            bufferedWriter.newLine();
                            k++;
                        } else {
                            k++;
                        }
                    }
                    bufferedWriter.write("Лекции:");
                    bufferedWriter.newLine();
                    k = 0;
                    for (String act : acts) {
                        if (!EqualsUtil.isWordInList(ACTIVITIES, act) && !act.equals(LECTURE)) {
                            bufferedWriter.write(act + ": " + activitiesWithIntervals.get(act)
                                    + " минут " + perCent.get(k) + "%");
                            bufferedWriter.newLine();
                            k++;
                        } else {
                            k++;
                        }
                    }
                    bufferedWriter.newLine();
                    k = 0;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Double> activitiesTimeInPerCent(Map<String, Integer> activitiesWithIntervals, List<Integer> activityTime) {
        List<Integer> values = new ArrayList<>(activitiesWithIntervals.values());
        List<Double> perCent = new ArrayList<>();
        Integer allTime = activityTime.get(activityTime.size() - 1) - activityTime.get(0);
        values.forEach(e -> {
            double temp = ((double) e / allTime) * PER_CENT;
            double v = new BigDecimal(temp).setScale(2, RoundingMode.HALF_UP).doubleValue();
            perCent.add(v);

        });

        return perCent;
    }

    private static Map<String, Integer> countActivityTime(List<String> daySchedule) {
        List<Integer> intervals = TimeUtil.getInterval(getTimeFromSchedule(daySchedule));
        List<String> activ = getActivityFromSchedule(daySchedule);
        Map<String, Integer> commonTime = new HashMap<>();

        activ.forEach(e -> {
            if (k == activ.size() - 1 || e.equals(END)) {
                k = -1;
            } else if (EqualsUtil.isWordInList(ACTIVITIES, e)) {
                commonTime.merge(e, intervals.get(k), (oldVal, newVal) -> oldVal + newVal);
            } else {
                commonTime.merge(LECTURE, intervals.get(k), (oldVal, newVal) -> oldVal + newVal);
                commonTime.merge(e, intervals.get(k), (oldVal, newVal) -> oldVal + newVal);
            }
            k++;
        });
        return commonTime;
    }

    private static List<List<String>> replaceAllTimeByInterval(List<List<String>> schedule) {
        for (int i = 0; i < schedule.size(); i++) {
            schedule.set(i, replaceTimeByInterval(schedule.get(i), getTimeFromSchedule(schedule.get(i))));
        }
        return schedule;
    }

    private static List<String> getTimeFromSchedule(List<String> schedule) {
        return schedule.stream()
                .map(it -> {
                    Matcher matcher = TIME.matcher(it);
                    String st = "";
                    while (matcher.find()) {
                        st = matcher.group();
                    }
                    return st;
                })
                .collect(Collectors.toList());
    }

    private static List<String> getActivityFromSchedule(List<String> schedule) {
        return schedule.stream()
                .map(it -> {
                    Matcher matcher = ACTIVITY.matcher(it);
                    String st = "";
                    while (matcher.find()) {
                        st = matcher.group();
                    }
                    return st;
                })
                .collect(Collectors.toList());
    }

    private static List<String> replaceTimeByInterval(List<String> schedule, List<String> time) {
        List<String> collect = schedule.stream()
                .map(e -> {
                    Matcher matcher = TIME.matcher(e);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (matcher.find()) {
                        if (j != time.size()) {
                            matcher.appendReplacement(stringBuffer, "$1-" + time.get(j));
                            j++;
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    return stringBuffer.toString();
                })
                .collect(Collectors.toList());
        j = 1;
        return collect;
    }

    private static int daysCounter(List<String> schedule) {
        int numberOfDays = 1;
        for (String s : schedule) {
            if (s.isEmpty()) {
                numberOfDays++;
            }
        }
        return numberOfDays;
    }

    private static List<List<String>> createListOfDaysSchedule(int numberOfDays) {
        List<List<String>> daysSchedule = new ArrayList<>();
        for (int i = 0; i < numberOfDays; i++) {
            daysSchedule.add(new ArrayList<>());
        }
        return daysSchedule;
    }

    private static List<List<String>> parseScheduleToDays(List<String> fullSchedule, List<List<String>> emptyDaysSchedule) {
        int indexEmptyDaysSchedule = 0;

        for (int i = 0; i < fullSchedule.size(); i++) {
            if (fullSchedule.get(i).isEmpty()) {
                indexEmptyDaysSchedule++;
                i++;
            }
            emptyDaysSchedule.get(indexEmptyDaysSchedule).add(fullSchedule.get(i));
        }

        return emptyDaysSchedule;
    }
}
