package ru.aston.strategy.book;

import ru.aston.entity.Book;
import ru.aston.collection.CustomArrayList;
import ru.aston.service.ValidatorBook;
import ru.aston.strategy.FillStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BookManualFillStrategy implements FillStrategy<Book> {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public CustomArrayList<Book> fillList(int size) {
        CustomArrayList<Book> books = new CustomArrayList<>();
        try {
            for (int i = 0; i < size; i++) {
                System.out.println("Введите данные для книги " + (i + 1) + ":");
                String author = null;
                String title = null;
                Integer pages = null;

                // Запрос автора с валидацией
                while (author == null) {
                    System.out.print("Автор: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorBook.validateBookDataAuthor(input)) {
                        // Если валидация успешна, преобразуем ввод в Integer
                        author = input;
                    }
                }

                // Запрос названия
                while (title == null) {
                    System.out.print("Название: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorBook.validateBookDataTitle(input)) {
                        // Если валидация успешна, преобразуем ввод в Integer
                        title = input;
                    }
                }

                // Запрос количества страниц
                while (pages == null) {
                    System.out.print("Количество страниц: ");
                    String input = reader.readLine(); // Считываем ввод

                    // Проверяем валидацию
                    if (ValidatorBook.validateBookDataPages(input)) {
                        // Если валидация успешна, преобразуем ввод в Integer
                        pages = Integer.parseInt(input);
                    }
                }
                // Добавляем новый объект Book в список
                books.add(new Book(author, title, pages));

            }
        } catch (IOException e) {
            System.out.println("Ошибка ввода/вывода: " + e.getMessage());
        }
        return books;
    }
}

