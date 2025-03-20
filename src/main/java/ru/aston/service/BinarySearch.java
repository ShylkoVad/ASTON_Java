package ru.aston.service;

import java.util.List;

public class BinarySearch {
    public static int Search(List<Car> cars, Car findValue){
        int result = -1;
        int low = 0;
        int high = cars.size() - 1;
        while (low <= high){
            int mid = (low + high) / 2;
            if(findValue.age > cars.get(mid).age){
                low = mid + 1;
            } else if (findValue.age < cars.get(mid).age) {
                high = mid - 1;
            }
            else if(findValue.age == cars.get(mid).age){
                result = mid;
                break;
            }
        }

        return result;
    }
}
