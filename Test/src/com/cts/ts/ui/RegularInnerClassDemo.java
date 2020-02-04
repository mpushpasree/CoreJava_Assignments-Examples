package com.cts.ts.ui;

public class RegularInnerClassDemo {
	private int var;
	static void met() {
		RegularInnerClassDemo.Inner in=new RegularInnerClassDemo().new Inner();
		in.work();
	}
	class Inner{
		int var;
		void work() {
			int var=60;
			System.out.println("Inside inners work ...,var="+var);
			System.out.println("outside instance var="+RegularInnerClassDemo.this.var);
		}
	}
	public static void main(String[] args) {
		new RegularInnerClassDemo().met();
	}
}
