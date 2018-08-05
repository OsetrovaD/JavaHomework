package lesson10.task1;

public class Test {

    public static void main(String[] args) {
        String someText = "The man walked down the trail on a cold, gray day. Pure white snow and ice covered the Earth for as far as he could see. This was his first winter in Alaska. He was wearing heavy clothes and fur boots. But he still felt cold and uncomfortable.\n" +
                "The man was on his way to a camp near Henderson Creek. His friends were already there. He expected to reach Henderson Creek by six o'clock that evening. It would be dark by then. His friends would have a fire and hot food ready for him.\n" +
                "A dog walked behind the man. It was a big gray animal, half dog and half wolf. The dog did not like the extreme cold. It knew the weather was too cold to travel.";

        MapTestUtil.printMap(WordsRepeat.wordCounter(someText));
    }
}