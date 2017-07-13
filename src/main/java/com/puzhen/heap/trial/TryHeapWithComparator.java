package com.puzhen.heap.trial;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.puzhen.median.main.InvComparitor;

public class TryHeapWithComparator {

	public static void main(String[] args) {
		Comparator<Integer> comparator = new InvComparitor();
		Queue<Integer> heap = new PriorityQueue<Integer>(comparator);
		
		heap.add(new Integer(3));
		heap.add(new Integer(9));
		heap.add(new Integer(10));
		System.out.println(heap.poll());
	}
}
