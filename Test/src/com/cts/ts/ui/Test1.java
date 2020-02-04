package com.cts.ts.ui;

public class Test1 {

	public static void main(String[] args) {
		int n=Integer.parseInt(args[0]);
		int count=0;
		for(int i=1;i<=n/2;i++) {
			if(n%i==0)
				count++;
		}
		if(count==2) {
			System.out.println("prime number");
		}
		else
			System.out.println("not a prime number");
	}

}
