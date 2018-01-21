package com.test.datastructure;

import java.util.ArrayList;
import java.util.Stack;

//non-recursive java program for inorder traversal
/* Class containing left and right child of current 
	 node and key value*/

/* Class to print the inorder traversal */
class DFSTraversalWtRecursion {

	Node root;
	ArrayList<Integer> list = new ArrayList<Integer>();

	void inorder() {
		if (root == null) {
			return;
		}

		//keep the nodes in the path that are waiting to be visited
		Stack<Node> stack = new Stack<Node>();
		Node node = root;

		//first node to be visited will be the left one
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		// traverse the tree
		while (stack.size() > 0) {

			// visit the top node
			node = stack.pop();
			System.out.print(node.key + " ");
			if (node.right != null) {
				node = node.right;

				// the next node to be visited is the leftmost
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}
	
	public void preorderIteration(Node root) {
		Stack<Node> s = new Stack<Node>();
		while (true) {
			// First print the root node and then add left node
			while (root != null) {
				System.out.print(root.key + " ");
				s.push(root);
				root = root.left;
			}
			// check if Stack is emtpy, if yes, exit from everywhere
			if (s.isEmpty()) {
				return;
			}
			// pop the element from the stack and go right to the tree
			root = s.pop();
			root = root.right;
		}
	}
	
	ArrayList<Integer> postOrderIterative(Node node) 
    {
        Stack<Node> S = new Stack<Node>();
          
        // Check for empty tree
        if (node == null)
            return list;
        S.push(node);
        Node prev = null;
        while (!S.isEmpty()) 
        {
            Node current = S.peek();
  
            /* go down the tree in search of a leaf an if so process it 
            and pop stack otherwise move down */
            if (prev == null || prev.left == current || 
                                        prev.right == current) 
            {
                if (current.left != null)
                    S.push(current.left);
                else if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.key);
                }
  
                /* go up the tree from left node, if the child is right 
                   push it onto stack otherwise process parent and pop 
                   stack */
            } 
            else if (current.left == prev) 
            {
                if (current.right != null)
                    S.push(current.right);
                else
                {
                    S.pop();
                    list.add(current.key);
                }
                  
                /* go up the tree from right node and after coming back
                 from right node process parent and pop stack */
            } 
            else if (current.right == prev) 
            {
                S.pop();
                list.add(current.key);
            }
  
            prev = current;
        }
  
        return list;
    }
	
	public void postorderIterationUsingTwoStacks(Node root) {
		Stack<Node> s1 = new Stack<Node>();
		Stack<Node> s2 = new Stack<Node>();
		// push the root node into first stack.
		s1.push(root);
		while (s1.isEmpty() == false) {
			// take out the root and insert into second stack.
			Node temp = s1.pop();
			s2.push(temp);
			// now we have the root, push the left and right child of root into
			// the first stack.
			if(temp.left!=null){
				s1.push(temp.left);
			}
			if(temp.right!=null){
				s1.push(temp.right);
			}
		}
		//once the all node are traversed, take out the nodes from second stack and print it.
		System.out.println("Post-order Traversal: ");
		while(s2.isEmpty()==false){
			System.out.print(s2.pop().key);
		}
	}
	
	public void postOrderTraversal(){
		Stack<Node> nodes = new Stack<Node>();
		Node node = root;
		while(node != null){
			nodes.push(node);
			node = node.left;
		}
		while(!nodes.isEmpty()){
			Node temp = nodes.peek();
			Node right = temp.right;
			if(right != null){
				if(!nodes.contains(right)){
					nodes.push(right);
				}
				while(right.left != null){
					nodes.push(right.left);
					right = right.left;
				}
			}
			
			System.out.println();
		}
		
	}

	public static void main(String args[]) {

		/* creating a binary tree and entering 
	         the nodes */
		DFSTraversalWtRecursion tree = new DFSTraversalWtRecursion();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.left.left.left = new Node(6);
	    tree.root.left.left.right = new Node(7);
	    tree.root.left.right.left = new Node(8);
	    tree.root.right.left = new Node(9);
	    System.out.print("In-order Traversal: ");
	    tree.inorder();
		
		System.out.print("Pre-order Traversal: ");
		tree.preorderIteration(tree.root);
	    
		System.out.print("Post-order Traversal: ");
	    ArrayList list = tree.postOrderIterative(tree.root);
	    System.out.println(list.toString());
	    
	    
	}
}
