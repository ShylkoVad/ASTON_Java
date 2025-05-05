package ru.aston.service;

public class ValidatorBook {

    public static boolean validateBookDataAuthor(Object author) {
        // Проверка на null
        if (author == null) {
            System.err.println("Автор не может быть null.");
            return false;
        }

        // Проверка типа и преобразование
        if (author instanceof String authorStr) {
            authorStr = authorStr.trim();
            if (authorStr.isEmpty()) {
                System.err.println("Автор не может быть пустой строкой.");
                return false;
            }

            // Регулярное выражение для проверки, что имя состоит из двух и более слов, начинающихся с заглавной буквы
            String regexWords = "^(?:(?:[А-ЯЁ][а-яё]+(?:\\s+|\\-\\s*)+)|(?:[A-Z][a-z]+(?:\\s+|\\-\\s*))+){1,}(?:[А-ЯЁ][а-яё]+|[A-Z][a-z]+)$";
            if (!authorStr.matches(regexWords)) {
                System.err.println("Имя автора должно состоять как минимум из двух слов, каждое из которых начинается с заглавной буквы.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + author.getClass().getSimpleName());
            return false;
        }
        return true; // Данные валидны
    }

    public static boolean validateBookDataTitle(Object title) {
        // Проверка на null
        if (title == null) {
            System.err.println("Название не может быть null.");
            return false;
        }

        // Проверка типа и преобразование
        if (title instanceof String titleStr) {
            titleStr = titleStr.trim();
            if (titleStr.isEmpty()) {
                System.err.println("Название не может быть пустой строкой.");
                return false;
            }
        }
        return true; // Данные валидны
    }

    public static boolean validateBookDataPages(Object pages) {
        // Проверка на null
        if (pages == null) {
            System.err.println("Количество страниц не может быть null.");
            return false;
        }

        int powerValue;

        // Проверка типа и преобразование
        if (pages instanceof Integer) {
            powerValue = (Integer) pages;
        } else if (pages instanceof String pagesStr) {
            pagesStr = pagesStr.trim();
            if (pagesStr.isEmpty()) {
                System.err.println("Количество страниц не может быть пустой строкой.");
                return false;
            }
            try {
                powerValue = Integer.parseInt(pagesStr);
            } catch (NumberFormatException e) {
                System.err.println("Неверный ввод. Пожалуйста, введите целое число.");
                return false;
            }
        } else {
            System.err.println("Неверный тип данных: " + pages.getClass().getSimpleName());
            return false;
        }

        // Проверка значения мощности
        if (powerValue <= 0) {
            System.err.println("Неверное количество страниц: " + powerValue);
            return false;
        }
        return true; // Данные валидны
    }
}