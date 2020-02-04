package com.cts.ts.ui;
interface Remote{
	void doSomething();
}
public class MyWork {
	public static void main(String[] args) {
		Remote ref=new Remote() {
			@Override
			public void doSomething() {
				System.out.println("Inside do something...");
			}
		};
		ref.doSomething();
	}
}
