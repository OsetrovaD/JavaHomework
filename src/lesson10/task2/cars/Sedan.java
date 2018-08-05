package lesson10.task2.cars;

public class Sedan extends Car {

    public Sedan(String brand, String model, int yearOfIssue, String color, double engineCapacity, int enginePower) {
        super(brand, model, yearOfIssue, color, engineCapacity, enginePower);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return Sedan.class.getSimpleName() + super.toString();
    }
}