package com.collections;

import java.util.HashMap;

public class HashMapValue 
{
    public static void main(String[] args) 
    {
        Test1 objTest = new Test1("Hello");
        HashMap<Integer, Test1> hm = new HashMap<Integer, Test1>();
        hm.put(1, objTest);
        objTest.setName("World");
        Test1 secondObject = hm.get(1);
        System.out.println(secondObject.getName());
 
        HashMap<Integer, StringBuffer> hm2 = new HashMap<Integer, StringBuffer>();
        StringBuffer sb = new StringBuffer("Hello");
        hm2.put(1, sb);
        sb = new StringBuffer("World");
        System.out.println(hm2.get(1));
    }
}
 
class Test1 {
    String name;
 
    Test1(String name) {
        this.name = name;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
