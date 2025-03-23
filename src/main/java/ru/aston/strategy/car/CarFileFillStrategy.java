package ru.aston.strategy.car;

import ru.aston.entity.Car;
import ru.aston.my_array_list.CustomArrayList;
import ru.aston.service.Validator;
import ru.aston.strategy.FillStrategy;

import java.io.*;

public class CarFileFillStrategy implements FillStrategy<Car> {
    private final String filePath;

    public CarFileFillStrategy(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public CustomArrayList<Car> fillList(int size) {
        CustomArrayList<Car> cars = new CustomArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            for (int i = 0; i < size && reader.ready(); i++) {
                String line = reader.readLine();
                String[] split = line.split(",");
                int power = Integer.parseInt(split[0].trim());
                String model = split[1].trim();
                int year = Integer.parseInt(split[2].trim());
                if (Validator.validateCarData(model, power, year)) {
                    cars.add(new Car(power, model, year));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + filePath);
        } catch (IOException ex) {
            System.out.println("Данные в файле некорректны");
        }
        return cars;
    }
}
