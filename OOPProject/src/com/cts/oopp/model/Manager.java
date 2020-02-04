package com.cts.oopp.model;

public class Manager extends Employee {
	private int bonus;

	public Manager() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Manager(String name, int age,int salary,int bonus) {
		super(name, age,salary);
		this.bonus=bonus;
		// TODO Auto-generated constructor stub
	}
	public void setBonus(int bonus) {
		this.bonus=bonus;
	}
	public int getBonus() {
		return bonus;
	}
	@Override
	public String toString() {
		return super.toString()+","+bonus;
	}
}
