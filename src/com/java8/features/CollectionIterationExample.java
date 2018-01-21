package com.java8.features;

import java.util.Arrays;
import java.util.List;

public class CollectionIterationExample {

	public static void main(String[] args) {
		List<Person> personList = Arrays.asList(
				new Person("Alok", "Singh", 1),
				new Person("Muthaiya", "Murlidharan", 2),
				new Person("Manoj", "Tiwari", 3),
				new Person("Amy", "Jackson", 4),
				new Person("Michael", "Jackson", 5));

		//uses external iterator
		System.out.println("Using for loop");
		for(int i=0; i<personList.size(); i++){
			System.out.println(personList.get(i));
		}
		
		//uses external iterator
		System.out.println("Using for in loop");
		for(Person person: personList){
			System.out.println(person);
		}
		
		//uses internal iterator, it is upto java runtime engine from where to start and where to end and
		//whether use serial execution or parallel execution
		System.out.println("Using foreach");
		//personList.forEach(p -> System.out.println(p));
		personList.forEach(System.out::println);
	}

}
