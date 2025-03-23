package ru.aston.strategy.book;

import ru.aston.entity.Book;
import ru.aston.my_array_list.CustomArrayList;
import ru.aston.service.Validator;
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
                System.out.print("Автор: ");
                String author = reader.readLine();
                System.out.print("Название: ");
                String title = reader.readLine();
                System.out.print("Количество страниц: ");
                int pages = Integer.parseInt(reader.readLine());
                if (Validator.validateBookData(title, author, pages)) {
                    books.add(new Book(author, title, pages));
                }
            }
        } catch (IOException e) {
            System.out.println("Введены некорректные данные");
        }
        return books;
    }
}
