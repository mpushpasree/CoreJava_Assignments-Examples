package com.cts.bscp.ui;

import java.io.File;
import java.io.FileOutputStream;

import java.io.IOException;

import java.io.PrintStream;

import java.time.DateTimeException;
import java.time.LocalDate;

import java.util.Set;
import java.util.TreeSet;


public class Employee2Demo {

	public static void main(String[] args) throws IOException {
		FileOutputStream  fos=null;
		try {
			File file = new File("result.txt");
			fos = new FileOutputStream(file);
			PrintStream ps = new PrintStream(fos);
			System.setOut(ps);
			System.out.println("This goes to result.txt");

			
			Set<Employee2> pq = new TreeSet<Employee2>();
			Employee2 e1 = new Employee2(1,"pushpa",LocalDate.of(1994,1, 27));
			pq.add(e1); 
			Employee2 e2 = new Employee2(2,"rekha",LocalDate.of(1969, 10, 7)); 
			pq.add(e2);          
			Employee2 e3 = new Employee2(3,"nandini",LocalDate.of(1999, 05, 26)); 
			pq.add(e3); 
			System.out.println("Employeesage order");
			for(Employee2 emp: pq) {
				System.out.println(emp.getEmpName());	
			}
		}catch(DateTimeException exep) {
			exep.printStackTrace();
		}finally {
			try {
				fos.close();
			}catch(Exception exep) {
				exep.printStackTrace();
			}
		}
		
}
}