package com.cts.oopp.ui;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListCollectionClass {

	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<>();
		names.add("pushpa");
		names.add("rekha");
		names.add("nandhu");
		Collections.sort(names);
		System.out.println("-------------");
		int pos=Collections.binarySearch(names,"pushpa");
		System.out.printf("pushpa found at %d\n",pos);
		System.out.printf("maximum is %s \n",Collections.max(names));
		System.out.println("------------");
		Collections.reverse(names);
		printList(names);
		System.out.println("-------");

	}
	private static void printList(ArrayList <String>names) {
		for(String name:names) {
			System.out.println(name);
		}
	}

}
