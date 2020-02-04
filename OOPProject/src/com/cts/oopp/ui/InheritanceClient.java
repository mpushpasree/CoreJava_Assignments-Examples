package com.cts.oopp.ui;

import com.cts.oopp.model.Employee;
import com.cts.oopp.model.Person;

public class InheritanceClient {
	public static void main(String [] args) {
		Person person=new Person();
		person.setName("srinivas");
		person.setAge(53);
		System.out.println(person);
		Employee employee=new Employee();
		employee.setName("meghana");
		employee.setAge(21);
		employee.setSalary(35000);
		System.out.println(employee);
		
	}

}
