package com.test.datastructure;
/*
 * If both nodes are at same level and if we traverse up using parent pointers of both nodes, the first common node in the path to root is lca.
The idea is to find depths of given nodes and move up the deeper node pointer by the difference between depths. Once both nodes reach same level, traverse them up and return the first common node.
 */
class Node1 
{
    int key;
    Node1 left, right, parent;
 
    Node1(int key) 
    {
        this.key = key;
        left = right = parent = null;
    }
}
public class FindLCAUsingParent {
	
	 Node1 root, n1, n2, lca;
	 
	    /* A utility function to insert a new node with
	       given key in Binary Search Tree */
	    Node1 insert(Node1 node, int key) 
	    {
	        /* If the tree is empty, return a new node */
	        if (node == null)
	            return new Node1(key);
	 
	        /* Otherwise, recur down the tree */
	        if (key < node.key) 
	        {
	            node.left = insert(node.left, key);
	            node.left.parent = node;
	        } 
	        else if (key > node.key) 
	        {
	            node.right = insert(node.right, key);
	            node.right.parent = node;
	        }
	 
	        /* return the (unchanged) node pointer */
	        return node;
	    }
	
	// A utility function to find depth of a node
    // (distance of it from root)
    int depth(Node1 node) 
    {
        int d = -1;
        while (node != null) 
        {
            ++d;
            node = node.parent;
        }
        return d;
    }
 
    // To find LCA of nodes n1 and n2 in Binary Tree
    Node1 LCA(Node1 n1, Node1 n2) 
    {
        // Find depths of two nodes and differences
        int d1 = depth(n1), d2 = depth(n2);
        int diff = d1 - d2;
 
        // If n2 is deeper, swap n1 and n2
        if (diff < 0) 
        {
            Node1 temp = n1;
            n1 = n2;
            n2 = temp;
            diff = -diff;
        }
 
        // Move n1 up until it reaches the same level as n2
        while (diff-- != 0)
            n1 = n1.parent;
 
        // Now n1 and n2 are at same levels
        while (n1 != null && n2 != null) 
        {
            if (n1 == n2)
                return n1;
            n1 = n1.parent;
            n2 = n2.parent;
        }
 
        return null;
    }
    
    public static void main(String[] args) 
    {
    	FindLCAUsingParent tree = new FindLCAUsingParent();
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 22);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 12);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 14);
 
        tree.n1 = tree.root.left.right.left;
        tree.n2 = tree.root.right;
        tree.lca = tree.LCA(tree.n1, tree.n2);
 
        System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key
                + " is " + tree.lca.key);
        
        tree.n2 = tree.root.left.right.right;
        tree.n1 = tree.root.left;
        tree.lca = tree.LCA(tree.n1, tree.n2);
 
        System.out.println("LCA of " + tree.n1.key + " and " + tree.n2.key
                + " is " + tree.lca.key);
    }
}
