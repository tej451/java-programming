package com.collections;
/*
 * This method returns a hashCode() value as an Integer and is supported for the benefit of hashing based
java.util.Collection classes like Hashtable, HashMap, HashSet etc. If a class overrides the equals() method, it
must implement the hashCode() method as well.
 */
public class Account 
{
    private int accountNumber;
    private String holderName;
 
    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
    }
 
    public String getHolderName() {
        return holderName;
    }
 
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
 
    public int getAccountNumber() {
        return accountNumber;
    }
 
    //Depends only on account number
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + accountNumber;  //result = prime * result + accountNumber+holderName.hashCode(); if we also include 
        //holderName then on changing holderName, hash code will change, this should not be the right thing
        return result;
    }
 
    //Compare only account numbers
    @Override
    public boolean equals(Object obj) {
        if (this == obj) //// if both are referring to the same object
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (accountNumber != other.accountNumber)
            return false;
        return true;
    }
 
}
