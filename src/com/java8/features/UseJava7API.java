package com.java8.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;



public class UseJava7API {

	static List<Person> personList = Arrays.asList(
			new Person("Alok", "Singh", 1),
			new Person("Muthaiya", "Murlidharan", 2),
			new Person("Manoj", "Tiwari", 3),
			new Person("Amy", "Jackson", 4),
			new Person("Michael", "Jackson", 5));
	
	public static void main(String args[]){
		//sort collection on last name	
		Collections.sort(personList, new Comparator<Person>(){

			@Override
			public int compare(Person p1, Person p2) {
				return p1.getLastName().compareTo(p2.getLastName());
			}			
		});
		
		//print the collection
		System.out.println("persons in sorted order by last name");
		printAll();
		
		//print whose first name starts with A
		System.out.println("persons whose irst name starts with A");
		printNameStartsWithA(new Condition() {
			
			@Override
			public boolean test(Person person) {
				return person.getName().startsWith("A");
			}
		});
		
		//print whose first name starts with A, in-extensible version
		System.out.println("persons whose name starts with A, in-extensible version");
		printNameStartsWithA();
	}
	
	public static void printAll(){
		for (Person person : personList) {
			System.out.println(person);
		}
	}
	
	public static void printNameStartsWithA(Condition condition){
		for (Person person : personList) {
			if(condition.test(person)){
			System.out.println(person);
			}
		}
	}
	
	public static void printNameStartsWithA(){
		for (Person person : personList) {
			if(person.getName().startsWith("A")){
			System.out.println(person);
			}
		}
	}
	
	
}

interface Condition{
	boolean test(Person p);
}