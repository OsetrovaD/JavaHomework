package lesson15.util;

import lesson15.Scientist;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ScientistCompetition {

    public static void whoIsTheWinner(Scientist firstScientist, Scientist secondScientist) {
        if (firstScientist.getRobots().size() > secondScientist.getRobots().size()) {
            System.out.println("Первый учёный собрал " + firstScientist.getRobots().size() + " роботов.\n" +
                    "Второй учёный собрал " + secondScientist.getRobots().size() + " роботов.\n" +
                    "Первый учёный победил!");
        } else if (firstScientist.getRobots().size() < secondScientist.getRobots().size()) {
            System.out.println("Первый учёный собрал " + firstScientist.getRobots().size() + " роботов.\n" +
                    "Второй учёный собрал " + secondScientist.getRobots().size() + " роботов.\n" +
                    "Второй учёный победил!");
        } else {
            System.out.println("Первый учёный собрал " + firstScientist.getRobots().size() + " роботов.\n" +
                    "Второй учёный собрал " + secondScientist.getRobots().size() + " роботов.\n" +
                    "Ничья!");
        }
    }
}