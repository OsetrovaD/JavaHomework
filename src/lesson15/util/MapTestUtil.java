package lesson15.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MapTestUtil {

    public static <K> int sumOfValues(Map<K, Integer> map) {
        List<Integer> values = new ArrayList<>(map.values());
        int sum = 0;
        for (Integer value : values) {
            sum += value;
        }
        return sum;
    }

    public static <K> void decrementValue(Map<K, Integer> map, K key) {
        if (map.get(key) > 1) {
            map.replace(key, map.get(key), map.get(key) - 1);
        } else if (map.get(key) == 1) {
            map.remove(key);
        }
    }

    public static <K> void decrementAllValues(Map<K, Integer> map) {
        map.keySet().removeIf(detail -> map.get(detail) == 1);
        for (K detail : map.keySet()) {
            map.replace(detail, map.get(detail), map.get(detail) - 1);
        }
    }
}