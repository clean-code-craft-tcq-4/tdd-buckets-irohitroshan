package com.cleancode.tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReadingCounter {
    int arr[] = {3, 3, 5, 4, 10, 11, 12};

    public Map<String, String> readingCountOfGivenRange(int rangeStart, int rangeEnd) {
        HashMap<String, String> rangeReading =
                new HashMap();
        long readings = 0;
        List<Integer> intArr = IntStream.of(arr).boxed().collect(Collectors.toList());

        if (intArr.contains(rangeStart) && intArr.contains(rangeEnd)) {
            for (int i = rangeStart; i <=rangeEnd; i++) {
                if (intArr.contains(i)) {
                    int finalI = i;
                    long varCount = intArr.stream().filter(x-> x.equals(finalI)).count();
                    readings= readings+varCount;
                }else {
                    rangeReading.put(rangeStart + "-" + rangeEnd, "Invalid Range");
                    return rangeReading;
                }

            }
            rangeReading.put(rangeStart + "-" + rangeEnd, String.valueOf(readings));
            System.out.println(rangeReading);
            return rangeReading;
        }
        rangeReading.put(rangeStart + "-" + rangeEnd, "Array does not contain given input");
        return rangeReading;

    }

}
