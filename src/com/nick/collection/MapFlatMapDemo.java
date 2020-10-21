package com.nick.collection;

import java.util.*;
import java.util.stream.Collectors;

public class MapFlatMapDemo {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("JavaDevJournel","java");
		
		List<String> newList = list.stream().map(s->s.split("")).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
		
		newList.stream().forEach(val-> {
			//Arrays.asList(val).stream().forEach(subVal-> System.out.print(subVal+" "));
			System.out.print(val+" ");
		});
	}

}
