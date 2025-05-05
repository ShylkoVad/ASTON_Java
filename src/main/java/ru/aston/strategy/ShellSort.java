package ru.aston.strategy;

import ru.aston.collection.CustomArrayList;

public class ShellSort {

    public static <T extends Comparable<T>> void shellSortComparable(CustomArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            throw new IllegalArgumentException("List is null or empty");
        }

        int n = list.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = list.get(i);
                int j = i;
                while (j >= gap && list.get(j - gap).compareTo(temp) > 0) {
                    list.set(list.get(j - gap), j);
                    j -= gap;
                }
                list.set(temp, j);
            }
        }
    }
}
