package com.cts.oopp.model;

public class Complex {
	/* data members */
	private int realPart;
	private int imaginaryPart;
	/*default constructor (no argument constructor) */
	public Complex() {	
		realPart=0;
		imaginaryPart=0;
	}
	/* parameter constructor */
	public Complex(int realPart,int imaginaryPart) {
		this.realPart=realPart;;
		this.imaginaryPart=imaginaryPart;
	}
	public void setRealPart(int realPart) {
		this.realPart=realPart;
	}
	public void setImaginaryPart(int imaginaryPart) {
		this.imaginaryPart=imaginaryPart;
	}
	public int getRealPart() {
		return this.realPart;
	}
	public int getImaginaryPart() {
		return this.imaginaryPart;
	}
	public Complex add(Complex s) {
		int realPartSum=this.getRealPart()+s.getRealPart();
		int imaginaryPartSum=this.getImaginaryPart()+s.getImaginaryPart();
		Complex t=new Complex(realPartSum,imaginaryPartSum);
		return t;
	}
	public void show() {
		System.out.println(realPart+","+imaginaryPart); 
	}

}
