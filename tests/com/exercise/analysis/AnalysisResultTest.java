package com.exercise.analysis;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class AnalysisResultTest {
    @Test
    void testAnalyseList () {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(15);
        arr.add(5);
        arr.add(0);
        arr.add(2);
        arr.add(18);
        arr.add(30);

        List<Integer> odds = new ArrayList<Integer>();
        odds.add(1);
        odds.add(15);
        odds.add(5);

        List<Integer> evens = new ArrayList<Integer>();
        evens.add(0);
        evens.add(2);
        evens.add(18);
        evens.add(30);

        int expectedResultMean = 10;
        int expectedResultMax = 30;
        int expectedResultSum = 71;
        Map<Boolean, List<Integer>> expectedResultOddsEvens = new HashMap<Boolean, List<Integer>>();
        expectedResultOddsEvens.put(false, odds);
        expectedResultOddsEvens.put(true, evens);

        AnalysisResult result = (AnalysisResult) AnalysisResult.analyseList(arr);


        assertEquals(expectedResultMean, result.getMeanResult());
        assertEquals(expectedResultMax, result.getMaxResult());
        assertEquals(expectedResultSum, result.getSumResult());
        assertEquals(expectedResultOddsEvens, result.getOddsEvens());
    }

    @Test
    void testGetMean () {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(0);
        arr.add(15);
        arr.add(5);

        AnalysisResult analyst = new AnalysisResult(arr);
        int expectedResult = 5;

        assertEquals(expectedResult, analyst.getMean());
    }

    @Test
    void testGetMeanNoItems () {
        List<Integer> arr = new ArrayList<Integer>();

        AnalysisResult analyst = new AnalysisResult(arr);
        int expectedResult = 0;


        assertEquals(expectedResult, analyst.getMean());
    }

    @Test
    void testGetMax () {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(0);
        arr.add(15);
        arr.add(5);

        AnalysisResult analyst = new AnalysisResult(arr);
        int expectedResult = 15;


        assertEquals(expectedResult, analyst.getMax());
    }

    @Test
    void testGetMaxNoItems () {
        List<Integer> arr = new ArrayList<Integer>();

        AnalysisResult analyst = new AnalysisResult(arr);
        int expectedResult = 0;


        assertEquals(expectedResult, analyst.getMax());
    }

    @Test
    void testGetSum () {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(0);
        arr.add(15);
        arr.add(5);

        AnalysisResult analyst = new AnalysisResult(arr);
        int expectedResult = 21;

        assertEquals(expectedResult, analyst.getSum());
    }

    @Test
    void testGetSumNoItems () {
        List<Integer> arr = new ArrayList<Integer>();

        AnalysisResult analyst = new AnalysisResult(arr);
        int expectedResult = 0;


        assertEquals(expectedResult, analyst.getSum());
    }

    @Test
    void testOddsAndEvens () {
        List<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(0);
        arr.add(7);
        arr.add(5);
        arr.add(8);

        List<Integer> odds = new ArrayList<Integer>();
        odds.add(1);
        odds.add(7);
        odds.add(5);

        List<Integer> evens = new ArrayList<Integer>();
        evens.add(0);
        evens.add(8);

        Map<Boolean, List<Integer>> expectedResult = new HashMap<Boolean, List<Integer>>();
        expectedResult.put(false, odds);
        expectedResult.put(true, evens);

        AnalysisResult analyst = new AnalysisResult(arr);


        assertEquals(expectedResult, analyst.oddsAndEvens());
    }

    @Test
    void testOddsAndEvensNoItems () {
        List<Integer> arr = new ArrayList<Integer>();
        List<Integer> odds = new ArrayList<Integer>();
        List<Integer> evens = new ArrayList<Integer>();

        Map<Boolean, List<Integer>> expectedResult = new HashMap<Boolean, List<Integer>>();
        expectedResult.put(false, odds);
        expectedResult.put(true, evens);

        AnalysisResult analyst = new AnalysisResult(arr);


        assertEquals(expectedResult, analyst.oddsAndEvens());
    }
}