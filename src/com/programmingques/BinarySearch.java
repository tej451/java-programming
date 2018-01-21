package com.programmingques;

import java.util.Arrays;
import java.util.Scanner;

class BinarySearch 
{
  public static void main(String args[])
  {
	  int[] arr = {34,87,23,76,1,0,4,55,34,45,78,3};
	  Arrays.sort(arr);
	  System.out.print("Sorted arr - ");
	  for(int i=0; i<arr.length; i++){
		  System.out.print(arr[i]+" , ");
	  }
	  System.out.println("\n");
	  rangeCheck(arr.length, 0, arr.length);
	  int index = binarySearch0(arr, 0, arr.length, 76);
	  System.out.println("Found at: "+index);
  }
  
  private static void rangeCheck(int arrayLength, int fromIndex, int toIndex) {
      if (fromIndex > toIndex) {
          throw new IllegalArgumentException(
                  "fromIndex(" + fromIndex + ") > toIndex(" + toIndex + ")");
      }
      if (fromIndex < 0) {
          throw new ArrayIndexOutOfBoundsException(fromIndex);
      }
      if (toIndex > arrayLength) {
          throw new ArrayIndexOutOfBoundsException(toIndex);
      }
  }
  
  private static int binarySearch0(int[] a, int fromIndex, int toIndex,
		  int key) {
	  int low = fromIndex;
	  int high = toIndex - 1;

	  while (low <= high) {
		  int mid = (low + high) >>> 1;
		  /*System.out.println(low+"- "+ high+" - "+mid);
		  System.out.println("val");
		  System.out.println(14 << 1);*/
		  int midVal = a[mid];

		  if (midVal < key)
			  low = mid + 1;
		  else if (midVal > key)
			  high = mid - 1;
		  else
			  return mid; // key found
	  }
	  return -(low + 1);  // key not found.
  }
  
  
}
