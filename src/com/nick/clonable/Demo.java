package com.nick.clonable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Demo { 
	public static void main(String[] args) { 
		
		List<A> alist = new ArrayList<>();
		List<B> blist = new ArrayList<>();
		blist = alist.stream().map(a -> new B(a.val1, a.val2, a.val4)).collect(Collectors.toList());		
	} 
} 

class A{
	int val1;
	int val2;
	int val3;
	int val4;
}

class B{
	int val1;
	int val2;
	int val4;	
	B(int val1, int val2, int val4){
		this.val1 =val1;
		this.val2 =val2;
		this.val4 =val4;
	}
}

