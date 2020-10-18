package com.nick.serialization;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ParallelStreamDemo {

	public static void main(String[] args) {
		List<Student> stdList = new ArrayList<>();
		stdList.add(new Student(83, "nick"));
		stdList.add(new Student(99, "akhil"));
		stdList.add(new Student(67, "annie"));
		stdList.add(new Student(79, "siva"));
		stdList.add(new Student(34, "james"));
		stdList.add(new Student(45, "pand"));

		LocalDateTime x = LocalDateTime.now();
		stdList
		.parallelStream()
		.forEach(System.out::println);
		System.out.println(x.until(LocalDateTime.now(), ChronoUnit.NANOS));
		
		System.out.println();
		x = LocalDateTime.now();
		stdList
		.stream()
		.forEach(System.out::println);
		System.out.println(x.until(LocalDateTime.now(), ChronoUnit.NANOS));
		
		List<Integer> list = Arrays.asList(5,2,4,1,3,0);
		System.out.println();
		
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		
	}

}

class Student implements Comparable<Student>{
	private Integer id;
	private String name;

	Student(int id, String name){
		this.id = id;
		this.name = name;
	}


	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "[id=" + id + ", name=" + name + "]";
	}


	@Override
	public int compareTo(Student other) {
		return this.id - other.id;
	}


}
