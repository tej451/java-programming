package com.concurrent;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMap implements Runnable{
	static ConcurrentHashMap<Integer, String> map = new ConcurrentHashMap<Integer, String>();
	public static void main(String args[]){
		try{
			for(int i=0; i<15; i++){
				map.put(i, "String"+i);
			}
			System.out.println("map.size() - "+map.size());
			Set<Map.Entry<Integer, String>> set = map.entrySet();
			new Thread(new ConcurrentMap()).start();
			Iterator<Map.Entry<Integer, String>> itr = set.iterator();
			while(itr.hasNext()){
				Map.Entry<Integer, String> entry = (Map.Entry<Integer, String>)itr.next();
				System.out.println(entry+" - "+entry.getKey()+" - "+entry.getValue());
				Thread.sleep(1000);
			}
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		
	}
	public void run(){
		try{
			Thread.sleep(100);
			System.out.println("put called");
			map.put(22, "String22");
			System.out.println("map.size() after put- "+map.size());
			System.out.println("put called after");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
