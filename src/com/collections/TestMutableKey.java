package com.collections;

import java.util.HashMap;

public class TestMutableKey
{
	//eg of creating a immutable object
    public static void main(String[] args)
    {
        //Create a HashMap with mutable key
        HashMap<Account, String> map = new HashMap<Account, String>();
          
        //Create key 1
        Account a1 = new Account(1);
        a1.setHolderName("A_ONE");
        //Create key 2
        Account a2 = new Account(2);
        a2.setHolderName("A_TWO");
          
        //Put mutable key and value in map
        map.put(a1, "Shruti");
        map.put(a2, "Singh");
          
        //Change the keys state so hash map should be calculated again
        a1.setHolderName("Defaulter");
        a2.setHolderName("Bankrupt");
          
        //Success !! We are able to get back the values
        System.out.println(map.get(a1)); //Prints Shruti
        System.out.println(map.get(a2)); //Prints Singh
          
        //Try with newly created key with same account number
        Account a3 = new Account(1);
        a3.setHolderName("A_THREE");
          map.put(a3, "SS");
        //Success !! We are still able to get back the value for account number 1
        System.out.println(map.get(a3)); //Prints SS
        System.out.println(map.get(a1)); //Prints SS, Overrides Shruti
        System.out.println(map.get(a2));  //Print Singh
    }
}