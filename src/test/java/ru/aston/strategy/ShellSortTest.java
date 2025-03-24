package ru.aston.strategy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.aston.collection.CustomArrayList;
import ru.aston.entity.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


class ShellSortTest {

    @Test
    @DisplayName("Sorting for identical lists Book")
    void shellSortIfListEqualBook() {
        CustomArrayList<Book> booksCustomArrayList = new CustomArrayList<>();
        booksCustomArrayList.add(new Book("Peacemakers", "Margaret MacMillan", 592));
        booksCustomArrayList.add(new Book("Question 7", "Richard Flanagan", 288));
        booksCustomArrayList.add(new Book("Nuclear War: A Scenario", "Annie Jacobsen", 400));
        booksCustomArrayList.add(new Book("Revolusi:", "David Van Reybrouck", 656));

        ArrayList<Book> booksArrayList = new ArrayList<>();
        booksArrayList.add(new Book("Peacemakers", "Margaret MacMillan", 592));
        booksArrayList.add(new Book("Question 7", "Richard Flanagan", 288));
        booksArrayList.add(new Book("Nuclear War: A Scenario", "Annie Jacobsen", 400));
        booksArrayList.add(new Book("Revolusi:", "David Van Reybrouck", 656));

        for (int i = 0; i < booksCustomArrayList.size(); i++) {
            assertEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }

        ShellSort.shellSortComparable(booksCustomArrayList);
        Collections.sort(booksArrayList);

        for (int i = 0; i < booksCustomArrayList.size(); i++) {
            assertEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }
    }

    @Test
    @DisplayName("Sorting for different lists Book")
    void shellSortIfListNotEqualBook() {
        CustomArrayList<Book> booksCustomArrayList = new CustomArrayList<>();
        booksCustomArrayList.add(new Book("Question 7", "Richard Flanagan", 288));
        booksCustomArrayList.add(new Book("Peacemakers", "Margaret MacMillan", 592));
        booksCustomArrayList.add(new Book("Revolusi:", "David Van Reybrouck", 656));
        booksCustomArrayList.add(new Book("Nuclear War: A Scenario", "Annie Jacobsen", 400));

        ArrayList<Book> booksArrayList = new ArrayList<>();
        booksArrayList.add(new Book("Peacemakers", "Margaret MacMillan", 592));
        booksArrayList.add(new Book("Question 7", "Richard Flanagan", 288));
        booksArrayList.add(new Book("Nuclear War: A Scenario", "Annie Jacobsen", 400));
        booksArrayList.add(new Book("Revolusi:", "David Van Reybrouck", 656));

        for (int i = 0; i < booksArrayList.size(); i++) {
            assertNotEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }

        ShellSort.shellSortComparable(booksCustomArrayList);
        Collections.sort(booksArrayList);

        for (int i = 0; i < booksArrayList.size(); i++) {
            assertEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }

    }

    @Test
    @DisplayName("Sorting for identical lists Car")
    void shellSortIfListEqualCar() {
        CustomArrayList<Car> booksCustomArrayList = new CustomArrayList<>();
        booksCustomArrayList.add(new Car(111, "Richard Flanagan", 288));
        booksCustomArrayList.add(new Car(333, "Margaret MacMillan", 592));
        booksCustomArrayList.add(new Car(990, "David Van Reybrouck", 656));
        booksCustomArrayList.add(new Car(888, "Annie Jacobsen", 400));

        ArrayList<Car> booksArrayList = new ArrayList<>();
        booksArrayList.add(new Car(333, "Margaret MacMillan", 592));
        booksArrayList.add(new Car(111, "Richard Flanagan", 288));
        booksArrayList.add(new Car(888, "Annie Jacobsen", 400));
        booksArrayList.add(new Car(990, "David Van Reybrouck", 656));

        for (int i = 0; i < booksCustomArrayList.size(); i++) {
            assertEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }

        ShellSort.shellSortComparable(booksCustomArrayList);
        Collections.sort(booksArrayList);

        for (int i = 0; i < booksCustomArrayList.size(); i++) {
            assertEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }
    }

    @Test
    @DisplayName("Sorting for different lists Car")
    void shellSortIfListNotEqualCar() {
        CustomArrayList<Car> booksCustomArrayList = new CustomArrayList<>();
        booksCustomArrayList.add(new Car(111, "Richard Flanagan", 288));
        booksCustomArrayList.add(new Car(333, "Margaret MacMillan", 592));
        booksCustomArrayList.add(new Car(990, "David Van Reybrouck", 656));
        booksCustomArrayList.add(new Car(888, "Annie Jacobsen", 400));

        ArrayList<Car> booksArrayList = new ArrayList<>();
        booksArrayList.add(new Car(333, "Margaret MacMillan", 592));
        booksArrayList.add(new Car(111, "Richard Flanagan", 288));
        booksArrayList.add(new Car(888, "Annie Jacobsen", 400));
        booksArrayList.add(new Car(990, "David Van Reybrouck", 656));

        for (int i = 0; i < booksArrayList.size(); i++) {
            assertNotEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }

        ShellSort.shellSortComparable(booksCustomArrayList);
        Collections.sort(booksArrayList);

        for (int i = 0; i < booksArrayList.size(); i++) {
            assertEquals(booksArrayList.get(i), booksCustomArrayList.get(i));
        }

    }
}
