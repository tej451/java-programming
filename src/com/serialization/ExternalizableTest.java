package com.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class ExternalizableTest {
	public static void main(String args[]){
		ItemCollections items = new ItemCollections();
		items.setDoNotStoreMe("Shruti");
		items.setFieldOne(1);
		items.setFieldTwo("Singh");
		items.setFieldThree(false);

		System.out.println(items);
		storeUserSettings(items);
		ItemCollections loadedSettings = loadSettings();
		System.out.println(loadedSettings);
	}

	private static ItemCollections loadSettings() {
		try {
			FileInputStream fis = new FileInputStream("object.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			ItemCollections settings =  (ItemCollections) ois.readObject();
			ois.close();
			return settings;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void storeUserSettings(ItemCollections settings)
	{
		try {
			FileOutputStream fos = new FileOutputStream("object.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(settings);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

class ItemCollections implements Externalizable{
/*
 * If using Externalizable interface public no-arg constructor is mandatory, otherwise on calling 
 * readObject (which in turn calls readExternal implemented method), 
 * we will get java.io.InvalidClassException: no valid constructor
 */
	public ItemCollections(){

	}

	private String doNotStoreMe;

	private Integer fieldOne;
	private String fieldTwo;
	private boolean fieldThree;

	public String getDoNotStoreMe() {
		return doNotStoreMe;
	}

	public void setDoNotStoreMe(String doNotStoreMe) {
		this.doNotStoreMe = doNotStoreMe;
	}

	public Integer getFieldOne() {
		return fieldOne;
	}

	public void setFieldOne(Integer fieldOne) {
		this.fieldOne = fieldOne;
	}

	public String getFieldTwo() {
		return fieldTwo;
	}

	public void setFieldTwo(String fieldTwo) {
		this.fieldTwo = fieldTwo;
	}

	public boolean isFieldThree() {
		return fieldThree;
	}

	public void setFieldThree(boolean fieldThree) {
		this.fieldThree = fieldThree;
	}

	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		fieldOne = in.readInt();
		fieldTwo = in.readUTF();
		fieldThree = in.readBoolean();
	}

	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(fieldOne);
		out.writeUTF(fieldTwo);
		out.writeBoolean(fieldThree);
	}

	@Override
	public String toString() {
		return "UserSettings [doNotStoreMe=" + doNotStoreMe + ", fieldOne="
				+ fieldOne + ", fieldTwo=" + fieldTwo + ", fieldThree="
				+ fieldThree + "]";
	}
}
