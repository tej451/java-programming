package com.programmingques;

import java.util.ArrayList;
import java.util.List;

public class ArrayTest1 {
	
	private static int numberOfPaths(int m, int n)
	{
		ArrayList l = new ArrayList<>();
		getTest(l);
	    // Create a 2D table to store results of subproblems
	    int arr[][] ={{1,2,3},{4,5,6},{7,8,9}};
	 /*
	    // Count of paths to reach any cell in first column is 1
	    for (int i = 0; i < m; i++)
	        arr[i][0] = 1;
	 
	    // Count of paths to reach any cell in first column is 1
	    for (int j = 0; j < n; j++)
	        arr[0][j] = 1;*/
	 
	    // Calculate count of paths for other cells in bottom-up manner using
	    // the recursive solution
	    for (int i = 1; i < m; i++)
	    {
	        for (int j = 1; j < n; j++)
	 
	            // By uncommenting the last part the code calculatest he total
	            // possible paths if the diagonal Movements are allowed
	            arr[i][j] = arr[i-1][j] + arr[i][j-1]; //+ count[i-1][j-1];
	 
	    }
	    return arr[m][n];
	}
	 
	// Driver program to test above functions
	public static void main(String args[])
	{
		char[][] arr = {{'1','2','3','4'}};
		LinkedList l = new LinkedList();
	    System.out.println(numberOfPaths(0, 2));
	    
	}
	
	public static void getTest(List l){
		
	}
}
