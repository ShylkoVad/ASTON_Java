package ru.aston.strategy.car;

import ru.aston.entity.Car;
import ru.aston.my_array_list.CustomArrayList;
import ru.aston.service.Validator;
import ru.aston.strategy.FillStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CarManualFillStrategy implements FillStrategy<Car> {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public CustomArrayList<Car> fillList(int size) {
        CustomArrayList<Car> cars = new CustomArrayList<>();
        try {
            for (int i = 0; i < size; i++) {
                System.out.println("Введите данные для автомобиля " + (i + 1) + ":");
                System.out.print("Мощность (л.с.): ");
                int power = Integer.parseInt(reader.readLine());
                System.out.print("Модель: ");
                String model = reader.readLine();
                System.out.print("Год выпуска: ");
                int year = Integer.parseInt(reader.readLine());
                if (Validator.validateCarData(model, power, year)) {
                    cars.add(new Car(power, model, year));
                }
            }
        } catch (IOException e) {
            System.out.println("Введены некорректные данные.");
        }
        return cars;
    }
}
