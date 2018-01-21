package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HashMapSerilaization{

	public static void main(String args[]) throws IOException, ClassNotFoundException{
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Shruti");
		map.put(2, "Singh");
		map.put(3, "Learn");
		for(Map.Entry<Integer, String> entry:map.entrySet()){
			System.out.println("Before - "+entry.getKey()+" - "+entry.getValue());
		}
		HashMapSerilaization hashMapSer = new HashMapSerilaization();
		hashMapSer.writeObject(map);
		HashMap<Integer, String> map1 = hashMapSer.readObject();
		for(Map.Entry<Integer, String> entry:map1.entrySet()){
			System.out.println("After - "+entry.getKey()+" - "+entry.getValue());
		}
		//UserDetails userSettings = SerializeToFile.deserializeFromFile();
		//System.out.println(userSettings);
	}
	
	public void writeObject(Object obj) throws IOException{
		FileOutputStream fos = new FileOutputStream("hashmap.ser");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.close();
		fos.close();
	}
	
	public HashMap<Integer, String> readObject() throws ClassNotFoundException, IOException{
		FileInputStream fos = new FileInputStream("hashmap.ser");
		ObjectInputStream oos = new ObjectInputStream(fos);
		HashMap<Integer, String> map = (HashMap<Integer, String>)oos.readObject();
		oos.close();
		fos.close();
		return map;
	}
}
