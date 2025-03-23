package ru.aston.strategy.book;

import ru.aston.entity.Book;
import ru.aston.collection.CustomArrayList;
import ru.aston.service.Validator;
import ru.aston.strategy.FillStrategy;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BookFileFillStrategy implements FillStrategy<Book> {
    private final String filePath;

    public BookFileFillStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public CustomArrayList<Book> fillList(int size) {
        CustomArrayList<Book> books = new CustomArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < size; i++) {
                String line = reader.readLine();
                String[] split = line.split(",");
                String author = split[0].trim();
                String title = split[1].trim();
                int pages = Integer.parseInt(split[2].trim());
                if (Validator.validateBookData(title, author, pages)) {
                    books.add(new Book(author, title, pages));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        } catch (IOException ex) {
            System.out.println("Данные в файле некорректны");
        }
        return books;
    }
}
