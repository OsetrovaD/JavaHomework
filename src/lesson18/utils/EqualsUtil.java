package lesson18.utils;

import lesson18.activities.Activity;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EqualsUtil {

    public static boolean isWordInList(Activity[] list, String word) {
        boolean sameWord = false;
        for (Activity activity : list) {
            if (word.equals(activity.getDescription())){
                sameWord = true;
            }
        }

        return sameWord;
    }
}
