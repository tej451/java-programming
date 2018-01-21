package com.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/*
 * 2. Which of the following members of an instance are serialized when an object is serialized
a. static                 
b. transient         
c. method local variables
d. none of them
e. all of them
Answer:d

Static variables belong to a class and not to any individual instance. The concept of serialization is concerned 
with the object’s current state. Only data associated with a specific instance of a class is serialized, therefore
 static member fields are ignored during serialization.

Static Variables: These variables are not serialized, So during deserialization static variable value will loaded 
from the class.(Current value will be loaded.)

transient Variables: transient variables are not serialized, so during deserialization those variables will be 
initialized with corresponding default values (ex: for objects null, int 0).
 */

public class SerializeToFile {
	public static void main(String[] args) throws IOException, ClassNotFoundException 
	{
		UserDetails settings = new UserDetails();
		settings.setFieldOne(10000);
		settings.setFieldTwo("HowToDoInJava.com");
		settings.setFieldThree(true);
		settings.setStr("true");
		
		//Before
		System.out.println(settings);
		serializeToFile(settings);
		//settings.setFieldThree(true);
		//static variable changed, so when after deserialization static variable value will be read, most recent value will be read
		settings.setStr("name");
		UserDetails userSettings = deserializeFromFile();
		//System.out.println("deserialized - "+userSettings);
	}

	public static UserDetails deserializeFromFile() throws IOException, ClassNotFoundException {
		//try{
		FileInputStream fileInStream = new FileInputStream("file.txt");
		ObjectInputStream ois = new ObjectInputStream(fileInStream);
		UserDetails userSettings = (UserDetails)ois.readObject();
		System.out.println(userSettings+" getStr: "+userSettings.getStr());
		ois.close();
		fileInStream.close();
		return userSettings;
		/*}catch(Throwable e){
			
			System.out.println("error:"+e.getMessage());
			e.printStackTrace();
		}*/
		//return null;
	}

	public static void serializeToFile(UserDetails userDetails) throws IOException{
		
		FileOutputStream fileoutStream = new FileOutputStream("file.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fileoutStream);
		oos.writeObject(userDetails);
		oos.close();
		fileoutStream.close();
	}
	
	protected Object readResolve() {
		UserDetails userSettings = new UserDetails();
		userSettings.setFieldTwo("a");
		//userSettings.setStr("false");
		userSettings.setFieldOne(100);
		return userSettings;
	}
}
