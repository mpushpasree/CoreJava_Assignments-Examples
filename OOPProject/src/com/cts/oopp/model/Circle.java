package com.cts.oopp.model;

public class Circle extends Shape {

	public Circle() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Circle(double x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return Math.PI*Math.pow(x,2);
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*Math.PI*x;
	}

}
