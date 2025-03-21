package ru.aston;

import ru.aston.entity.*;
import ru.aston.strategy.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Sergei", "War", 500));
        books.add(new Book("Tat", "Life", 300));
        books.add(new Book("Rom", "Book", 100));
        books.add(new Book("Viktor", "There", 130));

        System.out.println("Before sorting Books:");
        System.out.println(books);

        ShellSort.shellSortComparable(books);

        System.out.println("After sorting Books:");
        System.out.println(books);


        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car(580, "Lamborghini Murciélago", 2010));
        cars.add(new Car(324, "Ferrari F40 ", 1987));
        cars.add(new Car(400, "Porsche 911", 1963));
        cars.add(new Car(90, "LADA 112", 2008));

        System.out.println("Before sorting Cars:");
        System.out.println(cars);

        ShellSort.shellSortComparable(cars);

        System.out.println("After sorting Cars:");
        System.out.println(cars);

    }
}