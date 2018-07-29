package lesson9.task1;

import java.util.ArrayList;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {
        List<String> testList = new ArrayList<>();
        testList.add("this");
        testList.add("is");
        testList.add("lots");
        testList.add("of");
        testList.add("fun");
        testList.add("for");
        testList.add("every");
        testList.add("Java");
        testList.add("programmer");

        System.out.println(ManipulationWithList.markLength4(testList).toString());

    }
}
