package edu.csulb.cecs274;

public class Node {
	
	Node parent = null;
	Node left;
	Node right;
	int data;
	
	public Node()
	{
		
	}
	
	/**Allows the creation of a node while defining the parent of the node.
	 * 
	 * @param Parent - the parent of the node to be constructed
	 */
	public Node(Node Parent)
	{
		parent = Parent;
		
	}
	
	/**Creates a node with the integer established as the data
	 * 
	 * @param input - the integer desired to be the data.
	 */
	public Node (int input)
	{
		data = input;
	}
	
	/**States whether the node has a left node connected
	 * 
	 * @return boolean - whether or not the node has a left node
	 */
	public boolean hasLeft()
	{
		if (getLeft() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**States whether the node has a right node connected
	 * 
	 * @return boolean - whether or not the node has a right node
	 */
	public boolean hasRight()
	{
		if (getRight() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**returns the left node
	 * 
	 * @return Node - left Node
	 */
	public Node getLeft() 
	{
	return left;
	}
	
	/**returns the right node
	 * 
	 * @return Node - right Node
	 */
	public Node getRight() 
	{
	return right;
	}
	
	/**returns the data of a node
	 * 
	 * @return int - the data of a node
	 */
	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
	
}
