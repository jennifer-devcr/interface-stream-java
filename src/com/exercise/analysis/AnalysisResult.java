package com.exercise.analysis;

import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class AnalysisResult implements ListAnalysisResult {
    List<Integer> numbers;

    public AnalysisResult (List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void analyseList (List<Integer> inputList) {
        this.numbers = inputList;

        System.out.println("Mean number: " + getMean());
        System.out.println("Max number: " + getMax());
        System.out.println("Sum: " + getSum());
        System.out.println("Map Odds and Evens: " + oddsAndEvens().toString());
    }

    public int getMean () {
        return (int) this.numbers.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    public int getMax () {
        return this.numbers.stream()
                .max(Integer::compare)
                .orElse(0);
    }

    public int getSum () {
        return this.numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public Map<Boolean, List<Integer>> oddsAndEvens () {
        return this.numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
    }
}
