package com.puzhen.heap.trial;

import java.util.*;

public class TryPriorityQueue {

	public static void main(String[] args) {
		Queue<Integer> heap = new PriorityQueue<Integer>();
		heap.add(new Integer(3));
		heap.add(new Integer(9));
		heap.add(new Integer(10));
		System.out.println(heap.poll());
	}
}
