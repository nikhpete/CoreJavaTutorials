package com.nick.generics.iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class IteratorDemo {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));

		Iterator<Integer> it = list.iterator();

		System.out.println("iterating");
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}

		list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9));
		System.out.println("SplitIterator");
		Spliterator<Integer> sti = list.spliterator();
		Spliterator<Integer> sti2 = sti.trySplit();
		System.out.println("1st set");
		sti.forEachRemaining(System.out::println);
		System.out.println("2nd set");
		sti2.forEachRemaining(System.out::println);

		iterableSubClass<Integer> iterableList = new iterableSubClass<>();
		iterableList.add(2);
		iterableList.add(4);
		iterableList.add(1);
		iterableList.add(6);

		Iterator<Integer> ite = iterableList.iterator();
		System.out.println("Custom list");
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
	}

}

class iterableSubClass<T> implements Iterable<T>{

	private T[] items = (T[]) new Object[10];
	private int count;

	public void add(T item) {
		items[count++] = item;
	}

	public T getItem(int index) {
		return items[index];
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator(this);
	}

	private class ListIterator implements Iterator<T>{

		private iterableSubClass<T> list;
		private int index;

		public ListIterator(iterableSubClass<T> list) {
			this.list = list;
		}

		@Override
		public boolean hasNext() {
			return index<list.count;
		}

		@Override
		public T next() {
			return list.getItem(index++);
		}

	}

}
