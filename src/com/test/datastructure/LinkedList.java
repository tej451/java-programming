package com.test.datastructure;

import com.programmingques.MergeSort1;

public class LinkedList{

	private Node head;

	private static class Node {
		private int value;
		private Node next;

		Node(int value) {
			this.value = value;

		}

		public Node() 
		{}
	}

	public void addToTheLast(Node node) {

		if (head == null) {
			head = node;
		} else {
			Node temp = head;
			while (temp.next != null)
				temp = temp.next;

			temp.next = node;
		}
	}


	public void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.format("%d ", temp.value);
			temp = temp.next;
		}
		System.out.println();
	}

	// Reverse linkedlist using this function 
	public static Node reverseLinkedList(Node currentNode)
	{
		// For first node, previousNode will be null
		Node previousNode=null;
		Node nextNode;
		while(currentNode!=null)
		{
			nextNode=currentNode.next;
			// reversing the link
			currentNode.next=previousNode;
			// moving currentNode and previousNode by 1 node
			previousNode=currentNode;
			currentNode=nextNode;
		}
		return previousNode;
	}

	public static Node reverseLinkedListRecursive(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node remaining = reverseLinkedListRecursive(node.next);
		node.next.next = node;
		node.next = null;
		return remaining;
	}

	public static Node MergeSort(Node headOriginal){
		if (headOriginal == null || headOriginal.next == null)
			return headOriginal;
		Node a = headOriginal;
		Node b = headOriginal.next;
		while ((b != null) && (b.next != null))
		{
			headOriginal = headOriginal.next;
			b = (b.next).next;
		}
		b = headOriginal.next;
		headOriginal.next = null;
		return merge(MergeSort(a), MergeSort(b));
	}
	
	public static Node merge(Node a, Node b) 
	{
		Node head = new Node();
		Node c = head;
		while ((a != null) && (b != null)) 
		{
			if (a.value <= b.value) 
			{
				c.next = a;
				c = a;
				a = a.next;
			}
			else {
				c.next = b;
				c = b;
				b = b.next;
			}
		}
		c.next = (a == null) ? b : a;
		return head.next;
	}
	
	public static Node mergeRecursively(Node a, Node b) 
	{
		Node head = new Node();
		if (a == null) 
		     return(b);
		  else if (b==null) 
		     return(a);
		
		if (a.value <= b.value) 
		{
			head = a;
			head.next = mergeRecursively(a.next, b);
		}
		else {
			head = b;
			head.next = mergeRecursively(a, b.next);
		}
		return head;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		// Creating a linked list
		Node head=new Node(5);
		list.addToTheLast(head);
		list.addToTheLast(new Node(6));
		list.addToTheLast(new Node(7));
		list.addToTheLast(new Node(1));
		list.addToTheLast(new Node(2));

		list.printList(head);
		//Reversing LinkedList
		Node reverseHead=reverseLinkedList(head);
		System.out.println("After reversing");
		list.printList(reverseHead);

		list.printList(reverseHead);
		System.out.println("Recursive Reverse: ");
		Node recursiveReverseHead=reverseLinkedListRecursive(reverseHead);
		list.printList(recursiveReverseHead);

		System.out.println("Merge Sort for sorting linked list");
		Node sortedHead = MergeSort(recursiveReverseHead);
		list.printList(sortedHead);
		
		//merge two list 
		LinkedList list1 = new LinkedList();
		Node node1 = new Node(5);
		list1.addToTheLast(node1);
		list1.addToTheLast(new Node(10));
		list1.addToTheLast(new Node(15));
		
		LinkedList list2 = new LinkedList();
		Node node2 = new Node(2);
		list2.addToTheLast(node2);
		list2.addToTheLast(new Node(3));
		list2.addToTheLast(new Node(20));
		
	/*	Node mergeList = list1.merge(node1, node2);
		System.out.println("Merged List: ");
		list.printList(mergeList);*/
		
		Node mergeList1 = list1.mergeRecursively(node1, node2);
		System.out.println("Merged List using recursion: ");
		list.printList(mergeList1);
	}

}
