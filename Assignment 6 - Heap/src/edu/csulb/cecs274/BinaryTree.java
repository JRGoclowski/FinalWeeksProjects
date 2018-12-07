package edu.csulb.cecs274;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class BinaryTree {
	
	static int numberOfElements;
	//static int[] arrayOfElements;
	static ArrayList<Integer> arrayListOfElements = new ArrayList<Integer>(); 
	private Node root;
	
	/**Sets a new binary tree with an empty root
	 * 
	 */
	public BinaryTree()
	{
		root = null;
	}
	
	/*
	 * 
	 * @return boolean, if the tree is empty
	 */
	public boolean isEmpty()
	{
		numberOfElements = arrayListOfElements.size();
		return numberOfElements == 0;
	}
	
	
	
	/**Gets the node that is the parent of the node with the given integer
	 * using a helper method
	 * 
	 * @param targetInt - the integer of the node for which the parent node is desired.
	 * @return Node - parent node of target in tree.
	 */
	public Node getNodeParent(int targetInt)
	{
		Node searchNode = new Node(targetInt);
		return getNodeParent(searchNode);
	}
	
	/**Gets the node that is the parent of the given node, allows for 
	 * climbing the tree toward the root
	 * 
	 * @param targetNode - the given node to be searched for in the tree.
	 * @return	Node - the parent node of the targetNode
	 */
	public Node getNodeParent(Node targetNode)
	{
		if (targetNode.parent != null)
		{
			return targetNode.parent;
		}
		else if (search(targetNode.data))
		{
			Node index = root;
			Node parent = root;
			while (index != null)
			{
				int data = index.data;
				if (data == targetNode.data)
				{
					index.parent = parent;
					return parent;
				}
				else if (targetNode.data > data)
				{
					parent = index;
					index = index.right;
				}
				else
				{
					parent = index;
					index = index.left;
					
				}
				
			}
			
			return parent;
		}
		
		else
		{
			return root;
		}
	}
	
	/**Using the array list of elements in the tree, splits them into two even lists, 
	 * with the center element being the root, and then adding them back to the tree 
	 * by alternating between the list that is less than center and greater than center
	 * and adding the middle element from that list until both are empty.
	 * 	
	 */
	public void balanceTree()
	{
		Collections.sort(arrayListOfElements);
		int centerPoint, elementCount;
		ArrayList<Integer> listCopy = new ArrayList<Integer>();
		ArrayList<Integer> firstHalf = new ArrayList<Integer>();
		ArrayList<Integer> secondHalf = new ArrayList<Integer>();
		for (int i = 0; i < arrayListOfElements.size(); i ++)
		{
			listCopy.add(arrayListOfElements.get(i));
		}
		elementCount = arrayListOfElements.size();
		centerPoint = listCopy.remove(elementCount/2);
		root = new Node(centerPoint);
		for (int k = 0; k < elementCount/2 ; k++)
		{
			firstHalf.add(listCopy.remove(0)); 
		}
		while(!listCopy.isEmpty())
		{
			secondHalf.add(listCopy.remove(0));
		}
		for (int i = elementCount; i > 1; i --)
		{
			
			if(i%2 == 0)
			{
				add(firstHalf.remove(firstHalf.size()/2));
			}
			else
			{
				add(secondHalf.remove(secondHalf.size()/2));
			}
			
			elementCount = firstHalf.size() + secondHalf.size();
		}
	}

	/**Adds the integer to the tree if the integer is not already an element of the tree
	 * using a recursive helper method that seeks for its position in the tree, 
	 * and adds that integer to the array list of elements. If the integer is already
	 * an element in the tree, it is not added
	 * 
	 * @param addInt - the integer to be added
	 * @return boolean - returns whether or not the element was added to the tree
	 */
	public boolean add (int addInt)
	{
		if (!search(addInt))
		{
			Node addition = new Node();
			addition.data = addInt;
			numberOfElements +=1;
			
			if (root == null)
			{
				root = addition; 
			}
			else
			{
				addNode(addition, root);
			}
			arrayListOfElements.add(addInt);
			Collections.sort(arrayListOfElements);
			return true;
		}
		else
		{
			return false;
		}			
	}
	
	/**Recursive helper method that adds the desired integer to the tree 
	 * in the first appropriate position
	 * 
	 * @param addition - the node to be added to the tree
	 * @param indexNode - the current position in the tree, which is updated when the method recurs
	 */
	public void addNode(Node addition, Node indexNode)
	{
		Node index = indexNode;
		if (addition.data > index.data)
		{
			if (index.right == null)
			{
				index.right = addition;
			}
			else
			{
				addNode(addition, index.right);
			}
		}
		else if (addition.data < index.data)
		{
			if (index.left == null)
			{
				index.left = addition;
			}
			else
			{
				addNode(addition, index.left);
			}
		}
	}
	
	/**Removes the node from the tree if it is found
	 * and connects adjacent nodes appropriately
	 * 
	 * @param targetInt - the integer that is to be removed
	 * @return boolean - returns whether or not the node was deleted from the tree
	 */
	public boolean deleteNode (int targetInt)
	{
		Node deletion = root;
		Node parent = null;
		boolean containsInt = search(targetInt);
		boolean targetReached;
		//Check if tree has the Target
		if (containsInt == false)
		{
			return false;
		}
		
		else
		{
			targetReached = false;			
		}
		//Find the node, given it is in the tree
		while (!targetReached)
		{
			int data = deletion.data;
			if (data == targetInt)
			{
				targetReached = true;
			}
			else if (targetInt > data)
			{
				parent = deletion;
				deletion = deletion.right;
				
			}
			else
			{
				parent = deletion;
				deletion = deletion.left;
			}			
		}
		//Case 1: The node has no children
		if (!deletion.hasLeft() && !deletion.hasRight())
		{
			if (deletion.data > parent.data)
			{
				parent.right = null;
			}
			else
			{
				parent.left = null;
			}
		}
		
		
		//Case 2: The node has 1 child
		else if ((deletion.hasRight() || deletion.hasLeft()) 
				&& !(deletion.hasRight() && deletion.hasLeft()))
		{
			Node childToSave;
			
			if (deletion.hasRight())
			{
				childToSave = deletion.right;
			}
			else
			{
				childToSave = deletion.left;
			}
			
			if (deletion.data > parent.data)
			{
				parent.right = childToSave;
			}
			else
			{
				parent.left = childToSave;;
			}
		}
		//Case 3: The node has 2 children
		else
		{
			Node indexParent, indexNode;
			indexNode = deletion.right;
			indexParent = getNodeParent(indexNode);
			while (indexNode.hasLeft())
			{
				indexParent = indexNode;
				indexNode = indexNode.left;
			}
			deletion.data = indexNode.data;
			if (indexParent.equals(deletion))
			{
				indexParent.right = indexNode.right;
			}
			else
			{
				indexParent.left = indexNode.right;
			}
			
		}
		arrayListOfElements.remove(targetInt);
		return true;
	}
	
	
	/**returns the number of elements in the tree
	 * 
	 * @return int - number of elements in the tree
	 */
	public int getNumberOfElements() {
		return arrayListOfElements.size();
	}

	/**Searches the tree for the given integer, and states whether it is in the tree or not
	 *  
	 * @param targetInt - the integer to be searched for
	 * @return boolean - whether or not the integer is in the tree
	 */
	public boolean search(int targetInt)
	{
		Node index = root;
		while (index != null)
		{
			int data = index.data;
			if (data == targetInt)
			{
				return true;
			}
			else if (targetInt > data)
			{
				index = index.right;
			}
			else
			{
				index = index.left;
			}
		}
		return false;
	}
	
	/**prints the tree using a recursive helper method
	 * 
	 */
	public void print()
	{
		print(root);
	}
	
	/**Seeks for a leaf, and the prints it by working from left to right
	 * 
	 * @param index - the current position in the tree for the recursive method 
	 */
	private static void print(Node index)
	{
		if (index == null)
		{
			return;
		}
		print(index.left);
		System.out.print(index.data + " ");
		print(index.right);
	}
	
	/**Gets the depth of the entire tree by starting from the root, and
	 * working down until it gets to the lowest point of the tree
	 * 
	 * @return integer - the depth of the tree
	 */
	public int getDepth()
	{
		return getDepth(root);
	}
	
	/**Recursive method that searches all the way down a branch and compares the values
	 * to find the deepest position in the tree.
	 * 
	 * @param indexNode - the current spot in the tree by which to compare 
	 * @return int - returns the depth to the bottom from the current node in the tree
	 */
	public int getDepth(Node indexNode)
	{
		if (indexNode.right!=null && indexNode.left!=null)
        {                                       
            int right = getDepth(indexNode.right); 
            int left = getDepth(indexNode.left);
            if (left>=right)         
                return left + 1;
            return 1 + right;
        }
        if (indexNode.right!=null)                
            return 1 + getDepth(indexNode.right);     
        if (indexNode.left!=null)                  
            return getDepth(indexNode.left) + 1;     
        return 1;
	}
	
	/**returns the root element of the tree.
	 * 
	 * @return root data
	 */
	public int getRoot()
	{
		return root.data;
	}
	
	public Node getRootNode()
	{
		return root;
	}
	
	/**gets the level of the tree at which the searched element is located
	 * 
	 * @param targetInt - the element to be searched for
	 * @return integer - the level of the tree that the element is in 
	 */
	public int getIndexLevel(int targetInt)
	{
		if (search(targetInt))
		{
			Node index = root;
			int indexLevel = 0;
			while (index != null)
			{
				int data = index.data;
				if (data == targetInt)
				{
					return indexLevel;
				}
				else if (targetInt > data)
				{
					index = index.right;
					indexLevel +=1;
				}
				else
				{
					index = index.left;
					indexLevel +=1;
				}
			}
			return indexLevel;
		}
		else
		{
			return -1;
		}
	}

	
	public void setRoot(Node root) {
		this.root = root;
	}
	
	
}

