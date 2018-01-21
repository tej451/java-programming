package com.threading;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import com.java8.features.Person;
/*
 * 7. While iterating a list using an enhanced for loop, few elements are added to the same list and few of them are removed. After the iteration what would be the state of the list?
a. New elements are added to the list
b. Remove is successful
c. Both operations (additions and removal) are successful
d. Exception is thrown
Answer:d

8. Which of the following exceptions must be caught or declared to be thrown?
a. NullPointerException                
b. Checked Exceptions 
c. RuntimeException      
d. None of them
Answer:b
 */
public class EnhancedForLoop {

	public static void main(String[] args) throws InterruptedException {
		List<Person> personList = new ArrayList<>();
		for(int i =0;i <50;i++){
			personList.add(new Person(i+"name", "", i));
			System.out.println("ADD: "+new Person(i+"name", "", i));
		}
		System.out.println("Size: "+personList.size());
		
		Thread t = new Thread(){
			public void run(){
		for(int i =0;i <5;i++){
			personList.remove(i);
			System.out.println("REMOVE: "+i);
		}
			}
		};
		
		new Thread(){
			public void run(){
				/*for (Person person : personList) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("In thread"+person);
				}*/
				
				//using forEach also gives concurrentModification Exception
				/*personList.forEach(new Consumer<Person> (){

					@Override
					public void accept(Person t) {
						System.out.println("In forEach "+t);
					}
					
				});*/
				
				//using lambda, it also gives concurrentModification exception
				personList.forEach(p -> System.out.println(p));
			}
		}.start();

		try{
			Thread.sleep(45);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		t.start();
		
		for(int i =0;i <5;i++){
			personList.add(new Person(i+"name1", "", i));
			System.out.println("ADD 2: "+new Person(i+"name1", "", i));
		}

		
		
	}

}
