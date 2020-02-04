package com.cts.oopp.model;

public class Student {
	private int rollNumber;
	private String name;
	private static String course;
	private static int feePaid;
	public Student() {
	/*default constructor */
	}
	public Student(int rollNumber,String name) {
		this.rollNumber=rollNumber;
		this.name=name; 
	}
	public static void setCourse(String newCourse) {
		course=newCourse;
	}
	public static String getCourse() {
		return course;
	}
	public static void setFeePaid(int fee) {
		feePaid=fee;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber=rollNumber;
	}
	public int getRollNumber() {
		return rollNumber;	
	}
	public void setName(String name) {
		this.name=name;
	}
	public void show() {
		System.out.println(rollNumber+","+name+","+course+","+feePaid);
	}
}
