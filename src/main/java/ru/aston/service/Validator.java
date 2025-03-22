package ru.aston.service;

import java.util.Calendar;

public class Validator {

    public static boolean validateCarData(String model, Integer power, Integer year) {

        // Проверка модели
        if (model == null || model.isEmpty()) {
            System.err.println("Неверная модель автомобиля: " + model);
            return false;
        }

        // Проверка мощности
        if (power == null || power <= 0) {
            System.err.println("Неверная мощность автомобиля: " + power);
            return false;
        }

        // Проверка года выпуска
        if (year == null || year <= 0 || year > Calendar.getInstance().get(Calendar.YEAR)) {
            System.err.println("Неверный год выпуска автомобиля: " + year);
            return false;
        }

        return true; // Данные валидны
    }

    public static boolean validateBookData(String title, String author, Integer pageCount) {

        // Проверка названия книги
        if (title == null || title.isEmpty()) {
            System.err.println("Неверное название книги: " + title);
            return false;
        }

        // Проверка автора
        if (author == null || author.isEmpty()) {
            System.err.println("Неверный автор книги: " + author);
            return false;
        }
        if (!author.matches("^[a-zA-Zа-яА-ЯёЁ\\s]+$")) {
            System.err.println("Имя автора должно содержать только буквы: " + author);
            return false;
        }

        // Проверка количества страниц
        if (pageCount == null || pageCount <= 0) {
            System.err.println("Неверное количество страниц: " + pageCount);
            return false;
        }
        return true; // Данные валидны
    }

    public static boolean validateRootVegetableData(String type, Double weight, String color) {

        // Проверка типа корнеплода
        if (type == null || type.isEmpty()) {
            System.err.println("Неверный тип корнеплода: " + type);
            return false;
        }

        // Проверка веса корнеплода
        if (weight == null || weight <= 0) {
            System.err.println("Неверный вес корнеплода: " + weight);
            return false;
        }

        // Проверка цвета корнеплода
        if (color == null || color.isEmpty()) {
            System.err.println("Неверный цвет корнеплода: " + color);
            return false;
        }
        if (!color.matches("^[a-zA-Zа-яА-ЯёЁ\\s]+$")) {
            System.err.println("Цвет корнеплода должен содержать только буквы: " + color);
            return false;
        }

        return true; // Данные валидны
    }
}
