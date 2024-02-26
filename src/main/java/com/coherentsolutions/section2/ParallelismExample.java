package com.coherentsolutions.section2;

import java.util.Arrays;
import java.util.List;

public class ParallelismExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.parallelStream()
                .forEach(number -> System.out.println(number + " is being processed in parallel"));
    }
}

