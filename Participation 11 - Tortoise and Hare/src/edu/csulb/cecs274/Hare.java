package edu.csulb.cecs274;

import java.util.Random;

public class Hare extends Animal 
{
	
	Random r = new Random();
	
	public Hare() 
	{
		super("H", 0, "Hare");
		
	}

	public int move()
	{
		int rngInt = r.nextInt(10) + 1;
		int currentPos = getPosition();
		
		if (rngInt <= 2)
		{
			setPosition(currentPos);
			return 0;
		}
		else if (rngInt <= 4)
		{
			if(currentPos + 9 < 70)
			{
				setPosition(currentPos + 9);
			}
			else
			{
				setPosition(70);
			}
			return 9;
		}
		else if (rngInt == 5)
		{
			if(currentPos - 12 > 0)
			{
				setPosition(currentPos - 12);
			}
			else
			{
				setPosition(0);
			}
			return -12;
		}
		else if (rngInt <= 8)
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
		else
		{
			if(currentPos - 2 > 0)
			{
				setPosition(currentPos - 2);
			}
			else
			{
				setPosition(0);
			}
			return -2;
		}
	}

}
