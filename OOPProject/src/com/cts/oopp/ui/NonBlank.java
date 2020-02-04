package com.cts.oopp.ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NonBlank {

	public static void main(String[] args) {
		FileReader fr=null;
		BufferedReader br=null;
		try {
			fr=new FileReader("Hello.txt");
			br=new BufferedReader(fr);
			while(true) {
					String line=br.readLine();
					if(!line.isEmpty() && line !=null) {
						System.out.println(line);
					}
				}
			}
			catch(NullPointerException | FileNotFoundException exep) {
				exep.printStackTrace();
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					br.close();
					fr.close();
				}catch(IOException | NullPointerException exep) {
					exep.printStackTrace();
				}
			}
	}	
		
}