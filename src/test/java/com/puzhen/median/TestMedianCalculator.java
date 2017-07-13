package com.puzhen.median;

import java.io.IOException;
import java.util.List;

import com.puzhen.median.main.MedianCalculator;

import junit.framework.TestCase;

public class TestMedianCalculator extends TestCase {

	private MedianCalculator calculator;
	
	public TestMedianCalculator(String name) {
		super(name);
		calculator = new MedianCalculator();
	}
	
	/**
	 * Test that when dealing with an empty data file,
	 * the compute() method should return NULL
	 */
	public void testEmptyFile() {
		List<Integer> medians = null;
		try {
			medians = calculator.compute("empty");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException from claculator.");
		}
		assertTrue(medians.size() == 0);
	}
	
	/**
	 * Test that when dealing with a data file with only one entry
	 * the compute() method returns an array with only one value
	 */
	public void testOneEntryFile() {
		List<Integer> medians = null;
		try {
			medians = calculator.compute("oneentry");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException from claculator.");
		}
		assertEquals(3, medians.get(0).intValue());
		assertEquals(1, medians.size());
	}
	
	/**
	 * Two entries. Should be 3, 4 in an array
	 */
	public void testTwoEntries() {
		List<Integer> medians = null;
		try {
			medians = calculator.compute("twoentries");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException from claculator.");
		}
		assertEquals(3, medians.get(0).intValue());
		assertEquals(3, medians.get(1).intValue());
		assertEquals(2, medians.size());
	}
	
	/**
	 * Test 142
	 */
	public void test142() {
		MedianCalculator calculator = new MedianCalculator();
		List<Integer> list = null;
		try {
			list = calculator.compute("9335");
		} catch (IOException e) {
			e.printStackTrace();
			fail("IOException.");
		}
		long result = 0;
		for (Integer i : list) 
			result += i.intValue();
		assertEquals(9335, result % 10000);
	}
}
