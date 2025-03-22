package ru.aston.strategy;

import ru.aston.my_array_list.CustomArrayList;

public interface FillStrategy<T> {
    CustomArrayList<T> fillList(int size);
}
