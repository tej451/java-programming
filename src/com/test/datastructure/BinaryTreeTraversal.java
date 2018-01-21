package com.test.datastructure;

import java.util.LinkedList;
import java.util.Queue;
/*          1
 *    2             3
 *4      5
 * 
 * 
 * Depth First Traversals:
(a) Inorder (Left, Root, Right) : 4 2 5 1 3
(b) Preorder (Root, Left, Right) : 1 2 4 5 3
(c) Postorder (Left, Right, Root) : 4 5 2 3 1

Breadth First or Level Order Traversal : 1 2 3 4 5

Uses of Preorder-
Preorder traversal is used to create a copy of the tree. Preorder traversal is also used to get prefix expression 
on of an expression tree, prefix expression is the operators still precede their operands like 1+2 can be written as '+12'
and (5 − 6) * 7 => * (− 5 6) 7

Uses of Postorder
Postorder traversal is used to delete the tree. Please see the question for deletion of tree for details. Postorder 
traversal is also useful to get the postfix expression of an expression tree. 
 
 Uses of Inorder
In case of binary search trees (BST), Inorder traversal gives nodes in non-decreasing order. To get nodes of BST 
in non-increasing order, a variation of Inorder traversal where Inorder itraversal s reversed, can be used.
 */
import java.util.concurrent.ArrayBlockingQueue;



/* Class containing left and right child of current
node and key value*/


class BinaryTreeTraversal
{
 // Root of Binary Tree
 Node root;

 BinaryTreeTraversal()
 {
     root = null;
 }

 /* START
  * Implementation of Depth First Traversal 
  */
 
 /* Given a binary tree, print its nodes according to the
   "bottom-up" postorder traversal. */
 void printPostorder(Node node)
 {
     if (node == null)
         return;

     // first recur on left subtree
     printPostorder(node.left);

     // then recur on right subtree
     printPostorder(node.right);

     // now deal with the node
     System.out.print(node.key + " ");
 }

 /* Given a binary tree, print its nodes in inorder*/
 void printInorder(Node node)
 {
     if (node == null)
         return;

     /* first recur on left child */
     printInorder(node.left);

     /* then print the data of node */
     System.out.print(node.key + " ");

     /* now recur on right child */
     printInorder(node.right);
 }

 /* Given a binary tree, print its nodes in preorder*/
 void printPreorder(Node node)
 {
     if (node == null)
         return;

     /* first print data of node */
     System.out.print(node.key + " ");

     /* then recur on left sutree */
     printPreorder(node.left);

     /* now recur on right subtree */
     printPreorder(node.right);
 }

 // Wrappers over above recursive functions
 void printPostorder()  {     printPostorder(root);  }
 void printInorder()    {     printInorder(root);   }
 void printPreorder()   {     printPreorder(root);  }

 /* END
  * Implementation of Depth First Traversal 
  */
 
 /* START
  * Implementation of Breadth First Traversal 
  */
 void printLevelOrder()
 {
     int h = height(root);
     int i;
     for (i=1; i<=h; i++)
         printGivenLevel(root, i);
 }

 /* Compute the "height" of a tree -- the number of
 nodes along the longest path from the root node
 down to the farthest leaf node.*/
 int height(Node root)
 {
     if (root == null)
        return 0;
     else
     {
         /* compute  height of each subtree */
         int lheight = height(root.left);
         int rheight = height(root.right);
          
         /* use the larger one */
         if (lheight > rheight)
             return(lheight+1);
         else return(rheight+1); 
     }
 }

 /* Print nodes at the given level */
 void printGivenLevel (Node root ,int level)
 {
     if (root == null)
         return;
     if (level == 1)
         System.out.print(root.key + " ");
     else if (level > 1)
     {
         printGivenLevel(root.left, level-1);
         printGivenLevel(root.right, level-1);
     }
 }

 /* END
  * Implementation of Breadth First Traversal 
 */
 
 /* START
  * Implementation of Breadth First Traversal Using queue and in O(n) time complexity
 */
 void printLevelOrderUsingQueue() 
 {
     Queue<Node> queue = new LinkedList<Node>();
     queue.add(root);
     while (!queue.isEmpty()) 
     {

         /* poll() removes the present head.
         For more information on poll() visit 
         http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
         Node tempNode = queue.poll();
         System.out.print(tempNode.key + " ");

         /*Enqueue left child */
         if (tempNode.left != null) {
             queue.add(tempNode.left);
         }

         /*Enqueue right child */
         if (tempNode.right != null) {
             queue.add(tempNode.right);
         }
     }
 }
 
 /* END
  * Implementation of Breadth First Traversal Using queue and in O(n) time complexity
 */

 
 public static void main(String[] args)
 {
     BinaryTreeTraversal tree = new BinaryTreeTraversal();
     tree.root = new Node(1);
     tree.root.left = new Node(2);
     tree.root.right = new Node(3);
     tree.root.left.left = new Node(4);
     tree.root.left.right = new Node(5);
     tree.root.left.left.left = new Node(6);
     tree.root.left.left.right = new Node(7);
     tree.root.left.right.left = new Node(8);
     tree.root.right.left = new Node(9);

     /*
      * Time Complexity: O(n) for all DFS cases
      */
     System.out.println("Preorder traversal of binary tree is ");
     tree.printPreorder();

     System.out.println("\nInorder traversal of binary tree is ");
     tree.printInorder();

     System.out.println("\nPostorder traversal of binary tree is ");
     tree.printPostorder();
     
     /*
      * Time Complexity: O(n^2) in worst case. For a skewed tree, printGivenLevel() takes O(n) time where n is the number of nodes in the skewed tree. 
      * So time complexity of printLevelOrder() is O(n) + O(n-1) + O(n-2) + .. + O(1) which is O(n^2).
      */
     System.out.println("\nBFS traversal of binary tree is ");
     tree.printLevelOrder();
     
     //Using queue, O(n) where n is number of nodes in the binary tree
     System.out.println("\nBFS traversal of binary tree using queue is ");
     tree.printLevelOrderUsingQueue();
 }
}
