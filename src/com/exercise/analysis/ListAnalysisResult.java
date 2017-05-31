package com.exercise.analysis;

import java.util.List;
import java.util.Map;

public interface ListAnalysisResult {
    int getMean();
    int getMax();
    int getSum();
    Map<Boolean, List<Integer>> oddsAndEvens();
}
