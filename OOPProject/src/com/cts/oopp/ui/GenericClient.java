package com.cts.oopp.ui;

import com.cts.oopp.model.GenericClass;

public class GenericClient {

	public static void main(String[] args) {
		GenericClass<Integer>m=new GenericClass<Integer>();
		m.add(2);
		System.out.println(m.get());
		GenericClass <Integer>m1=new GenericClass<Integer>();
		m1.add(2);
		System.out.println(m1.get());
	}

}
