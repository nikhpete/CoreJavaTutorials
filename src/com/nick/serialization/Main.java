package com.nick.serialization;

import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		objectWrite();
		//writeString();


	}

	public static void writeString() throws IOException {
		File f = new File("string.txt");
		FileWriter fw = new FileWriter(f);
		Writer w = new BufferedWriter(fw);
		w.write("abc\n");
		w.write("def\n");
		w.write("abc\n");
		w.write("jkl\n");
		w .close();
		fw.close();

		Scanner sc = new Scanner(f);
		Set<String> stringSet = new HashSet<>();
		while(sc.hasNext()) {
			stringSet.add(sc.next());
		}

		stringSet.stream().forEach(System.out::println);

		sc.close();


	}

	public static void objectWrite()throws IOException, ClassNotFoundException {

		//serializing
		File f = new File("SomeClass.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(new Employee(1983, "name3", 1000));
		oos.writeObject(new Employee(1986,"name6",2030));
		for(int i=0;i<10;++i) {
			oos.writeObject(new Employee(1980+i, "name"+i, 1000+ i*10));
		}
		
		oos.close();
		fos.close();

		//deserializing
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);

		Set<Employee> empSet = new TreeSet<>();
		boolean isExist = true;
		do {
			try {
			Employee result  = (Employee)ois.readObject();
			System.out.println(result);
			empSet.add(result);
			} catch (EOFException e) {
				isExist = false;
			}
		}while(isExist);
		
		System.out.println("\nFiltered Data");
		empSet.stream().forEach(System.out::println);
		
		ois.close();
		fis.close();
	}
}

class Employee implements Serializable, Comparable<Employee>{
	private static final long serialVersionUID = 1L;
	int empid;
	String empName;
	float salary;

	public Employee(int empid, String empName, float salary) {
		this.empid = empid;
		this.empName = empName;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "{"+empid+","+empName+","+salary+"}";
	}

	@Override
	public int compareTo(Employee o) {
		return empid - o.empid + empName.compareTo(o.empName);
	}

}
