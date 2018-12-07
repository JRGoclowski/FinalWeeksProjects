package edu.csulb.cecs274;

public class main {
	static Interface ui = new Interface();
	
	public static void main(String[] args)
	{
		Heap h = new Heap();
		
		h.printTree(h.getHeapElements());
		//System.out.println(h.isTreeMaxHeap());
		while(!h.isTreeMaxHeap())
		{
			ui.println("Input to continue");
			ui.input();
			h.sortDownTree(h.getRootNode(), 1);
			h.printTree(h.getHeapElements());
			ui.println("");
		}
		h.printTree(h.getHeapElements());
		ui.println("The tree is now a Max heap.");
		ui.println("Enter any key to begin sorting into a Min Heap");
		ui.input();
		while(!h.isTreeMinHeap())
		{
			h.sortUpTree(h.getRootNode(), 1);
			h.printTree(h.getHeapElements());
			ui.println("Input to continue");
			ui.input();
			ui.println("");
		}
		h.printTree(h.getHeapElements());
		ui.println("The tree is now a Min Heap");
		h.print();
	}
}
