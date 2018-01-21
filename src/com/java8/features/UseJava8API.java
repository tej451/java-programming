package com.java8.features;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UseJava8API {

	static List<Person> personList = Arrays.asList(
			new Person("Alok", "Singh", 1),
			new Person("Muthaiya", "Murlidharan", 2),
			new Person("Manoj", "Tiwari", 3),
			new Person("Amy", "Jackson", 4),
			new Person("Michael", "Jackson", 5));
	
	public static void main(String args[]){
		//sort collection on last name	
		Collections.sort(personList, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));
		
		//print the collection
		System.out.println("persons in sorted order by last name");
		printNameStartsWithA(p -> true, p -> System.out.println(p));
		
		//print whose first name starts with A
		System.out.println("persons whose irst name starts with A");
		printNameStartsWithA(p -> p.getName().startsWith("A"), p -> System.out.println(p));
		
		//print whose last name starts with J
		System.out.println("print whose last name starts with J");
		printNameStartsWithA(p -> p.getLastName().startsWith("J"), p -> System.out.println(p.getLastName()));
		//or
		printNameStartsWithA(p -> p.getLastName().startsWith("J"), System.out::println); // method reference
		// same as p -> System.out.println(p)
	}
	
	/*public static void printAll(){
		for (Person person : personList) {
			System.out.println(person);
		}
	}*/
	
	//picking Condition from interface defined in UseJava7API
	/*public static void printNameStartsWithA(Condition condition){
		for (Person person : personList) {
			if(condition.test(person)){
			System.out.println(person);
			}
		}
	}*/
	
	
	//instead of above method, we can use below method which uses Predicate function/interface instead of user defined interface
	public static void printNameStartsWithA(Predicate<Person> condition){
		for (Person person : personList) {
			if(condition.test(person)){
			System.out.println(person); // further we can pass function over here
			}
		}
	}
	
	public static void printNameStartsWithA(Predicate<Person> condition, Consumer<Person> consumer){
		for (Person person : personList) {
			if(condition.test(person)){
			consumer.accept(person);
			}
		}
	}
	
}

