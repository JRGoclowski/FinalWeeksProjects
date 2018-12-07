package edu.csulb.cecs274;

import java.util.*;

public class Heap extends BinaryTree{
	
	int[] heapElements = new int[32];
	ArrayList <Integer> allNum;
	
	public Heap()
	{
		allNum = new ArrayList<Integer>();
		createRandomArray();
		buildTree();
		fillTree();
	}
	
	public void createRandomArray()
	{
		
		for (int i = 10; i < 100; i++)
		{
			allNum.add(i);
		}
		 Random r = new Random();
		 for (int i = 1; i < 32; i++)
		 {
			 int chosen = r.nextInt(allNum.size());
			 heapElements[i] = allNum.remove(chosen);
		 }
		
	}
	
	public void buildTree()
	{
		setRoot(new Node(heapElements[1]));
		Node indexNode = getRootNode();
		for (int i = 0; i <2; i++)
		{
			indexNode = indexTraverse(indexNode, i);
			for (int j = 0; j <2; j++)
			{ 
				indexNode = indexTraverse(indexNode, j);
				for (int k = 0; k <2; k++)
				{ 
					indexNode = indexTraverse(indexNode, k);
					for (int l = 0; l <2; l++)
					{ 
						indexNode = indexTraverse(indexNode, l);
						indexNode = getParent(indexNode);
					
					}
					indexNode = getParent(indexNode);
				}
				indexNode = getParent(indexNode);
			}
			indexNode = getParent(indexNode);
		}
		
	}
	
	public boolean sortDownTree(Node indexNode, int index)
	{
		if (leftIndex(index)>31)
		{
			return false;
		}
		else if (sift(indexNode))
		{
			return true;
		}
		else
		{
			if (indexNode.hasLeft())
			{
				return sortDownTree(indexNode.left, index) 
						|| sortDownTree(indexNode.right,index);
			}
			return false;
			
		}
		   
	}
	
	public boolean sortUpTree(Node indexNode, int index)
	{
		if (leftIndex(index)>31)
		{
			return false;
		}
		else if (shift(indexNode))
		{
			return true;
		}
		else
		{
			if (indexNode.hasLeft())
			{
				return sortUpTree(indexNode.left, index) 
						|| sortUpTree(indexNode.right,index);
			}
			return false;
			
		}
		   
	}
	
	public Node getParent (Node targetNode)
	{
		return getParent(targetNode, getRootNode(), getRootNode());		
	}
	
	
	public Node getParent(Node targetNode, Node parentNode, Node indexNode)
	{
			Node index = indexNode, tmp;
			
			if(index.equals(targetNode))//matching node found
			{
				return parentNode;
			}
		          
			
		    if(index.right != null)
		    {//check if right child is parent of match
		          tmp = getParent(targetNode, index, index.right);
		          if(tmp != null)//match found -> complete path from this node
		               return tmp;
		    } 
		    
		    if(index.left != null)//check if left child is parent of match
		    {
		    	tmp = getParent(targetNode, index, index.left);
		          if(tmp != null)
		               return tmp;
		    }
		    	
			     

		     //c is no content of the tree with node as root -> return null
	    return null;
		
	}
	
	public void fillTree()
	{
		Node indexNode, root = getRootNode();;
		//This is two because build tree establishes the root with one.
		int elementIndex = 2;
		while (elementIndex < 32)
		{
			indexNode = root;
			indexNode = fillTraverse(indexNode);
			indexNode.data = heapElements[elementIndex];
			elementIndex++;
			
		}
	}
	
	public Node fillTraverse(Node index)
	{
		if (!index.hasLeft()&& !index.hasRight())
		{
			return index;	
		}
		else if (index.left.data == 0)
		{
			return fillTraverse(index.left);
		}
		else if ((index.left.data != 0) && 
				(index.right.data == 0))
		{
			return fillTraverse(index.right);
		}
		else 
		{
			return index;		
		}
	}

	public Node indexTraverse(Node indexNode, int cycleCount)
	{
		if (cycleCount == 0)
		{
			if (!indexNode.hasLeft())
			{
				indexNode.left = new Node(0);
			}
			return indexNode.left;
		}
		else
		{
			if (!indexNode.hasRight())
			{
				indexNode.right = new Node(0);
			}
			return indexNode.right;
		}
	}
	
	/*public void randomTree()
	{
		setRoot(new Node(heapElements[1]));
		Node indexNode = getRootNode();
		for (int i = 2; i <32; i ++) 
		{
			add (heapElements[i], indexNode);
		}
	}
	
	public boolean add(int addition, Node indexNode)
	{
		Node index = indexNode;
		if (index.hasLeft() && index.hasRight())
		{
			int left = getDepth(indexNode.left);
			int right = getDepth(indexNode.right);
			if (left<=right)
			{
				return add(addition, indexNode.left);
			}
			else
			{
				return add(addition, indexNode.right);
			}
		}
		else if (!index.hasLeft())
		{
			index.left = new Node (addition);
			return true;
		}
		else if (!index.hasRight())
		{
			index.right = new Node(addition);
			return true;
		}
		else
		{
			return false;
		}
	}*/
	
	public void printTree(int[] elements)
	{
		Node rootNode = getRootNode();
		
		//Top level (First Data Level)
		repPrint(" ", 46);					
		System.out.println(rootNode.data);
		
		//Second Level (First Line Level)
		repPrint(" ", 46);		
		System.out.println("|");
		
		//Third Level (Second Data Level)
		repPrint(" ", 22);
		System.out.print(rootNode.left.data);
		repPrint("-", 22);		
		System.out.print("^");
		repPrint("-", 22);
		System.out.println(rootNode.right.data);
		
		//Fourth Level (Second Line Level)
		repPrint(" ", 22);
		System.out.print("|");
		repPrint(" ", 47);
		System.out.println("|");
		
		//Fifth Level (Third Data Level)
		repPrint(" ", 10);			
		System.out.print(rootNode.left.left.data);
		repPrint("-", 10);
		System.out.print("^");
		repPrint("-", 10);
		System.out.print(rootNode.left.right.data);
		repPrint(" ", 23);
		System.out.print(rootNode.right.left.data);
		repPrint("-", 10);
		System.out.print("^");
		repPrint("-", 10);
		System.out.println(rootNode.right.right.data);
		
		//Sixth Level (Third Line Level)
		repPrint(" ", 10);
		System.out.print("|");
		repPrint(" ", 23);
		System.out.print("|");
		repPrint(" ", 23);
		System.out.print("|");
		repPrint(" ", 23);
		System.out.println("|");
		
		//Seventh Level (Fourth Data Level)
		repPrint(" ", 4);
		System.out.print(rootNode.left.left.left.data);
		repPrint("-", 4);
		System.out.print("^");
		repPrint("-", 4);
		System.out.print(rootNode.left.left.right.data);
		repPrint(" ", 11);
		System.out.print(rootNode.left.right.left.data);
		repPrint("-", 4);
		System.out.print("^");
		repPrint("-", 4);
		System.out.print(rootNode.left.right.right.data);
		repPrint(" ", 11);
		System.out.print(rootNode.right.left.left.data);
		repPrint("-", 4);
		System.out.print("^");
		repPrint("-", 4);
		System.out.print(rootNode.right.left.right.data);
		repPrint(" ", 11);
		System.out.print(rootNode.right.right.left.data);
		repPrint("-", 4);
		System.out.print("^");
		repPrint("-", 4);
		System.out.println(rootNode.right.right.right.data);
		
		
		//Eighth Level (Fourth Line Level)
		repPrint(" ", 4);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.print("|");
		repPrint(" ", 11);
		System.out.println("|");
		
		//Ninth Level (Fifth Data Level)
		System.out.print(rootNode.left.left.left.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.left.left.left.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.left.left.right.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.left.left.right.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.left.right.left.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.left.right.left.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.left.right.right.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.left.right.right.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.right.left.left.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.right.left.left.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.right.left.right.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.right.left.right.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.right.right.left.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.print(rootNode.right.right.left.right.data);
		repPrint(" ", 3);
		System.out.print(rootNode.right.right.right.left.data);
		repPrint("-", 2);
		System.out.print("^");
		repPrint("-", 2);
		System.out.println(rootNode.right.right.right.right.data);
	}
	
	public void repPrint(String unit, int repetition)
	{
		for (int i = 0; i < repetition; i ++)
		{
			System.out.print(unit);
		}
	}

	public int[] getHeapElements() 
	{
		return heapElements;
	}
	
	public int leftIndex(int indexInt)
	{
		return 2*indexInt;
	}
	
	public int righttIndex(int indexInt)
	{
		return 2*indexInt +1;
	}
	
	public boolean sift(Node index)
	{
		if (index.hasLeft() && index.hasRight())
		{
			int leftData = index.left.data, rightData = index.right.data, indexData = index.data, temp;
			if (!isMaxHeap(index))
			{
				if (leftData > rightData)
				{
					index.setData(leftData);
					index.left.setData(indexData);
					
					return true;
				}
				else if (leftData < rightData)
				{
					index.setData(rightData);
					index.right.setData(indexData);
					return true;
				}
			}
			return false;
		}
		else
		{
			return false;
		}
		

		
	}
	
	public boolean shift(Node index)
	{
		if (index.hasLeft() && index.hasRight())
		{
			int leftData = index.left.data, rightData = index.right.data, indexData = index.data, temp;
			if (!isMinHeap(index))
			{
				
				if (leftData > rightData)
				{
					index.setData(rightData);
					index.right.setData(indexData);
				}
				else if (leftData < rightData)
				{
					index.setData(leftData);
					index.left.setData(indexData);
				}
				if (index.left.getData() > index.right.getData())
				{
					temp = index.left.getData();
					index.left.setData(index.right.getData());
					index.right.setData(temp);
				}
					
				return true;
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	
	public boolean isTreeMaxHeap()
	{
		return isMaxHeapRecursive(getRootNode());
	}
	
	public boolean isTreeMinHeap()
	{
		return isMinHeapRecursive(getRootNode());
	}
	
	private boolean isMaxHeapRecursive(Node indexNode)
	{
		if(!indexNode.hasLeft())
		{
			return isMaxHeap(indexNode);
		}
		if (isMaxHeap(indexNode))
		{
			return isMaxHeapRecursive(indexNode.left) && isMaxHeapRecursive(indexNode.right);
		}
		else
		{
			return false;
		}
	}
	
	private boolean isMinHeapRecursive(Node indexNode)
	{
		if(!indexNode.hasLeft())
		{
			return isMinHeap(indexNode);
		}
		if (isMinHeap(indexNode))
		{
			return isMinHeapRecursive(indexNode.left) && isMinHeapRecursive(indexNode.right);
		}
		else
		{
			return false;
		}
	}
	
	
	public boolean isMaxHeap(Node index)
	{
		if(!index.hasRight())
		{
			return true;
		}
		if ((index.data > index.left.data) && (index.data > index.right.data))
		{
			return true;
		}
		return false;
	}
	
	public boolean isMinHeap(Node index)
	{
		if(!index.hasRight())
		{
			return true;
		}
		if ((index.data < index.left.data) && (index.data < index.right.data))
		{
			return true;
		}
		return false;
	}

	public void print()
	{
		int indexDepth = getDepth();
		for (int i = 1 ; i <= indexDepth; i++)
		{
			printLevel(getRootNode(), i);
		}
	}
	
	private void printLevel(Node indexNode, int indexLevel)
	{
		if (indexNode == null) 
            return; 
        if (indexLevel == 1) 
            System.out.print(indexNode.getData() + " ");
        else if (indexLevel > 1) 
        { 
            printLevel(indexNode.left, indexLevel-1); 
            printLevel(indexNode.right, indexLevel-1); 
        } 
	}
}
