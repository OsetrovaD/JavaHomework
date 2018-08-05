package lesson10.task2;

import lesson10.task2.cars.Car;
import java.util.HashMap;
import java.util.Map;

public class Garage {

    private Map<Car, Integer> cars = new HashMap<>();
    private Map<String, Integer> brands = new HashMap<>();
    private Map<Integer, Integer> yearsOfIssue = new HashMap<>();
    private Map<String, Integer> colors = new HashMap<>();
    private Map<Double, Integer> enginesCapacity = new HashMap<>();
    private Map<Integer, Integer> enginesPower = new HashMap<>();

    public void parking(Car car) {
        setCarsData(cars, car);
        setCarsData(enginesPower, car.getEnginePower());
        setCarsData(brands, car.getBrand().toLowerCase());
        setCarsData(yearsOfIssue, car.getYearOfIssue());
        setCarsData(colors, car.getColor().toLowerCase());
        setCarsData(enginesCapacity, car.getEngineCapacity());
    }

    private <K> void setCarsData(Map<K, Integer> map, K key) {
        map.computeIfPresent(key, (K k, Integer value) -> value + 1);
        map.putIfAbsent(key, 1);
    }

    public void getCar(Car car) {
        deleteCarsData(cars, car);
        deleteCarsData(brands, car.getBrand().toLowerCase());
        deleteCarsData(yearsOfIssue, car.getYearOfIssue());
        deleteCarsData(colors, car.getColor().toLowerCase());
        deleteCarsData(enginesCapacity, car.getEngineCapacity());
        deleteCarsData(enginesPower, car.getEnginePower());

        System.out.println("Ваш " + car.toString() + "подан!");
    }

    private <K> void deleteCarsData(Map<K, Integer> map, K key) {
        map.computeIfPresent(key, (K k, Integer value) -> value - 1);
    }

    public int numberOfIdenticalCars(Car car) {
        return cars.get(car);
    }

    public int numberOfCarsWithTheSameYearOfIssue(int yearOfIssue) {
        return yearsOfIssue.get(yearOfIssue);
    }

    public int numberOfTheSameBrandCars(String brand) {
        return brands.get(brand.toLowerCase());
    }

    public int numberOfTheSameEngineCapacityCars(double engineCapacity) {
        return enginesCapacity.get(engineCapacity);
    }

    public int numberOfTheSameColorCars(String color) {
        return colors.get(color.toLowerCase());
    }

    public int numberOfTheSameEnginePowerCars(int enginePower) {
        return enginesPower.get(enginePower);
    }
}