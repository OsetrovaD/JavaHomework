package lesson10.task1;

import java.util.Map;
import java.util.Set;

public final class MapTestUtil {

    private MapTestUtil() {
    }

    public static <K, V> void printMap(Map<K, V> map) {
        Set<Map.Entry<K, V>> entries = map.entrySet();
        System.out.println(entries);
    }
}