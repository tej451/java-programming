package com.programmingques;

import com.programmingques.LinkedList.Node;

public class LinkedListTest {
	public static void main(String args[]){
		LinkedList list = new LinkedList();
		list.head = new Node("10"); // add first node
		/*list.addAtStart(12); // add node at first 
		list.addAtGivenIndex(list.head, 11);*/
		//list.addAtLast(9);
		Node node11 = list.head.next = new Node("11");
		list.head.next.next = new Node("12");
		list.head.next.next.next = new Node("13");
		Node node14 = list.head.next.next.next.next = new Node("14");
		list.head.next.next.next.next.next = new Node("15");
		Node node16 = list.head.next.next.next.next.next.next = new Node("16");
		list.addAtGivenIndex(list.head.next.next.next.next, "17");
		//list.addAtLast(18);
		//list.addAtLast(19);
		list.printList(list.head);
		//node16.next = node11;
		//System.out.println(list.isCyclic()); // 7 iteration, a and b at 16
		//list.deleteNode(list.head.next.next); // delete 12 node
		list.printList(list.head);
		//introducing cycles 
		//node16.next = node14;
		 
		 /* 10 -> 11 -> 13 -> 14 -> 17 -> 15 -> 16 /-> 14 -> 17 -> 15 -> 16 ->/ 14 -> 17 -> 15 -> 16 ->
		 *  14 -> 17 -> 15 -> 16
		 */
		//list.printList(list.head); 
		System.out.println(list.isCyclic());
		list.printList(list.head);
		list.findMiddleOfLinkedList();
		list.printNthFromLast(3);
		list.printNthFromLast1(4);
	}
}
