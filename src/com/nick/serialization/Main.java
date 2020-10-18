package com.nick.serialization;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		//objectWrite();
		writeString();
		

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
		SomeClass sc = new SomeClass();
		sc.data = 1;
		sc.name = "abc";

		//serializing
		File f = new File("SomeClass.txt");
		FileOutputStream fos = new FileOutputStream(f);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(sc);
		oos.close();
		fos.close();

		//deserializing
		FileInputStream fis = new FileInputStream(f);
		ObjectInputStream ois = new ObjectInputStream(fis);
		SomeClass result  = (SomeClass)ois.readObject();
		System.out.println(result.data+ " "+ result.name);
		ois.close();
		fis.close();
	}
}

class SomeClass implements Serializable{
	private static final long serialVersionUID = 1L;
	int data;
	transient String name;
}
