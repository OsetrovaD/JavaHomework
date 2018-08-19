package lesson18.activities;

public enum Activity implements Descriable {

    EXERCISE("Упражнения"),
    BREAK("Перерыв"),
    SOLVE_TASK("Решения"),
    DINNER("Обеденный перерыв");

    private String description;

    Activity(String description) {
        this.description = description;
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
