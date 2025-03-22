package ru.aston.strategy.rootvegetable;

import ru.aston.entity.RootVegetable;
import ru.aston.my_array_list.CustomArrayList;
import ru.aston.strategy.FillStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RootVegetableManualFillStrategy implements FillStrategy<RootVegetable> {
    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public CustomArrayList<RootVegetable> fillList(int size) {
        CustomArrayList<RootVegetable> vegetables = new CustomArrayList<>();
        try {
            for (int i = 0; i < size; i++) {
                System.out.println("Введите данные для корнеплода " + (i + 1) + ":");
                System.out.print("Тип: ");
                String type = reader.readLine();
                System.out.print("Вес (кг): ");
                double weight = Double.parseDouble(reader.readLine());
                System.out.print("Цвет: ");
                String color = reader.readLine();
                vegetables.add(new RootVegetable(type, weight, color));
            }
        } catch (IOException e) {
            System.out.println("Введены некорректные данные");
        }
        return vegetables;
    }
}
