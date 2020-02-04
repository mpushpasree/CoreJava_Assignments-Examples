package com.cts.ts.ui;
interface Shapes{
	void area();
	void perimeter();
}
class Triangle implements Shapes{
	@Override
	public void area() {
		System.out.println("Area of triangle is 1/2 *b*h");
	
	}
	@Override
	public void perimeter() {
		System.out.println("Perimeter of triangle is l*b*h");
	}
	
}
class Rectangle implements Shapes{
	@Override
	public void area() {
		System.out.println("Area of rectangle is l*b");
	
	}
	@Override
	public void perimeter() {
		System.out.println("Perimeter of rectangle is 2*(l+b)");
	}
	public void dimensions() {
		System.out.println("length is: ");
		System.out.println("breadth is: ");
	}
}

public class RuntimePolyDemo {

	public static void main(String[] args) {
		Shapes [] shapes=new Shapes[2];
		shapes[0]=new Triangle();
		shapes[1]=new Rectangle();
		for(Shapes var :shapes) {
			var.area();
			var.perimeter();
			if(var instanceof Rectangle)
				((Rectangle)var).dimensions();
		}
	}

}
