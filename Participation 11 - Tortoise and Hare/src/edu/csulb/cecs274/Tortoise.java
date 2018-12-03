package edu.csulb.cecs274;

import java.util.Random;

public class Tortoise extends Animal
{
	Random r = new Random();
	public Tortoise() 
	{
		super("T", 0, "Tortoise");
		
	}
	
	public int move()
	{
		int rngInt = r.nextInt(10) + 1;
		int currentPos = getPosition();
		if (rngInt <= 5)
		{
			if(currentPos + 3 < 70)
			{
				setPosition(currentPos + 3);
			}
			else
			{
				setPosition(70);
			}
			return 3;
		}
		else if (rngInt <= 7)
		{
			if(currentPos - 6  > 0)
			{
				setPosition(currentPos - 6);
			}
			else
			{
				setPosition(0);
			}
			return -6;
		}
		else
		{
			if(currentPos + 1 < 70)
			{
				setPosition(currentPos + 1);
			}
			else
			{
				setPosition(70);
			}
			return 1;
		}
	}


}
