package com.puzhen.median.main;

import java.util.*;

public class InvComparitor implements Comparator<Integer>{

	public int compare(Integer o1, Integer o2) {
		return o2.intValue() - o1.intValue();
	}

}
