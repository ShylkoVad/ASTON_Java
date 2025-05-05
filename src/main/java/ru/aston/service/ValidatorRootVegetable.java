package ru.aston.service;

public class ValidatorRootVegetable {

    public static boolean validateRootVegetableDataType(Object type) {
        // Проверка на null
        if (type == null) {
            System.err.println("Тип не может быть null.");
            return false;
        }

        // Проверка типа и преобразование
        if (type instanceof String typeStr) {
            typeStr = typeStr.trim();
            if (typeStr.isEmpty()) {
                System.err.println("Тип не может быть пустой строкой.");
                return false;
            }

            // Регулярное выражение для проверки, является ли строка числом
            String regex = "^[+-]?\\d+(\\.\\d+)?$|^[+-]?\\d+(,\\d+)?$";
            if (typeStr.matches(regex)) {
                System.err.println("Неверный ввод. Пожалуйста, введите корректное название.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + type.getClass().getSimpleName());
            return false;
        }
        return true; // Данные валидны
    }

    public static boolean validateRootVegetableDataWeight(Object weight) {
        // Проверка на null
        if (weight == null) {
            System.err.println("Вес не может быть null.");
            return false;
        }

        double weightValue;

        // Проверка типа и преобразование
        if (weight instanceof Integer) {
            weightValue = (Integer) weight;
        } else if (weight instanceof String weightStr) {
            weightStr = weightStr.trim();
            if (weightStr.isEmpty()) {
                System.err.println("Вес не может быть пустой строкой.");
                return false;
            }
            try {
                weightValue = Double.parseDouble(weightStr);
            } catch (NumberFormatException e) {
                System.err.println("Неверный ввод. Пожалуйста, введите число.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + weight.getClass().getSimpleName());
            return false;
        }

        // Проверка значения веса
        if (weightValue <= 0) {
            System.err.println("Неверный вес корнеплода: " + weightValue);
            return false;
        }

        return true; // Данные валидны
    }

    public static boolean validateRootVegetableDataColor(Object color) {
        // Проверка на null
        if (color == null) {
            System.err.println("Цвет не может быть null.");
            return false;
        }

        // Проверка типа и преобразование
        if (color instanceof String colorStr) {
            colorStr = colorStr.trim();
            if (colorStr.isEmpty()) {
                System.err.println("Цвет не может быть пустой строкой.");
                return false;
            }

            // Регулярное выражение для проверки, является ли строка числом
            String regex = "^[+-]?\\d+(\\.\\d+)?$|^[+-]?\\d+(,\\d+)?$";
            if (colorStr.matches(regex)) {
                System.err.println("Неверный ввод. Пожалуйста, введите корректный цвет.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + color.getClass().getSimpleName());
            return false;
        }
        return true; // Данные валидны
    }

}
