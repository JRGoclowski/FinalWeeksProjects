package edu.csulb.cecs274;

import java.util.Arrays;

public class Track {
	String[] trackTop = new String[75];
	String[] trackBottom = new String[75];
	
	public Track(int topPos, String topIcon , int bottomPos, String bottomIcon)
	{
		Arrays.fill( trackTop, " ");
		Arrays.fill( trackBottom, " ");
		trackTop[70] =  "|";
		trackBottom[70] = "|";
		if (topPos == 70 || bottomPos == 70)
		{
			
			if (topPos == 70 && bottomPos != 70)
			{
				trackTop[71] = topIcon;
				trackBottom[bottomPos] = bottomIcon;
			}
			else if (bottomPos == 70 && topPos != 70)
			{
				trackTop[topPos] = topIcon; 
				trackBottom[71] = bottomIcon;
			}
			else
			{
				trackTop[71] = topIcon;
				trackBottom[71] = bottomIcon;
			}
			
		}
		else
		{
			trackTop[topPos] = topIcon; 
			trackBottom[bottomPos] = bottomIcon;
			if (topPos == bottomPos && topPos !=0)
			{
				trackTop[topPos + 1] = " ";
				trackTop[topPos + 2] = "O";
				trackTop[topPos + 3] = "U";
				trackTop[topPos + 4] = "C";
				trackTop[topPos + 5] = "H";
				trackTop[topPos + 6] = "!";
			}
		}
		
		
	}
	
	public void printTrack()
	{
		for	(int i = 0; i <50; i++)
		{
			System.out.println("");
		}
		System.out.print("+");
		for (int i = 0; i < 73; i++)
		{
			System.out.print("-");
		}
		System.out.println("+");
		for (int i = 0; i < 75; i++)
		{
			System.out.print(trackTop[i]);
		}
		System.out.println("");
		for (int i = 0; i < 75; i++)
		{
			System.out.print(trackBottom[i]);
		}
		System.out.println("");
		System.out.print("+");
		for (int i = 0; i < 73; i++)
		{
			System.out.print("-");
		}
		System.out.println("+");
	}
}
