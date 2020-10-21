package com.nick.generics;

public class GenericDemo {

	public static void main(String[] args) {
		GenericList<User> list = new GenericList<User>();
		list.add(new User(1));
		
		GenericList<Instructor> insList = new GenericList<Instructor>();
		insList.add(new Instructor(2));
		
		Util.printUsers(list);
		Util.printUsers(insList);
		
		Util.maxValue(1, 10);
	}

}

class GenericList<T>{
	private T[] items = (T[]) new Object[10];
	private int count;
	
	public void add(T item) {
		items[count++] = item;
	}
	
	public T getItem(int index) {
		return items[index];
	}
	
}

class User{
	int points;
	
	public User(int points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "{"+this.points+"}";
	}
	
}

class Instructor extends User{

	public Instructor(int points) {
		super(points);
	}
	
}

class Util{
	public static <T extends Comparable<T>> T max(T first, T second) {
		return (first.compareTo(second)<0)? first : second;
	}
	
	public static <K,V> void maxValue(K key, V value){
		System.out.println("Data="+key+":"+value);
	}
	
	public static void printUsers(GenericList<?> users) {
		System.out.println("User points:"+users.getItem(0));
	}
}
