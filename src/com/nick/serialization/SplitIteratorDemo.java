package com.nick.serialization;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

public class SplitIteratorDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6);
		Spliterator<Integer> splt1 = list.spliterator();
		Spliterator<Integer> splt2 = splt1.trySplit();
		
		splt1.forEachRemaining(System.out::print);	
		System.out.print(" ");
		splt2.forEachRemaining(System.out::print);
	}

}
