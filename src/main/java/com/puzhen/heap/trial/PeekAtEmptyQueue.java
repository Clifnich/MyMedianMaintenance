package com.puzhen.heap.trial;

import java.util.PriorityQueue;
import java.util.Queue;

public class PeekAtEmptyQueue {

	public static void main(String[] args) {
		Queue<Integer> queue = new PriorityQueue<Integer>();
		int i = queue.peek();
		System.out.println("Peeking at an empty queue: [" + i + "].");
	}
}
