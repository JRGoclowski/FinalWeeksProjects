package edu.csulb.cecs228;

import java.util.*;

public class Main {
	
	static ArrayList <Integer> primeNumbers = new ArrayList <Integer>();
	
	public static void main(String[] args) 
	{
		for (int i = 2; i < 1000; i++)
		{
			if (isPrime(i))
			{
				primeNumbers.add(i);
			}
		}
		
		int index = 4;
		
		for (int i = 0 ; i <499; i ++)
		{
			int firstInt = 0, secondInt = primeNumbers.size()-1;
	        while (firstInt <= secondInt) 
	        {
	            if      (primeNumbers.get(firstInt) + primeNumbers.get(secondInt) == index)
            	{
            		break;
            	}
	            else if (primeNumbers.get(firstInt) + primeNumbers.get(secondInt)  < index)
            	{
	            	firstInt++;
            	}
	            else 
            	{
	            	secondInt--;
            	}
	        }
	        System.out.println(index + " = " + primeNumbers.get(firstInt) + " + " + primeNumbers.get(secondInt));
	        
			index += 2;
		}
	}
	
	
	public static boolean isPrime(int num) 
	{
        boolean prime = true;
	        for(int i = 2; i <= num/2; i++)
	        {
	            
	            if(num % i == 0)
	            {
	                prime = false;
	                break;
	            }
	        }
		return prime;
	}
}
