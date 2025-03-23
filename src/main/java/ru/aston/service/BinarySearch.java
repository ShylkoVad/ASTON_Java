package ru.aston.service;

public class BinarySearch<T extends Comparable> {
    public int Search(MyArrayList<T> objects, T findValue){
        int result = -1;
        int low = 0;
        int high = objects.size() - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            int compare = findValue.compareTo(objects.get(mid));
            if(compare > 0){
                low = mid + 1;
            } else if (compare < 0) {
                high = mid - 1;
            }
            else {
                result = mid;
                break;
            }
        }

        return result;
    }
}
