package com.cts.oopp.model;

public class Employee extends Person {
	private int salary;
	public Employee() {
		super();/*calling super calss constructor */
	}
	public Employee(String name,int age,int salary) {
		super(name,age);
		this.salary=salary;
	}
	public void setSalary(int salary) {
		this.salary=salary;
	}
	public int getSalary() {
		return salary;
	}
	@Override
	public String toString() {
		return super.toString()+","+salary;
	}

}
