package ru.aston.conditionalsort;

import ru.aston.collection.CustomArrayList;
import ru.aston.collection.CustomHashMap;

public class ConditionalSort {
      public static <T> void sortByEvenField(CustomArrayList<T> list, java.util.function.Function<T, Integer> fieldExtractor) {
        CustomHashMap<Integer, T> evenMap = new CustomHashMap<>();
        int evenCount = 0;


        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            Integer value = fieldExtractor.apply(item);
            if (value % 2 == 0) {
                evenMap.put(evenCount++, item);
            }
        }


        T[] sortedEvens = (T[]) new Object[evenCount];


        for (int i = 0; i < evenCount; i++) {
            sortedEvens[i] = evenMap.get(i);
        }


          shellSort(sortedEvens, fieldExtractor);


        evenCount = 0;
        for (int i = 0; i < list.size(); i++) {
            T item = list.get(i);
            Integer value = fieldExtractor.apply(item);
            if (value % 2 == 0) {
                list.set(sortedEvens[evenCount++], i);
            }
        }
    }
    private static <T> void shellSort(T[] array, java.util.function.Function<T, Integer> fieldExtractor) {
        int n = array.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = array[i];
                int j;
                for (j = i; j >= gap && fieldExtractor.apply(array[j - gap]) > fieldExtractor.apply(temp); j -= gap) {
                    array[j] = array[j - gap];
                }
                array[j] = temp;
            }
        }
    }
}
