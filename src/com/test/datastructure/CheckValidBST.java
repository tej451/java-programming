package com.test.datastructure;

public class CheckValidBST
{
    //Root of the Binary Tree
    Node root;
    
    Node prev;
    
    /* can give min and max value according to your code or
    can write a function to find min and max value of tree. */
 
    /* returns true if given search tree is binary
     search tree (efficient version) */
    boolean isBST()  {
        return isBSTUtil(root, Integer.MIN_VALUE,
                               Integer.MAX_VALUE);
    }
 
    /* Returns true if the given tree is a BST and its
      values are >= min and <= max. 
      Time Complexity: O(n)*/
    boolean isBSTUtil(Node node, int min, int max)
    {
        /* an empty tree is BST */
        if (node == null)
            return true;
 
        /* false if this node violates the min/max constraints */
        if (node.key < min || node.key > max)
            return false;
 
        /* otherwise check the subtrees recursively
        tightening the min/max constraints */
        // Allow only distinct values
        return (isBSTUtil(node.left, min, node.key-1) &&
                isBSTUtil(node.right, node.key+1, max));
    }
    
    /*
     * (Using In-Order Traversal)
     * Do In-Order Traversal of the given tree and store the result in a temp array.
     * Check if the temp array is sorted in ascending order, if it is, then the tree is BST.

		Time Complexity: O(n)
     */
    /* Returns true if given search tree is binary
    search tree (efficient version) */
    boolean isBSTUsingInorder(Node node)
    {
    	// traverse the tree in inorder fashion and
    	// keep a track of previous node
    	if (node != null)
    	{
    		if (!isBSTUsingInorder(node.left))
    			return false;

    		// allows only distinct values node
    		if (prev != null && node.key <= prev.key )
    			return false;
    		prev = node;
    		return isBSTUsingInorder(node.right);
    	}
    	return true;
    } 
    
    
    /* Driver program to test above functions */
    public static void main(String args[])
    {
        CheckValidBST tree = new CheckValidBST();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
 
        if (tree.isBST())
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
        
        if(tree.isBSTUsingInorder(tree.root))
        	System.out.println("Is BST using inorder");
        else
        	System.out.println("Not a BST using inorder");
    }
}
