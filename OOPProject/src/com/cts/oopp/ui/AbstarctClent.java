package com.cts.oopp.ui;

import com.cts.oopp.model.Circle;
import com.cts.oopp.model.Rectangle;
import com.cts.oopp.model.Shape;

public class AbstarctClent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle rectangle=new Rectangle(10,5);
		System.out.println(rectangle);
		Circle circle=new Circle(3);
		System.out.println(circle);
		Shape shape;
		shape=new Rectangle(10,5);
		System.out.println(shape);
		shape=new Circle(3);
		System.out.println(shape);

	}

}
