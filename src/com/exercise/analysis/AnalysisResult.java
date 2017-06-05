package com.exercise.analysis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class AnalysisResult implements ListAnalysisResult {
    private List<Integer> numbers;
    private int max;
    private int mean;
    private int sum;
    private Map<Boolean, List<Integer>> oddsEvens;


    public AnalysisResult (List<Integer> numbers) {
        this.numbers = numbers;
        this.max = 0;
        this.mean = 0;
        this.sum = 0;
        this.oddsEvens = new HashMap<Boolean, List<Integer>>();
    }


    public void setMax(int max) {
        this.max = max;
    }

    public void setMean(int mean) {
        this.mean = mean;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setOddsEvens(Map<Boolean, List<Integer>> oddsEvens) {
        this.oddsEvens = oddsEvens;
    }

    public int getMaxResult() {
        return this.max;
    }

    public int getMeanResult() {
        return this.mean;
    }

    public int getSumResult() {
        return this.sum;
    }

    public Map<Boolean, List<Integer>> getOddsEvens() {
        return this.oddsEvens;
    }


    // Interface methods

    public static ListAnalysisResult analyseList (List<Integer> inputList) {
        AnalysisResult result = new AnalysisResult(inputList);

        result.setMax(result.getMax());
        result.setMean(result.getMean());
        result.setSum(result.getSum());
        result.setOddsEvens(result.oddsAndEvens());

        return result;
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
