package com.nick.clonable;

public class CloneDemo {

	public static void main(String[] args) throws CloneNotSupportedException {
		//shallow cloning
		System.out.println("\nShallow Cloning");
		Employee e1 = new Employee(123, "abc");
		Employee e2 = e1;
		System.out.println(e1);
		e2.id = 143;
		System.out.println(e1);
		System.out.println(e2);
		
		//deep cloning
		System.out.println("\nDeep Cloning");
		Employee e3 = new Employee(123, "abc");
		Employee e4 = (Employee)e3.clone();
		System.out.println(e3);
		e4.id = 143;
		System.out.println(e3);
		System.out.println(e4);
		
	}

}

class Employee implements Cloneable{
	int id;
	String name;

	public Employee(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "{ "+ id+" : "+name+"}";
	}
}
