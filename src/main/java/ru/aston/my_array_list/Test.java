package ru.aston.my_array_list;

import ru.aston.entity.Book;
import ru.aston.entity.Car;

public class Test {
    public static void main(String[] args) {
        CustomArrayList<Car> list = new CustomArrayList<>();
        CustomArrayList<Car> list1 = new CustomArrayList<>(15);
        Car car1  = new Car(1000, "bmw", 2007);
        Car car2  = new Car(950, "mersedec", 2003);
        Car car3  = new Car(300, "audi", 1994);
        Car car4  = new Car(800, "chevrolett", 1989);
        Car car5  = new Car(1000, "porsche", 2017);
        Car car6 = new Car(256,"jdj",2020);
        Book book = new Book();
        list.add(car1);
        list.add(car2);
        list.add(car3);
        list.add(car4);
        list.add(car5);
//        list.add(book);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        list.set(car6, 3);
        System.out.println(list.get(3));
        list.remove(2);
        System.out.println(list.get(2));
        for (int i = 0; i < 5; i++){
            System.out.println(list.get(i));
        }


    }
}
