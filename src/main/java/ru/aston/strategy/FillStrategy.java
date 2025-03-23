package ru.aston.strategy;

import ru.aston.collection.CustomArrayList;

public interface FillStrategy<T> {
    CustomArrayList<T> fillList(int size);
}
