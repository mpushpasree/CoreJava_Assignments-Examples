package com.cts.oopp.ui;

import com.cts.oopp.model.Employee;
import com.cts.oopp.model.Manager;
import com.cts.oopp.model.Person;

public class InClient {

	public static void main(String[] args) {
		Person person=new Person();
		Employee employee=new Employee();
		person.setName("pushpa");
		person.setAge(23);
		System.out.println(person);
		employee.setSalary(5000);
		employee.setName("meena");
		employee.setAge(50);
		System.out.println(employee);
		Manager manager=new Manager();
		manager.setName("sowmya");
		manager.setAge(23);
		manager.setSalary(100000);
		manager.setBonus(5000);
		System.out.println(manager);
	}

}
