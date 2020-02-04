package com.cts.oopp.model;

public class Student1 extends Person {
	private int fee;

	public Student1() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Student1(String name, int age,int fee) {
		super(name, age);
		this.fee=fee;
		// TODO Auto-generated constructor stub
	}
	public void setFee(int fee) {
		this.fee=fee;
	}
	public int getFee() {
		return fee;
	}
	@Override
	public String toString() {
		return super.toString()+","+fee;
	}
}
