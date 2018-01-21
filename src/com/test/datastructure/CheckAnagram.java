package com.test.datastructure;

//JAVA program to check whether two strings
//are anagrams of each other
import java.util.Arrays;

class CheckAnagram{
	 static int NO_OF_CHARS = 256;
 /* function to check whether two strings are 
 anagram of each other */
 static boolean areAnagram(char[] str1, char[] str2)
 {
     // Get lenghts of both strings
     int n1 = str1.length;
     int n2 = str2.length;

     // If length of both strings is not same,
     // then they cannot be anagram
     if (n1 != n2)
         return false;

     // Sort both strings
     quickSort(str1, 0, n1 - 1);
     quickSort(str2, 0, n2 - 1);

     // Compare sorted strings
     for (int i = 0; i < n1;  i++)
         if (str1[i] != str2[i])
             return false;

     return true;
 }

 // Following functions (exchange and partition 
 // are needed for quickSort)
 static void exchange(char A[],int a, int b)
 {
     char temp;
     temp = A[a];
     A[a]   = A[b];
     A[b]   = temp;
 }

 static int partition(char A[], int si, int ei)
 {
     char x = A[ei];
     int i = (si - 1);
     int j;
   
     for (j = si; j <= ei - 1; j++)
     {
         if(A[j] <= x)
         {
             i++;
             exchange(A, i, j);
         }
     }
     exchange (A, i+1 , ei);
     return (i + 1);
 }

 /* Implementation of Quick Sort
 A[] --> Array to be sorted
 si  --> Starting index
 ei  --> Ending index
 */
 static void quickSort(char A[], int si, int ei)
 {
     int pi;    /* Partitioning index */
     if(si < ei)
     {
         pi = partition(A, si, ei);
         quickSort(A, si, pi - 1);
         quickSort(A, pi + 1, ei);
     }
 }

 /* Driver program to test to print printDups*/
 public static void main(String args[])
 {
     char str1[] = {'t','e','s','t'};
     char str2[] = {'t','t','e','s'};
     if (areAnagram(str1, str2))
         System.out.println("The two strings are"+
                          " anagram of each other");
     else
         System.out.println("The two strings are not"+
                            " anagram of each other");
     
     char str3[] = ("geeksforgeeks").toCharArray();
     char str4[] = ("foageeksgeeks").toCharArray();
      
     if ( areAnagramUsingCountCharacters(str3, str4) )
         System.out.println("The two strings are" +
                            "anagram of each other");
     else
         System.out.println("The two strings are not"+
                            " anagram of each other");
 
 }
 
 static boolean areAnagramUsingCountCharacters(char str1[], char str2[])
 {
     // Create 2 count arrays and initialize
     // all values as 0
     int count1[] = new int [NO_OF_CHARS];
     //Arrays.fill(count1, 0);
     int count2[] = new int [NO_OF_CHARS];
     //Arrays.fill(count2, 0);
     int i;

     // For each character in input strings,
     // increment count in the corresponding
     // count array
     for (i = 0; i <str1.length && i < str2.length ;
                                              i++)
     {
         count1[str1[i]]++;
         count2[str2[i]]++;
     }

     // If both strings are of different length.
     // Removing this condition will make the program 
     // fail for strings like "aaca" and "aca"
     if (str1.length != str2.length)
         return false;

     // Compare count arrays
     for (i = 0; i < NO_OF_CHARS; i++)
         if (count1[i] != count2[i])
             return false;

     return true;
 }

}

