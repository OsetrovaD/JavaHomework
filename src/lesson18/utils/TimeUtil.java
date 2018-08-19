package lesson18.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class TimeUtil {

    private static final int MINUTES_IN_HOUR = 60;
    private static final Pattern TIME = Pattern.compile("((^\\d{2}):(\\d{2}))");

    public static List<Integer> getInterval(List<String> time) {
        List<Integer> min = timeToMinutes(time);
        List<Integer> interval = new ArrayList<>();

        for (int i = 0; i < min.size() - 1; i++) {
            interval.add(min.get(i + 1) - min.get(i));
        }
        return interval;
    }

    public static List<Integer> timeToMinutes(List<String> time) {
        List<Integer> min = new ArrayList<>();

        time.forEach(it -> {
            Matcher matcher = TIME.matcher(it);
            while (matcher.find()) {
                min.add(Integer.parseInt(matcher.group(2)) * MINUTES_IN_HOUR + Integer.parseInt(matcher.group(3)));
            }
        });

        return min;
    }
}
