package com.designpattern;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SingletonTest {
	public static void main(String a[]) throws CloneNotSupportedException, Exception{
		//ENUM version
		EnumSingleton.INSTANCE.testIt();
		//System.out.println(EnumSingleton.INSTANCE.hashCode());

		//Enum Singleton and Serialization: enum do not require to implement readResolve, since it is already
		//serialization safe, with enum singleton serialization is guranteed by jvm
		ObjectOutputStream enumoos = new ObjectOutputStream(new FileOutputStream("singletonenum.ser"));
		enumoos.writeObject(EnumSingleton.INSTANCE);
		enumoos.close();
		ObjectInputStream enumois = new ObjectInputStream(new FileInputStream("singletonenum.ser"));
		EnumSingleton serializedObjectEnum = (EnumSingleton)enumois.readObject();
		enumois.close();
		System.out.println("Enum ** Original Object - "+EnumSingleton.INSTANCE + " SerializedObject - "+serializedObjectEnum);
		System.out.println("Enum **Original Object hashcode - "+EnumSingleton.INSTANCE.hashCode() + " SerializedObject hashcode - "+serializedObjectEnum.hashCode());

		//ENUM VIA REFLECTION, reflection will not be supported for Enum
		Constructor[] enumConstructors = EnumSingleton.class.getDeclaredConstructors();
		for(Constructor enumConstructor: enumConstructors){
			enumConstructor.setAccessible(true);
			try {
				EnumSingleton inst = (EnumSingleton)enumConstructor.newInstance();
				System.out.println("ENUM **  break via reflection "+inst.hashCode()+" object - "+inst);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			//ENUM and clone, clone is not supported for ENUM

			//Double Checked Locking version
			DoubleCheckedLockingSingleton obj = DoubleCheckedLockingSingleton.getInstance();
			System.out.println("DoubleCheckedLockingSingleton - "+obj.hashCode() +" - obj - "+obj);

			Object clonedObj = obj.clone();
			System.out.println("DoubleCheckedLockingSingleton - cloned hashcode"+clonedObj.hashCode());
			System.out.println(obj + " Cloned - "+clonedObj);
			Executor executor = Executors.newFixedThreadPool(2);
			for(int i=0; i<2; i++){
			executor.execute(new SingletonTestThread());
		}
		//new Thread(new SingletonTestThread(), "TestThread").start();

			//ACCESSING VIA REFLECTION
			Constructor[] constructors = DoubleCheckedLockingSingleton.class.getDeclaredConstructors();
			for(Constructor constructor: constructors){
				constructor.setAccessible(true);
				try {
				DoubleCheckedLockingSingleton inst = (DoubleCheckedLockingSingleton)constructor.newInstance(null);
				System.out.println("DoubleCheckedLockingSingleton - break via reflection "+inst.hashCode()+" object - "+inst);
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}

			//DoubleCheckedLocking Singleton and Serialization
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
			oos.writeObject(obj);
			oos.close();
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("singleton.ser"));
			DoubleCheckedLockingSingleton serializedObject = (DoubleCheckedLockingSingleton)ois.readObject();
			ois.close();
			System.out.println("DoubleCheckedLockingSingleton ** Original Object - "+obj + " SerializedObject - "+serializedObject);
			System.out.println("DoubleCheckedLockingSingleton ** Original Object hashcode - "+obj.hashCode() + " SerializedObject hashcode - "+serializedObject.hashCode());

			//Bill Pugh Singleton
			BillPughSingleton billPughSingleton = BillPughSingleton.getInstance();
			System.out.println(billPughSingleton +"hashcode: "+billPughSingleton.hashCode());
			BillPughSingleton billPughSingletonCloned = (BillPughSingleton)billPughSingleton.clone();
			System.out.println(billPughSingletonCloned+" cloned hashcode: "+billPughSingletonCloned.hashCode());
		
			//serialization
			ObjectOutputStream bpoos = new ObjectOutputStream(new FileOutputStream("singletonbp.ser"));
			bpoos.writeObject(billPughSingleton);
			bpoos.close();
			ObjectInputStream bpois = new ObjectInputStream(new FileInputStream("singletonbp.ser"));
			BillPughSingleton serializedObjectBP = (BillPughSingleton)bpois.readObject();
			bpois.close();
			System.out.println("BP ** Original Object - "+bpoos + " SerializedObject - "+serializedObjectBP);
			System.out.println("BP **Original Object hashcode - "+bpoos.hashCode() + " SerializedObject hashcode - "+serializedObjectBP.hashCode());

	}

	static class SingletonTestThread implements Runnable{
		public void run() {
			try{
			DoubleCheckedLockingSingleton obj = DoubleCheckedLockingSingleton.getInstance();
			System.out.println("DoubleCheckedLockingSingleton - "+Thread.currentThread().getName()+ " - "+obj.hashCode());
			}catch( Exception e){
			e.printStackTrace();
		}
		}
	}
}
