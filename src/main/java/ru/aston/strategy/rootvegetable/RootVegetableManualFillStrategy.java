package ru.aston.strategy.rootvegetable;

import ru.aston.entity.RootVegetable;
import ru.aston.collection.CustomArrayList;
import ru.aston.service.Validator;
import ru.aston.strategy.FillStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RootVegetableManualFillStrategy implements FillStrategy<RootVegetable> {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public CustomArrayList<RootVegetable> fillList(int size) {
        CustomArrayList<RootVegetable> vegetables = new CustomArrayList<>();
        try {
            for (int i = 0; i < size; i++) {
                System.out.println("Введите данные для корнеплода " + (i + 1) + ":");
                String type = null;
                Double weight = null;
                String color = null;

                // Запрос типа
                while (type == null) {
                    System.out.print("Тип: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorRootVegetable.validateRootVegetableDataType(input)) {
                        type = input;
                    }
                }

                // Запрос веса
                while (weight == null) {
                    System.out.print("Вес (кг): ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorRootVegetable.validateRootVegetableDataWeight(input)) {
                        // Если валидация успешна, преобразуем ввод в Double
                        weight = Double.parseDouble(input);
                    }
                }

                // Запрос цвета
                while (color == null) {
                    System.out.print("Цвет: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorRootVegetable.validateRootVegetableDataColor(input)) {
                        color = input;
                    }
                }
                // Добавляем новый объект RootVegetable в список
                vegetables.add(new RootVegetable(type, weight, color));
            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
        return vegetables;
    }
}