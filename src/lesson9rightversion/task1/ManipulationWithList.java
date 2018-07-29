package lesson9rightversion.task1;

import java.util.List;

public class ManipulationWithList {

    private ManipulationWithList() {
    }

    public static List<String> markLength4(List<String> list){

        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i).length() == 4){
                list.add(i, "****");
            }
        }

        return list;
    }
}
