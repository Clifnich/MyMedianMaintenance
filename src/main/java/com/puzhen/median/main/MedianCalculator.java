package com.puzhen.median.main;

import java.io.*;
import java.util.*;

import org.apache.log4j.Logger;

/*
 * This class implements the Median-Maintenance algorithm.
 * By default, the Priority Queue is a MIN-Extract heap.
 */
public class MedianCalculator {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(MedianCalculator.class);
	
	private static final int MAX = 99999;
	
	/**
	 * By default, the data files are stored under testing folder
	 * @param filename
	 * @return
	 * @throws IOException 
	 */
	public List<Integer> compute(String filename) throws IOException {
		String filepath = "testing" + File.separator + filename;
		List<Integer> medians = new ArrayList<Integer>();
		File file = new File(filepath);
		BufferedReader rd = new BufferedReader(new FileReader(file));

		// heap initialization
		Queue<Integer> h_high = new PriorityQueue<Integer>();
		Queue<Integer> h_low = new PriorityQueue<Integer>(new InvComparitor());
		String line = "";
		while ((line = rd.readLine()) != null) {
			int maxOfHLow = h_low.size() > 0 ? h_low.peek().intValue() : MAX;
			int x = Integer.valueOf(line);
			if (x < maxOfHLow) {
				h_low.add(x);
			} else {
				h_high.add(x);
			}
			// balance the size of two heaps
			if (h_low.size() > h_high.size() + 1) {
				h_high.add(h_low.poll());
			}
			if (h_high.size() > h_low.size() + 1) {
				h_low.add(h_high.poll());
			}
			// computing the median and add it to the list
			if (h_low.size() == h_high.size()) {
				medians.add(new Integer(h_low.peek()));
			} else {
				medians.add(new Integer(h_low.size() > h_high.size() ? h_low.peek() : h_high.peek()));
			}
		}
		rd.close();
	
		return medians;
	}
	
	public static void main(String[] args) throws IOException {
		MedianCalculator calculator = new MedianCalculator();
		List<Integer> list = calculator.compute("median.txt");
		long result = 0;
		for (Integer i : list) 
			result += i.intValue();
		System.out.println(result % 10000);
	}
}
