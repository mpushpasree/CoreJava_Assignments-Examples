package com.cts.oopp.model;

public class Triangle extends Shape {

	public Triangle() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Triangle(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return (1/2)*  (x*y);
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}

}
