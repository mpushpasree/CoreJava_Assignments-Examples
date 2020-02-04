package com.cts.oopp.model;

public class Person1 implements Comparable <Person1>{
	private String name;
	private int age;
	public Person1() {
		/* default constructor */
	}
	public Person1(String name,int age) {
		this.name=name;
		this.age=age;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setAge(int age) {
		this.age=age;
	}
	public int getAge() {
		return age;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj)
			return true;
		if(obj==null)
			return false;
		if(this.getClass()!=obj.getClass())
			return false;
		Person1 other=(Person1)obj;
		if(age!=other.age)
			return false;
		if(name==null) {
			if(other.name!=null)
				return false;
		}
		else if(!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return name +","+ age;
	}
	@Override
	public int compareTo(Person1 other) {
		if(this.name.equals(other.name))
			return this.age-other.age;
		else
			return this.name.compareTo(other.name);
		
	}
	
}

