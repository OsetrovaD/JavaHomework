package lesson15;

import lesson15.robot.Detail;
import lesson15.util.ScientistCompetition;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Map<Detail, Integer> dump = new HashMap<>();

        Thread factory = new Factory(dump);
        System.out.println(dump.entrySet());

        Thread helper1 = new Helper(dump);
        Scientist firstScientist = new Scientist(helper1);
        Thread helper2 = new Helper(dump);
        Scientist secondScientist = new Scientist(helper2);

        factory.start();
        helper2.start();
        helper1.start();

        try {
            helper1.join();
            helper2.join();
            factory.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        firstScientist.makeAndCollectRobot();
        secondScientist.makeAndCollectRobot();

        ScientistCompetition.whoIsTheWinner(firstScientist, secondScientist);
    }
}
