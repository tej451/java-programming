package com.test.datastructure;

public class LCAInBST 
{
    Node root;
      
    /* Function to find LCA of n1 and n2. The function assumes that both
       n1 and n2 are present in BST 
       
       Time complexity of above solution is O(h) where h is height of tree. Also, the above solution requires O(h)
        extra space in function call stack for recursive function calls. We can avoid extra space using iterative 
        solution.*/
    Node lca(Node node, int n1, int n2) 
    {
        if (node == null)
            return null;
  
        // If both n1 and n2 are smaller than root, then LCA lies in left
        if (node.key > n1 && node.key > n2)
            return lca(node.left, n1, n2);
  
        // If both n1 and n2 are greater than root, then LCA lies in right
        if (node.key < n1 && node.key < n2) 
            return lca(node.right, n1, n2);
  
        return node;
    }
  
    /* Driver program to test lca() */
    public static void main(String args[]) 
    {
        // Let us construct the BST shown in the above figure
        LCAInBST tree = new LCAInBST();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(22);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
  
        int n1 = 10, n2 = 14;
        Node t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
  
        n1 = 14;
        n2 = 8;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
  
        n1 = 10;
        n2 = 22;
        t = tree.lca(tree.root, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.key);
  
    }
}
