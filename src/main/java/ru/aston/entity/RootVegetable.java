package ru.aston.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Comparator;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class RootVegetable implements Comparable<RootVegetable> {

    private String type;
    private Integer weight;
    private String color;

    @Override
    public int compareTo(RootVegetable other) {
        return Comparator.comparing(RootVegetable::getType)
                .thenComparing(RootVegetable::getWeight)
                .thenComparing(RootVegetable::getColor)
                .compare(this, other);
    }
}