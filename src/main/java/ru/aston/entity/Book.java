package ru.aston.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Book implements Comparable<Book> {

    private String author;
    private String title;
    private Integer pageCount;

    @Override
    public int compareTo(Book other) {
        return Comparator.comparing(Book::getAuthor)
        .thenComparing(Book::getTitle)
                .thenComparing(Book::getPageCount)
                .compare(this, other);
    }
}
