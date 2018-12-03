package edu.csulb.cecs274;

public abstract class Animal {

	String icon;
	int position;
	String type;
	
	
	public Animal(String i, int pos, String creature)
	{
		icon = i;
		position = pos;
		type = creature;
	}
	
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract int move();
		
	
}
