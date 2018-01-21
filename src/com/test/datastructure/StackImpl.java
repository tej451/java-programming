package com.test.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class StackImpl implements Iterable<Object> {
	private int size, length;
	private int[] stackArray;
	private int top;

	public StackImpl(int s) {
		size = s;
		stackArray = new int[size];
		top = -1;
	}
	
	public void push(int j) {
        if(top + 1 >= size)
        	throw new IndexOutOfBoundsException("Overflow Exception");
		stackArray[++top] = j;
		length++;
	}
	
	public int pop() {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
		length--;
		int returnedVal = stackArray[top];
		stackArray[top--] = 0;
		return returnedVal;
	}
	
	public int peek() {
        if( isEmpty() )
            throw new NoSuchElementException("Underflow Exception");
		return stackArray[top];
	}
	
	public boolean isEmpty() {
		return (top == -1);
	}
	
	public boolean isFull() {
		return (top == size - 1);
	}
	
    public int getSize()
    {
        return length ;
    }
	
    public void display()
    {
        System.out.print("\nStack = ");
        if (length == 0)
        {
            System.out.print("Empty\n");
            return ;
        }
        for (int i = top; i >= 0; i--)
            System.out.print(stackArray[i]+" ");
        System.out.println();
    }    
    
   /* @Override
	public boolean hasNext() {
    	if(length>0 && length<size && top>-1)
			return true;
		return false;
	}
    
	@Override
	public Integer next() {
		 if( isEmpty() )
	            throw new NoSuchElementException("Underflow Exception");
		 	int lastReturned = top;
		 	top--;
		 	length--;
			return stackArray[lastReturned];
		
	}*/
    
    @Override
	public Iterator<Object> iterator() {
		return new StackIterator();
	}
    
    class StackIterator<Integer> implements Iterator<Object>{

    	@Override
    	public boolean hasNext() {
        	if(length>0 && length<size && top>-1)
    			return true;
    		return false;
    	}
        
    	@Override
    	public Object next() {
    		 if( isEmpty() )
    	            throw new NoSuchElementException("Underflow Exception");
    		 	int lastReturned = top;
    		 	top--;
    		 	length--;
    			return stackArray[lastReturned];
    		
    	}
    	
    }
    
	public static void main(String[] args) {
		StackImpl theStack = new StackImpl(10); 
		theStack.push(10);
		theStack.push(20);
		theStack.push(30);
		theStack.push(40);
		theStack.push(50);

		System.out.println("Stack elements: ");
		theStack.display();
		
		long value = theStack.pop();
		System.out.println("POP: "+value);
		
		/*while (!theStack.isEmpty()) {
			long value = theStack.pop();
			System.out.print(value);
			System.out.print(" ");
		}
		System.out.println("");*/
		
		for (Object animalObj : theStack) {
			System.out.println("Using Iterable: "+animalObj);
		}
		
		/*while(theStack.hasNext()){
			Integer stack = (Integer)theStack.next();
			System.out.println("Element: "+stack);
		}*/
		
		theStack.display();
	}
	
	
}
