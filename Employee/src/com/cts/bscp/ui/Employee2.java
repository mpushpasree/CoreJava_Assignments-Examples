package com.cts.bscp.ui;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

public class Employee2 implements Comparable<Employee2>,Serializable {
		public int empId;
		public String empName;
		public LocalDate DateOfBirth;
		public LocalDate today = LocalDate.now();
		public int age;

		public LocalDate getDateOfBirth() {
			return DateOfBirth;
		}
		public Employee2(int empId, String empName, LocalDate dateOfBirth) {
			super();
			this.empId = empId;
			this.empName = empName;
			this.DateOfBirth = dateOfBirth;
		}
		
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		@Override
		public int compareTo(Employee2 emp) {
			Period p = Period.between(DateOfBirth, today);
			age = p.getYears();
			return this.age-emp.age;
		}

}
