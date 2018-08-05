package lesson10.task2;

import lesson10.task2.cars.Car;
import lesson10.task2.cars.Hatchback;
import lesson10.task2.cars.Minivan;
import lesson10.task2.cars.Sedan;
import lesson10.task2.cars.StationWagon;

public class Test {

    public static void main(String[] args) {
        Car car1 = new Hatchback("Honda", "CR-Z", 2015, "White", 1.5, 120);
        Car car2 = new Hatchback("Honda", "Jazz", 2011, "Black", 1.3, 100);
        Car car3 = new Hatchback("Citroen", "DS4", 2016, "Grey", 1.6, 150);
        Car car4 = new StationWagon("Mercedes-Benz", "CLA-Class", 2016, "Green", 2.0, 211);
        Car car5 = new StationWagon("Audi", "A6 allroad quattro", 2009, "Blue", 3.1, 255);
        Car car6 = new Sedan("Volkswagen", "Phaeton", 2016, "Silver", 6.0, 450);
        Car car7 = new Sedan("Volvo", "S60", 2018, "Green", 2.0, 190);
        Car car8 = new Minivan("Honda", "Odyssey", 2012, "Dark grey", 2.4, 173);
        Car car9 = new Minivan("Honda", "Odyssey", 2012, "Dark grey", 2.4, 173);

        Garage myGarage = new Garage();
        myGarage.parking(car1);
        myGarage.parking(car2);
        myGarage.parking(car3);
        myGarage.parking(car4);
        myGarage.parking(car5);
        myGarage.parking(car6);
        myGarage.parking(car7);
        myGarage.parking(car8);
        myGarage.parking(car9);

        myGarage.getCar(car2);
        System.out.println(myGarage.numberOfTheSameBrandCars("Honda"));
        myGarage.getCar(car8);
        System.out.println(myGarage.numberOfTheSameBrandCars("Honda"));
        System.out.println(myGarage.numberOfTheSameColorCars("Green"));
    }
}