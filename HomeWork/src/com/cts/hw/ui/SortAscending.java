package com.cts.hw.ui;

import java.util.Scanner;

public class SortAscending {
		private static Scanner sc;
		public static void main(String[] args) 
		{
			int Size, i;
			sc = new Scanner(System.in);
		 
			System.out.print(" Please Enter Number of elements in an array : ");
			Size = sc.nextInt();	
			
			int [] a = new int[Size];
			
			System.out.print(" Please Enter " + Size + " elements of an Array  : ");
			for (i = 0; i < Size; i++)
			{
				a[i] = sc.nextInt();
			}
			
			SortAscendingMethod(a, Size);
			System.out.print("\n Result of an Array after Ascending Order :  ");
			printAttay(a, Size);
		}
		public static void SortAscendingMethod(int[] a, int Size)
		{
			int i, j, Temp;
			
			for (i = 0; i < Size; i++)
			{
				for (j = i + 1; j < Size; j++)
				{
					if(a[i] > a[j])
					{
						Temp = a[i];
						a[i] = a[j];
						a[j] = Temp;
					}			
				}
			}	
		}
		public static void printAttay(int[] Array, int Size)
		{
			int i;
			
			for (i = 0; i < Size; i++)
			{
				System.out.print(Array[i] + " ");
			}
		}
	}
