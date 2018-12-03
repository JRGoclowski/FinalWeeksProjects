package edu.csulb.cecs228;

import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Interface {
	
	Scanner s;
	
	//constructor for the interface, just makes a scanner
	public Interface()
	{
		s = new Scanner(System.in);
	}
	
	//Allows for user string input. Also checks the user input against
	//an array of acceptable inputs, and returns an error message
	//if the input is not one of the desired inputs
	public String stringIn(String[] a)
	{
		String response = s.next();
		while (!Arrays.asList(a).contains(response.toUpperCase()))
		{
			print("That is not an acceptable input.");
			print("Please input one of the following options:");
			for (int i = 0; i < a.length; i++)
			{
				print(a[i]);
			}
			response = s.next();
		}
		return response;
	}
	
	public String input()
	{
		String response = s.next();
		return response;
	}
	
	public char charIn()
	{
		char response = s.next().charAt(0);
		return response;		
		
	}
	//Allows for user integer input. If the input is not an integer
	//returns an error message and requires the user input an integer
	public int intIn()
	{
		while(true)
		{
			try
			{
			  return s.nextInt();
			}
			catch(InputMismatchException/*remember to imp*/
					exception)
			{
			  s.next();
			  print("This is not an integer");
			}

		}

	}
	
	//System.out short hand
		public void print(String output)
		{
			System.out.print(output);
		}
		
		public void println(String output)
		{
			System.out.println(output);
		}
		
		public void print(char output)
		{
			System.out.print(output);
		}
		
		public void println(char output)
		{
			System.out.println(output);
		}
		
		public void print(int output)
		{
			System.out.print(output);
		}
		
		public void println(int output)
		{
			System.out.println(output);
		}

}
