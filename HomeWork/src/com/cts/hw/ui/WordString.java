package com.cts.hw.ui;
	import java.io.BufferedReader;
	import java.io.FileReader;
	//import java.io.FileWriter;
	import java.io.IOException;
	import java.util.Scanner;

	public class WordString {

		public static void main(String[] args) {
			FileReader fr=null;
			//FileWriter fw=null;
			BufferedReader br=null;
			
			try {
				Scanner s=new Scanner(System.in);                                                                                           
				String fileName=s.next();
				String word=s.next();
				fr=new FileReader(fileName);
				br=new BufferedReader(fr);
				//fw=new FileWriter("search.txt");
				while(true) {
					String line=br.readLine();
					if(line==null)
						break;
					String [] names=line.split(" ");
					for(String name:names) {
						if(word.equals(name))
							System.out.println(line);
					}
					
				}
			}catch(IOException excep) {
				System.out.println(excep.getMessage());
			}
			finally {
				try {
					fr.close();
					br.close();
				}catch(IOException excep) {
					System.out.println(excep.getMessage());
				}
				
			}
		}

	}

