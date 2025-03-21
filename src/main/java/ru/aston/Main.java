package ru.aston;

import ru.aston.service.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        Car a = new Car(1);
        Car a1 = new Car(3);
        Car a2 = new Car(6);
        Car a3 = new Car(8);
        Car a4 = new Car(10);
        Car a5 = new Car(14);
        Car a6 = new Car(22);
        Car a7 = new Car(25);
        Car a8 = new Car(30);
        cars.add(a);
        cars.add(a1);
        cars.add(a2);
        cars.add(a3);
        cars.add(a4);
        cars.add(a5);
        cars.add(a6);
        cars.add(a7);
        cars.add(a8);
        int index = BinarySearch.Search(cars, a5);
        System.out.println(index);
    }
}