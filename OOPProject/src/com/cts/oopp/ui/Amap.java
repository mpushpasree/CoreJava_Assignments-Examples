package com.cts.oopp.ui;

import java.util.HashMap;
import java.util.Map;

public class Amap {

	public static void main(String[] args) {
		HashMap<String,String> hm=new HashMap<>();
		hm.put("java","Language");
		hm.put("c#", "language");
		hm.put("dot net","frame work");
		
		for(String key:hm.keySet())
			System.out.printf("%s : %s\n",key,hm.get(key));

	}

}
