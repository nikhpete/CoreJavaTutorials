package com.nick.collection;

import java.util.*;

public class HasmapDemo {

	public static void main(String[] args) throws InterruptedException {
		List<Emp> emplist = new ArrayList<>();

		Emp emp = new Emp();
		for(int i=0;i<10;++i) {
			emp.empId = i;
			emp.empName = "name"+i;
			emplist.add(emp);
		}

		emplist.stream().forEach(System.out::println);

		Map<Emp, String> empMap = new HashMap<>();
		emp = new Emp(1, "name1");
		Emp emp2 = new Emp(2, "name2");

		empMap.put(null, "Marketing");
		empMap.put(emp2, "Accounts");
		empMap.put(emp, "sales");
		
		System.out.println("\nHashMap");
		empMap.entrySet().stream().forEach(val -> System.out.println("{"+val.getKey()+":"+val.getValue()+"}"));

		empMap = new TreeMap<>();
		empMap.put(emp2, "Accounts");
		empMap.put(emp, "sales");

		System.out.println("\nTreeMap");
		empMap.entrySet().stream().forEach(val -> System.out.println("{"+val.getKey()+":"+val.getValue()+"}"));

		empMap = new WeakHashMap<>();

		Emp emp3 = new Emp();
		empMap.put(null, "HR");
		empMap.put(emp3, "Marketing");
		empMap.put(emp2, "Accounts");
		empMap.put(emp, "sales");
		emp3 = null;
		
		System.gc();

		System.out.println("\nWeakHashMap");
		empMap.entrySet().stream().forEach(val -> System.out.println("{"+val.getKey()+":"+val.getValue()+"}"));
		
		empMap = new LinkedHashMap<>();
		empMap.put(emp2, "Accounts");
		empMap.put(null, "HR");
		//maintains insertion order
		System.out.println("\nLinkedHashMap");
		empMap.entrySet().stream().forEach(val -> System.out.println("{"+val.getKey()+":"+val.getValue()+"}"));
				
	}
}

class Emp implements Comparable<Emp>{
	int empId;
	String empName;

	public Emp() {}

	public Emp(int empId, String empName) {
		this.empId = empId;
		this.empName = empName;
	}

	@Override
	public String toString() {
		return "{"+empId+":"+empName+"}";
	}

	@Override
	public int compareTo(Emp o) {
		return empId - o.empId;
	}
}