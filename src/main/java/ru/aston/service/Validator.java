package ru.aston.service;

public class Validator {

    public static boolean validateCarData(String model, Integer power, Integer year) {
        if (model == null || model.isEmpty()) {
            System.err.println("Неверная модель автомобиля: " + model);
            return false;
        }
        if (power == null || power <= 0) {
            System.err.println("Неверная мощность автомобиля: " + power);
            return false;
        }
        if (year == null || year <= 1885) {
            System.err.println("Неверный год выпуска автомобиля: " + year);
            return false;
        }
        return true; // Данные валидны
    }

    public static boolean validateBookData(String title, String author, Integer pageCount) {
        if (title == null || title.isEmpty()) {
            System.err.println("Неверное название книги: " + title);
            return false;
        }
        if (author == null || author.isEmpty()) {
            System.err.println("Неверный автор книги: " + author);
            return false;
        }
        if (pageCount == null || pageCount <= 0) {
            System.err.println("Неверное количество страниц: " + pageCount);
            return false;
        }
        return true; // Данные валидны
    }

    public static boolean validateRootVegetableData(String type, Double weight, String color) {
        if (type == null || type.isEmpty()) {
            System.err.println("Неверный тип корнеплода: " + type);
            return false;
        }
        if (weight == null || weight <= 0) {
            System.err.println("Неверный вес корнеплода: " + weight);
            return false;
        }
        if (color == null || color.isEmpty()) {
            System.err.println("Неверный цвет корнеплода: " + color);
            return false;
        }
        return true; // Данные валидны
    }
}
