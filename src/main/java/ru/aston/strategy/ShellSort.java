package ru.aston.strategy;

import java.util.ArrayList;

public class ShellSort {

    public static <T extends Comparable<T>> void shellSortComparable(ArrayList<T> list) {
        if (list == null || list.isEmpty()) {
            return;
        }

        int n = list.size();
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = list.get(i);
                int j = i;
                while (j >= gap && list.get(j - gap).compareTo(temp) > 0) {
                    list.set(j, list.get(j - gap));
                    j -= gap;
                }
                list.set(j, temp);
            }
        }
    }
}