package com.nick.collection;

import java.util.*;
import java.util.stream.Collectors;

public class StreamDemo {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(5,8,3,4,2,1,0,5);

		System.out.println("Count:"+list.stream().count());

		System.out.println("\nDuplicate Remove");
		list.stream().distinct().forEach(System.out::println);

		System.out.println("\nSum: "+list.stream().mapToInt(Integer::intValue).sum());

		System.out.println("\nMax: "+list.stream().mapToInt(Integer::intValue).max().orElse(0));

		System.out.println("\nMin: "+list.stream().mapToInt(Integer::intValue).min().orElse(0));

		System.out.println("\nAverage: "+list.stream().mapToInt(Integer::intValue).average().orElse(0d));

		System.out.println("\nSort: ");
		list.stream().sorted().forEach(System.out::println);

		System.out.println("\nReverse Sort: ");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);

		System.out.print("\nN-1 Sum:"); highestSum(list);
		
	}

	public static void highestSum(List<Integer> list) {
		Collections.sort(list);
		int sum = list.stream().mapToInt(Integer::intValue).sum();
		list.stream().forEach(System.out::println);
		System.out.print("\tMax Sum:"+ (sum - list.get(0)));
		System.out.print("\tMin Sum:"+ (sum - list.get(list.size()-1)));
	}

}
