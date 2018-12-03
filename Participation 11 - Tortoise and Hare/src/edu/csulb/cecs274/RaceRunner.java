package edu.csulb.cecs274;

public class RaceRunner {
	static Interface ui = new Interface();
	
	public static void execute()
	{
	//int slowPlodT= 0, fastPlodT= 0, slipT= 0, sleepH= 0, bigHopH= 0, bigSlipH= 0, smallHopH= 0, smallSlipH = 0;
	
	Hare h = new Hare();
	Tortoise t = new Tortoise();
	
	Track course;
		
		course = new Track(h.getPosition(), h.getIcon(), t.getPosition(), t.getIcon());
		course.printTrack();
		try 
		{
			Thread.sleep(1500);
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		ui.println("BANG!");
		ui.println("AND THEY'RE OFF!");
		while(!isWon(h.getPosition(), t.getPosition()))
		{
			try 
			{
				Thread.sleep(350);
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			int a = h.move();
			int c = t.move();
			course = new Track(h.getPosition(), h.getIcon(), t.getPosition(), t.getIcon());
			course.printTrack();
		}
		if (h.getPosition() == 70 && t.getPosition() == 70)
		{
			ui.println("It's a tie!");
		}
		else if (h.getPosition() == 70)
		{
			ui.println("Hare wins. Yuch.");
		}
		else
		{
			ui.println("TORTOISE WINS!!! YAY!!!");
		}
	}
	
	public static boolean isWon(int posOne, int posTwo)
	{
		if (posOne == 70 || posTwo == 70)
		{
			return true;
		}
		return false;
	}
}
