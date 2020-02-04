package com.cts.ts.ui;


class Some{
	void work(Object val){
		System.out.println("Object");
	}

	void work(long val){
		System.out.println("long");
}
}


public class Overloading{
	public static void main(String[] args) {
		

		byte var = 9;

		new Some().work(var);


	}
}


 // byte -> Byte -> Long
 // byte -> Byte -> Object

	


