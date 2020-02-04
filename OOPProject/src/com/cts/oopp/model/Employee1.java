package com.cts.oopp.model;

import java.io.Serializable;
import java.util.Scanner;

public class Employee1 implements Serializable{
	Scanner s=new Scanner(System.in);
	public String name=s.nextLine();
	int age=s.nextInt();
	/*@Override
	public String toString() {
		return name +","+ age;
	} */
}
