package com.cts.oopp.ui;

import java.util.Map;
import java.util.TreeMap;

public class Atreemap {

	public static void main(String[] args) {
		Map<String,String> hm=new TreeMap<>();
		hm.put("java","Language");
		hm.put("dot net","frame work");
		hm.put("c#", "language");
		for(String key:hm.keySet())
			System.out.printf("%s : %s\n",key,hm.get(key));


	}

}
