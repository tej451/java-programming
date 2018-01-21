package com.test.datastructure;

import java.util.ArrayList;

public class KStacks
{
	ArrayList<Integer> arr;   // Array of size n to store actual content to be stored in stacks
	ArrayList<Integer> top;   // Array of size k to store indexes of top elements of stacks
	ArrayList<Integer> next;  // Array of size n to store next entry in all stacks
	
	// and free list
	int n, k;
	int free; // To store beginning index of free list

	// A utility function to check if there is space available
	public boolean isFull()   {  return (free == -1);  }

	// To check whether stack number 'sn' is empty or not
	public boolean isEmpty(int sn)  {  return (top.get(sn) == -1); }

	//constructor to create k stacks in an array of size n
	public KStacks(int k1, int n1)
	{
		// Initialize n and k, and allocate memory for all arrays
		this.k = k1;
		this.n = n1;
		arr = new ArrayList<Integer>(n);
		top = new ArrayList<Integer>(k);
		next = new ArrayList<Integer>(n);

		// Initialize all stacks as empty
		for (int i = 0; i < k; i++)
			top.add(i, -1);

		// Initialize all spaces as free
		free = 0;
		for (int i=0; i<n-1; i++)
			next.add(i, i+1);
		next.add(n-1, -1);  // -1 is used to indicate end of free list
	}

	// To push an item in stack number 'sn' where sn is from 0 to k-1
	public void push(int item, int sn)
	{
		// Overflow check
		if (isFull())
		{
			System.out.println("Stack Overflow\n");
			return;
		}

		int i = free;      // Store index of first free slot

		// Update index of free slot to index of next slot in free list
		free = next.get(i);

		// Update next of top and then top for stack number 'sn'
		next.set(i, top.get(sn));
		top.set(sn, i);

		// Put the item in array
		arr.add(i, item);
	}

	// To pop an from stack number 'sn' where sn is from 0 to k-1
	public int pop(int sn)
	{
		// Underflow check
		if (isEmpty(sn))
		{
			System.out.println("Stack Underflow\n");
			return Integer.MAX_VALUE;
		}


		// Find index of top item in stack number 'sn'
		int i = top.get(sn);

		top.set(sn, next.get(i));  // Change top to store next of previous top

		// Attach the previous top to the beginning of free list
		next.set(i, free);
		free = i;

		// Return the previous top item
		return arr.remove(i);
	}

	/* Driver program to test twStacks class */
	public static void main(String[] args) {
		// Let us create 3 stacks in an array of size 10
		int k = 3, n = 10;
		KStacks ks = new KStacks(k, n);

		// Let us put some items in stack number 2
		ks.push(15, 2);
		ks.push(45, 2);

		// Let us put some items in stack number 1
		ks.push(17, 1);
		ks.push(49, 1);
		ks.push(39, 1);

		// Let us put some items in stack number 0
		ks.push(11, 0);
		ks.push(9, 0);
		ks.push(7, 0);

		System.out.println("Popped element from stack 2 is " + ks.pop(2));
		ks.push(19, 2);
		System.out.println("Popped element from stack 1 is " + ks.pop(1));
		ks.push(47, 1);
		System.out.println("Popped element from stack 0 is " + ks.pop(0));

	}
}

