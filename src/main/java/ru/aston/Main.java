package ru.aston;

import ru.aston.conditionalsort.ConditionalSort;
import ru.aston.entity.Book;
import ru.aston.entity.Car;
import ru.aston.entity.RootVegetable;
import ru.aston.collection.CustomArrayList;
import ru.aston.service.BinarySearch;
import ru.aston.strategy.ListContext;
import ru.aston.strategy.ShellSort;
import ru.aston.strategy.book.BookFileFillStrategy;
import ru.aston.strategy.book.BookManualFillStrategy;
import ru.aston.strategy.book.BookRandomFillStrategy;
import ru.aston.strategy.car.CarFileFillStrategy;
import ru.aston.strategy.car.CarManualFillStrategy;
import ru.aston.strategy.car.CarRandomFillStrategy;
import ru.aston.strategy.rootvegetable.RootVegetableFileFillStrategy;
import ru.aston.strategy.rootvegetable.RootVegetableManualFillStrategy;
import ru.aston.strategy.rootvegetable.RootVegetableRandomFillStrategy;
import ru.aston.utils.ListWriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.function.Function;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {
        CustomArrayList objects = null;
        boolean running = true;
        boolean canSort = true;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (running) {
                System.out.println("Выберите тип данных:\n" +
                        "1.Автомобили\n" +
                        "2.Книги\n" +
                        "3.Корнеплоды\n" +
                        "0.Завершение работы");
                int choiceDataType = inputIntData(reader);
                if(choiceDataType > 3 || choiceDataType < 0){
                    System.out.println("Такой операции не существует");
                    continue;
                }

                if (choiceDataType == 0) {
                    running = false;
                    System.out.println("Завершение работы");
                    break;
                }

                int choiceFillStrategy = -1;
                while (choiceFillStrategy < 0 || choiceFillStrategy > 3){
                    System.out.println("Введите цифру для выбора способа ввода данных:\n" +
                            "1.Заполнить вручную.\n" +
                            "2.Заполнить из файла.\n" +
                            "3.Заполнить случайно (не более 10 элементов).\n" +
                            "0.Вернуться к выбору типа данных");
                    choiceFillStrategy = inputIntData(reader);
                    if(choiceFillStrategy < 0 || choiceFillStrategy > 3){
                        System.out.println("Такой операции не существует");
                    }
                }

                if(choiceFillStrategy == 0){
                    continue;
                }


                int size = -1;
                while (size < 1){
                    System.out.println("Введите изначальную длину массива для ввода данных:");
                    size = inputIntData(reader);
                    if(size < 1){
                        System.out.println("Некорректная длинна массива");
                        continue;
                    }

                    if(choiceFillStrategy == 3 && size > 10){
                        System.out.println("Случайным образом может быть создано не более 10 элементов");
                        size = -1;
                    }
                }

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
                        objects = vegetableContext.fillArray(size);
                        break;

                }
                while (objects != null) {
                    int choiceAction = -1;
                    while (choiceAction < 0 || choiceAction > 5){
                        System.out.println("Выберите действие:\n" +
                                "1.Сортировать данные\n" +
                                "2.Найти объект\n" +
                                "3.Записать в файл\n" +
                                "4.Вывести данные\n" +
                                "5. Сортировать по чётным полям\n" +
                                "0.Вернуться к выбору типа данных");
                        choiceAction = inputIntData(reader);
                        if(choiceAction < 0 || choiceAction > 5){
                            System.out.println("Такой операции не существует");
                        }
                    }

                    switch (choiceAction) {
                        case 1 :
                            if(canSort){
                                ShellSort.shellSortComparable(objects);
                                canSort = false;
                            }
                            System.out.println("Данные отсортированы");
                            break;
                        case 2 :
                            if(canSort){
                                int sort = -1;
                                while (sort < 1 || sort > 2){
                                    System.out.println("Для поиска объекта данные будут отсортированы, хотите продолжить?\n" +
                                            "1.Отсортировать данные и найти объект\n"+
                                            "2.Вернуться к выбору действий");
                                    sort = inputIntData(reader);
                                    if(sort < 1 || sort > 2){
                                        System.out.println("Такой операции не существует");
                                    }
                                }
                                if(sort == 2){
                                    break;
                                }
                                ShellSort.shellSortComparable(objects);
                                canSort = false;
                            }

                            int index = -1;
                            switch (choiceDataType) {
                                case 1:
                                    CustomArrayList<Car> car;
                                    ListContext<Car> carsContext = new ListContext<>();
                                    carsContext.setStrategy(new CarManualFillStrategy());
                                    car = carsContext.fillArray(1);
                                    index = BinarySearch.search(objects, car.get(0));
                                    if(index == -1){
                                        System.out.println("Данного объекта нет в списке");
                                    }else{
                                        System.out.println("Данный объект находится на " + ++index + " месте в списке");
                                    }
                                    break;
                                case 2:
                                    CustomArrayList<Book> book;
                                    ListContext<Book> booksContext = new ListContext<>();
                                    booksContext.setStrategy(new BookManualFillStrategy());
                                    book = booksContext.fillArray(1);
                                    index = BinarySearch.search(objects, book.get(0));
                                    if(index == -1){
                                        System.out.println("Данного объекта нет в списке");
                                    }else{
                                        System.out.println("Данный объект находится на " + ++index + " месте в списке");
                                    }
                                    break;
                                case 3:
                                    CustomArrayList<RootVegetable> vegetable;
                                    ListContext<RootVegetable> vegetableContext = new ListContext<>();
                                    vegetableContext.setStrategy(new RootVegetableManualFillStrategy());
                                    vegetable = vegetableContext.fillArray(1);
                                    index = BinarySearch.search(objects, vegetable.get(0));
                                    if(index == -1){
                                        System.out.println("Данного объекта нет в списке");
                                    }else{
                                        System.out.println("Данный объект находится на " + ++index + " месте в списке");
                                    }
                                    break;

                            }
                            break;
                        case 3 :
                            ListWriter writer = new ListWriter(objects);
                            writer.fileWriter();
                            System.out.println("Данные записаны в файл");
                            break;
                        case 4:
                            for (int i = 0; i < objects.size(); i++) {
                                System.out.println(objects.get(i).toString());
                            }
                            break;
                        case 5:
                            switch (choiceDataType){
                                case 1:
                                    ConditionalSort.sortByEvenField(objects,Car::getPower);
                                    break;
                                case 2:
                                    ConditionalSort.sortByEvenField(objects, (Book::getPageCount));
                                    break;
                                case 3:
                                    ConditionalSort.sortByEvenField(objects, RootVegetable::getWeight);
                                    break;
                            }
                        case 0 :
                            objects = null;
                            canSort = true;
                            break;
                    }
                }
            }
        } catch (IOException exception) {
            System.out.println("Введены не корректные данные, при вводе данных опирайтесь на шаблон.");
        }
    }

    private static int inputIntData(BufferedReader reader){
        int choiceDataType = -1;
        try{
            choiceDataType = parseInt(reader.readLine());
            return choiceDataType;
        } catch (NumberFormatException exception){
            System.out.println("Введены не корректные данные");
            return -1;
        } catch (IOException exception){
            System.out.println("Введены не корректные данные, при вводе данных опирайтесь на шаблон.");
            return -1;
        }
    }
}