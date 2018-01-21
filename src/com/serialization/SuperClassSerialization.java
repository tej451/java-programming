package com.serialization;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
/*
 * If super class also implemented Serializable interface then those variables will be serialized,
 *  otherwise it won't serialize the super class variables. and while deserializing, 
 *  JVM will run no-arg constructor in super class and populates the default values.
 *  If no-arg constructor was not present then InvalidClassException: no valid constructor was thrown
 *  Same thing will happen for all superclasses.
 */
public class SuperClassSerialization extends BaseSerial implements Serializable{

	private String subInstance;
	private static int subStatic;
	public SuperClassSerialization(){
		super(30);
		subInstance = "10";
		subStatic = 20;
	}
	
	@Override
	public String toString(){
		return "subInstance -"+subInstance+ ", subStatic -"+subStatic+ ", baseInstance -"+baseInstance;
	}
	
	public static void main(String args[]) throws IOException, ClassNotFoundException{
		SuperClassSerialization superInstance = new SuperClassSerialization();
		FileOutputStream fileoutStream = new FileOutputStream("file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fileoutStream);
		oos.writeObject(superInstance);
		System.out.println(" After serialization - "+superInstance);
		
		
		FileInputStream fileInStream = new FileInputStream("file.txt");
		ObjectInputStream ois = new ObjectInputStream(fileInStream);
		SuperClassSerialization superInstance1 = (SuperClassSerialization)ois.readObject();
		System.out.println(" After de-serialization - "+superInstance1);
		ois.close();
	}
}

/* If BaseSerial is Serializable then it's variables will be serialized, otherwise no-arg constructor would
 * be manadatory in order to de-serialize the sub class
 * If BaseSerial is serializable, After de-serialization - subInstance -10, subStatic -20, baseInstance -30
 * otherwise, After de-serialization - subInstance -10, subStatic -20, baseInstance -450*/

class BaseSerial implements Serializable{
	protected int baseInstance;
	
	public BaseSerial(){
		this.baseInstance = 450;
	}
	
	public BaseSerial(int baseInstance){
		this.baseInstance = baseInstance;
	}
}


