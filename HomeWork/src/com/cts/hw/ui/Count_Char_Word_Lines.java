package com.cts.hw.ui;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Count_Char_Word_Lines {
	
	 
		public static void counts(String Cfile) throws FileNotFoundException {
	 
			int CfileTotalWords = 0;
			int CfileTotalLines = 0;
			int CfileTotalCharacters = 0;
	 
			String CfileLine;
	 
			try (BufferedReader CfileBuffer = new BufferedReader(new FileReader(Cfile))) {
				display(" File Content");
	 
				while ((CfileLine = CfileBuffer.readLine()) != null) {
					display(CfileLine);
					CfileTotalLines++;
	 
					String[] myWords = CfileLine.replaceAll("\\s+", " ").split(" ");
	 
					for (String s : myWords) {
						CfileTotalCharacters += s.length();
					}
	 
					CfileTotalWords += myWords.length;
	 
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			display("\n Result ");
	 
			display("Total Characters: " + CfileTotalCharacters);
			display("Total Words: " + CfileTotalWords);
			display("Toal Lines: " + CfileTotalLines);
		}
	 
		private static void display(String string) {
			System.out.println(string);
		}
	 
		public static void main(String[] args) {
			try {
				String Cfile = "pushpa.txt";
				counts(Cfile);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}