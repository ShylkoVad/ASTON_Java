package ru.aston.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Car implements Comparable<Car> {

    private Integer power;
    private String model;
    private Integer year;

    @Override
    public int compareTo(Car other) {
        return Comparator.comparing(Car::getPower)
                .thenComparing(Car::getModel)
                .thenComparing(Car::getYear)
                .compare(this, other);
    }
}
