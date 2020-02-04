package com.cts.ts.ui;
class Outer{
	int v;
	void some() {
		double d=76.99;
		class Inner{
			void work() {
				System.out.println("Inner Inside ............"+d);
			}
		}
		new Inner().work();
	}
}

public class MethodLocalClassDemo {
	public static void main(String [] args) {
	new Outer().some();
	}
}
