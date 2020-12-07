package com.nick.immutable;

import java.util.Date;

public class ImmutableDemo {

	public static void main(String[] args) {
		Student std = new Student();
		
	}

}

final class Student{

	private int stdID;
	private String name;
	private Date dob;
	
	public Student() {}
	
	public Student(int stdID, String name, Date dob) {
		this.stdID = stdID;
		this.name = name;
		this.dob = dob;
	}



}
