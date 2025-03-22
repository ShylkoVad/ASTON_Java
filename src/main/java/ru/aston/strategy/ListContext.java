package ru.aston.strategy;

import ru.aston.my_array_list.CustomArrayList;


public class ListContext<T> {
    private FillStrategy<T> strategy;

    public void setStrategy(FillStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public CustomArrayList<T> fillArray(int size) {
        if (strategy == null) {
            throw new IllegalStateException("Стратегия не установлена");
        }
        return strategy.fillList(size);
    }
}
