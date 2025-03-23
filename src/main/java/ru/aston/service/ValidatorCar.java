package ru.aston.service;

import java.util.Calendar;

public class ValidatorCar {

    public static boolean validateCarDataPower(Object power) {
        // Проверка на null
        if (power == null) {
            System.err.println("Мощность не может быть null.");
            return false;
        }

        int powerValue;

        // Проверка типа и преобразование
        if (power instanceof Integer) {
            powerValue = (Integer) power;
        } else if (power instanceof String powerStr) {
            powerStr = powerStr.trim();
            if (powerStr.isEmpty()) {
                System.err.println("Мощность не может быть пустой строкой.");
                return false;
            }
            try {
                powerValue = Integer.parseInt(powerStr);
            } catch (NumberFormatException e) {
                System.err.println("Неверный ввод. Пожалуйста, введите целое число.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + power.getClass().getSimpleName());
            return false;
        }

        // Проверка значения мощности
        if (powerValue <= 0) {
            System.err.println("Неверная мощность автомобиля: " + powerValue);
            return false;
        }

        return true; // Данные валидны
    }

    public static boolean validateCarDataModel(Object model) {
        // Проверка на null
        if (model == null) {
            System.err.println("Модель не может быть null.");
            return false;
        }

        // Проверка типа и преобразование
        if (model instanceof String modelStr) {
            modelStr = modelStr.trim();
            if (modelStr.isEmpty()) {
                System.err.println("Модель не может быть пустой строкой.");
                return false;
            }

            // Регулярное выражение для проверки, является ли строка числом
            String regex = "^[+-]?\\d+(\\.\\d+)?$|^[+-]?\\d+(,\\d+)?$";
            if (modelStr.matches(regex)) {
                System.err.println("Неверный ввод. Пожалуйста, введите корректное название.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + model.getClass().getSimpleName());
            return false;
        }

        return true; // Данные валидны
    }

    public static boolean validateCarDataYear(Object year) {
        // Проверка на null
        if (year == null) {
            System.err.println("Год не может быть null.");
            return false;
        }

        int yearValue;

        // Проверка типа и преобразование
        if (year instanceof Integer) {
            yearValue = (Integer) year;
        } else if (year instanceof String yearStr) {
            yearStr = yearStr.trim();
            if (yearStr.isEmpty()) {
                System.err.println("Год не может быть пустой строкой.");
                return false;
            }
            try {
                yearValue = Integer.parseInt(yearStr);
            } catch (NumberFormatException e) {
                System.err.println("Год должен быть числом.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + year.getClass().getSimpleName());
            return false;
        }

        // Проверка года выпуска
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (yearValue <= 0 || yearValue > currentYear) {
            System.err.println("Неверный год выпуска автомобиля: " + yearValue);
            return false;
        }

        return true; // Данные валидны
    }

}