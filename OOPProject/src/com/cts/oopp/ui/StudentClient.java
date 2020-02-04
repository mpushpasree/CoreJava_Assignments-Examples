package com.cts.oopp.ui;

import com.cts.oopp.model.Student;

public class StudentClient {
	public static void main(String [] args) {
		Student.setFeePaid(75000);
		Student.setCourse("Java FSD");
		/*Array of objects */
		Student [] students=new Student[3];
		students [0]=new Student(1,"srinivas");
		students [1]=new Student(2,"pushpa");
		students [2]=new Student(3,"rekha");
		for(Student student : students) {
			student.show();
		}
		
	}

}
