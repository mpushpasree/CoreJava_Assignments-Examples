package com.cts.oopp.model;

public class Rectangle extends Shape {

	public Rectangle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double x) {
		super(x);
		// TODO Auto-generated constructor stub
	}

	public Rectangle(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return super.x*super.y;
	}

	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2*(super.x + super.y);
	}

}
