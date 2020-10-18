package com.nick.generics;

public class GenericDemo {

	public static void main(String[] args) {
		GenericList<User> list = new GenericList();
	}

}

class GenericList<T extends Comparable<T> & Cloneable>{
	private T[] items = (T[]) new Object[10];
	private int count;
	
	public void add(T item) {
		items[count++] = item;
	}
	
	public T getItem(int index) {
		return items[index];
	}
	
}

class User implements Comparable<User>, Cloneable{
	int points;
	@Override
	public int compareTo(User o) {
		return this.points = o.points;
	}
	
}

class Util{
	public static <T extends Comparable<T>> T max(T first, T second) {
		return (first.compareTo(second)<0)? first : second;
	}
}
