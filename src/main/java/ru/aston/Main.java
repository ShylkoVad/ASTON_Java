package ru.aston;

import ru.aston.entity.Book;
import ru.aston.entity.Car;
import ru.aston.entity.RootVegetable;
import ru.aston.my_array_list.CustomArrayList;
import ru.aston.strategy.ListContext;
import ru.aston.strategy.book.BookFileFillStrategy;
import ru.aston.strategy.book.BookManualFillStrategy;
import ru.aston.strategy.book.BookRandomFillStrategy;
import ru.aston.strategy.car.CarFileFillStrategy;
import ru.aston.strategy.car.CarManualFillStrategy;
import ru.aston.strategy.car.CarRandomFillStrategy;
import ru.aston.strategy.rootvegetable.RootVegetableFileFillStrategy;
import ru.aston.strategy.rootvegetable.RootVegetableManualFillStrategy;
import ru.aston.strategy.rootvegetable.RootVegetableRandomFillStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {
        CustomArrayList<?> objects = null;
        boolean running = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (running) {

                System.out.println("Введите изначальную длину массива для ввода данных:\n" +
                        "Введите 0 для завершения работы");
                int size = parseInt(reader.readLine());
                if (size == 0) {
                    running = false;
                    System.out.println("Завершение работы");
                    break;
                }

                System.out.println("Выберите тип данных:\n" +
                        "1.Автомобили\n" +
                        "2.Книги\n" +
                        "3.Корнеплоды");
                int choiceDataType = parseInt(reader.readLine());

                System.out.println("Введите цифру для выбора способа ввода данных:\n" +
                        "1.Заполнить вручную.\n" +
                        "2.Заполнить из файла.\n" +
                        "3.Заполнить случайно.");
                int choiceFillStrategy = parseInt(reader.readLine());

                switch (choiceDataType) {
                    case 1:
                        ListContext<Car> carsContext = new ListContext<>();
                        if (choiceFillStrategy == 1) {
                            carsContext.setStrategy(new CarManualFillStrategy());
                        } else if (choiceFillStrategy == 2) {
                            System.out.println("Укажите путь к файлу:");
                            String filePath = reader.readLine();
                            carsContext.setStrategy(new CarFileFillStrategy(filePath));
                        } else if (choiceFillStrategy == 3) {
                            carsContext.setStrategy(new CarRandomFillStrategy());
                        }
                        objects = carsContext.fillArray(size);
                        break;
                    case 2:
                        ListContext<Book> booksContext = new ListContext<>();
                        if (choiceFillStrategy == 1) {
                            booksContext.setStrategy(new BookManualFillStrategy());
                        } else if (choiceFillStrategy == 2) {
                            System.out.println("Укажите путь к файлу:");
                            String filePath = reader.readLine();
                            booksContext.setStrategy(new BookFileFillStrategy(filePath));
                        } else if (choiceFillStrategy == 3) {
                            booksContext.setStrategy(new BookRandomFillStrategy());
                        }
                        objects = booksContext.fillArray(size);
                        break;
                    case 3:
                        ListContext<RootVegetable> vegetableContext = new ListContext<>();
                        if (choiceFillStrategy == 1) {
                            vegetableContext.setStrategy(new RootVegetableManualFillStrategy());
                        } else if (choiceFillStrategy == 2) {
                            System.out.println("Укажите путь к файлу:");
                            String filePath = reader.readLine();
                            vegetableContext.setStrategy(new RootVegetableFileFillStrategy(filePath));
                        } else if (choiceFillStrategy == 3) {
                            vegetableContext.setStrategy(new RootVegetableRandomFillStrategy());
                        }
                        vegetableContext.fillArray(size);
                        break;

                }
                while (objects != null) {
                    System.out.println("Выберите действие:\n" +
                            "1.Сортировать данные\n" +
                            "2.Найти объект\n" +
                            "3.Записать в файл\n" +
                            "4.Вывести данные\n" +
                            "0.Вернуться к выбору типа данных");
                    int choiceAction = parseInt(reader.readLine());

                    switch (choiceAction) {
                        case 1 :
                            break;
                        case 2 :
                            break;
                        case 3 :
                            break;
                        case 4:
                            for (int i = 0; i < objects.size(); i++) {
                                System.out.println(objects.get(i).toString());
                            }
                            break;
                        case 0 :
                            objects = null;
                            break;
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Введены не корректные данные, при вводе данных опирайтесь на шаблон.");
        }
    }

}