package lesson10.task2.cars;

import java.util.Objects;

public abstract class Car {

    private String brand;
    private String model;
    private int yearOfIssue;
    private String color;
    private double engineCapacity;
    private int enginePower;

    public Car(String brand, String model, int yearOfIssue, String color, double engineCapacity, int enginePower) {
        this.brand = brand;
        this.model = model;
        this.yearOfIssue = yearOfIssue;
        this.color = color;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfIssue == car.yearOfIssue &&
                Double.compare(car.engineCapacity, engineCapacity) == 0 &&
                enginePower == car.enginePower &&
                Objects.equals(brand, car.brand) &&
                Objects.equals(model, car.model) &&
                Objects.equals(color, car.color);
    }

    @Override
    public int hashCode() {

        return Objects.hash(brand, model, yearOfIssue, color, engineCapacity, enginePower);
    }

    @Override
    public String toString() {
        return "{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfIssue=" + yearOfIssue +
                ", color='" + color + '\'' +
                ", engineCapacity=" + engineCapacity +
                ", enginePower=" + enginePower +
                '}';
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfIssue() {
        return yearOfIssue;
    }

    public String getColor() {
        return color;
    }

    public double getEngineCapacity() {
        return engineCapacity;
    }

    public int getEnginePower() {
        return enginePower;
    }
}