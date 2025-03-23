package ru.aston.strategy.car;

import ru.aston.entity.Car;
import ru.aston.collection.CustomArrayList;
import ru.aston.service.ValidatorCar;
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
                Integer power = null;
                String model = null;
                Integer year = null;

                // Запрос мощности с валидацией
                while (power == null) {
                    System.out.print("Мощность (л.с.): ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorCar.validateCarDataPower(input)) {
                        // Если валидация успешна, преобразуем ввод в Integer
                        power = Integer.parseInt(input);
                    }
                }

                // Запрос модели
                while (model == null) {
                    System.out.print("Модель: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorCar.validateCarDataModel(input)) {
                        model = input;
                    }
                }

                // Запрос года выпуска
                while (year == null) {
                    System.out.print("Год выпуска: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorCar.validateCarDataYear(input)) {
                        // Если валидация успешна, преобразуем ввод в Integer
                        year = Integer.parseInt(input);
                    }
                }
                // Добавляем новый объект Car в список
                cars.add(new Car(power, model, year));
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
        return cars;
    }
}
