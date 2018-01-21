package com.programmingques;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueWithTwoStacks<Item> {
	    private Stack<Item> stack1;    // back of queue, end1, for push 
	    private Stack<Item> stack2;    // front of queue, end2, for pop

	    // create an empty queue
	    public QueueWithTwoStacks() {
	        stack1 = new Stack<Item>();
	        stack2 = new Stack<Item>();
	    }

	    // move all items from stack1 to stack2
	    private void moveStack1ToStack2() {
	        while (!stack1.isEmpty())
	            stack2.push(stack1.pop());
	    }

	    // is the queue empty?
	    public boolean isEmpty() {
	        return stack1.isEmpty() && stack2.isEmpty();
	    }


	    // return the number of items in the queue.
	    public int size() {
	        return stack1.size() + stack2.size();     
	    }

	    // return the item least recently added to the queue.
	    public Item peek() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        if (stack2.isEmpty()) moveStack1ToStack2();
	        return stack2.peek();
	    }

	    // add the item to the queue
	    public void enqueue(Item item) {
	        stack1.push(item);
	    }

	    // remove and return the item on the queue least recently added
	    public Item dequeue() {
	        if (isEmpty()) throw new NoSuchElementException("Queue underflow");
	        if (stack2.isEmpty()) moveStack1ToStack2();
	        return stack2.pop();
	    }

 
	    // a test client
	    public static void main(String[] args) {
	        QueueWithTwoStacks<String> q = new QueueWithTwoStacks<String>();
	        int[] items = {7, 2, 1, 9, 72};
	        for(int i=0; i<items.length; i++) {
	            String item = items[i]+"";
	            q.enqueue(item);
	            
	        }
	        while(q.size()>0)
	        if (!q.isEmpty()) System.out.println(q.dequeue() + " ");
	        System.out.println("(" + q.size() + " left on queue)");
	    }
	}

