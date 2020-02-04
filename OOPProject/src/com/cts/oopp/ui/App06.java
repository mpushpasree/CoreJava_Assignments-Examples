package com.cts.oopp.ui;

import java.util.Set;
import java.util.TreeSet;

import com.cts.oopp.model.Person1;

public class App06 {

	   public static void main(String[] args) {
		Set<Person1> persons=new TreeSet<>();
		persons.add(new Person1("pushpa",21));
		persons.add(new Person1("rekha",22));
		for(Person1 data :persons) {
			System.out.println(data);
		}
		System.out.println("---------------");				
	}

}
