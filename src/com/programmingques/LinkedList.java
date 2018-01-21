package com.programmingques;

public class LinkedList {
	static Node head;

	static class Node{
		String data;
		Node next;
		
		public Node(String data){
			this.data = data;
			next = null;
		}
	}
	
	public void addAtStart(String data){
		Node node = new Node(data);
		node.next = head;
		head = node;
	}
	
	/*
	 * prevNode: 14->15->16
	 * newData: 17 
	 * prevNode: 14->17->15->16
	 */
	public void addAtGivenIndex(Node prevNode, String newData){
		if(prevNode == null){
			System.out.println("Node must be not null, no node available..");
		}
		Node newNode = new Node(newData);
		newNode.next = prevNode.next;
		prevNode.next = newNode; 
	}
	
	public void addAtLast(String newData){
		Node newNode = new Node(newData);
		if(head == null){
			head = newNode;
		}else{
			Node last = head;
			while(last.next != null){
				last = last.next;
			}
			last.next = newNode;
		}
	}
	
	public void printList(Node node){
		while(node.next != null){
			System.out.print(node.data + " -> ");
			node = node.next;
		}
		System.out.print(node.data);
		System.out.println();
	}
	
	public void deleteNode(Node node){
		Node nodeToBeDeleted = head;
		while(nodeToBeDeleted != node){
			nodeToBeDeleted = nodeToBeDeleted.next;
		}
		nodeToBeDeleted.data = nodeToBeDeleted.next.data;
		nodeToBeDeleted.next = nodeToBeDeleted.next.next;
	}
	
	public boolean isCyclic(){
		//floyd cycle detection algo
		Node a = head;
		Node b = head;
		int cycles = 0;
		while(b != null && b.next != null && b.next.next != null){
			cycles  = cycles+1;
			a = a.next;
			b = b.next.next;
			System.out.println("a - "+a.data+" b - "+b.data);
			if(a == b || a.equals(b)){
				System.out.println("loop has been detected.."+cycles+" "+a.data); // 17 loopnode
				removeLoop(head, a);
				return true;
			}
		}
		return false;
	}
	
	public void findMiddleOfLinkedList(){
		Node a = head;
		Node b = head;
		while(b != null && b.next != null && b.next.next != null){
			a = a.next;
			b = b.next.next;
			System.out.println("a - "+a.data+" b - "+b.data);
		}
		if(b == null || b.next == null || b.next.next == null){
			System.out.println("Middle element is a - "+a.data);
		}
	}
	
	public void findThirdFromLast(){
		Node a = head;
		Node b = head;
		while(b != null && b.next != null && b.next.next != null && b.next.next.next != null){
			a = a.next;
			b = b.next.next.next;
			System.out.println("a - "+a.data+" b - "+b.data);
		}
		System.out.println("third from last is a - "+b.data);
	}
	
	public void removeLoop(Node head, Node loopNode){
		Node curr = head;
		Node temp = null;
		while(true){
			temp = loopNode;
			while(temp.next != loopNode && temp.next != curr){
				temp = temp.next;
			}
			if(temp.next == curr){
				break;
			}
			curr = curr.next;
		}
		temp.next = null;
	}
	
	 void printNthFromLast(int n)
	    {
	        int len = 0;
	        Node temp = head;
	 
	        // 1) count the number of nodes in Linked List
	        while (temp != null)
	        {
	            temp = temp.next;
	            len++;
	        }
	 
	        // check if value of n is not more than length of
	        // the linked list
	        if (len < n)
	            return;
	 
	        temp = head;
	 
	        // 2) get the (n-len+1)th node from the begining
	        for (int i = 1; i < len-n+1; i++)
	            temp = temp.next;
	 
	        System.out.println(temp.data);
	    }
	 
	 /* Function to get the nth node from end of list */
	    void printNthFromLast1(int n)
	    {
	        Node main_ptr = head;
	        Node ref_ptr = head;
	 
	        int count = 0;
	        if (head != null)
	        {
	            while (count < n)
	            {
	                if (ref_ptr == null)
	                {
	                    System.out.println(n+" is greater than the no "+
	                                      " of nodes in the list");
	                    return;
	                }
	                ref_ptr = ref_ptr.next;
	                count++;
	            }
	            while (ref_ptr != null)
	            {
	                main_ptr = main_ptr.next;
	                ref_ptr = ref_ptr.next;
	            }
	            System.out.println("Node no. "+n+" from last is "+
	                               main_ptr.data);
	        }
	    }
}
