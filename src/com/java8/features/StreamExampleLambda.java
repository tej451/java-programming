package com.java8.features;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class StreamExampleLambda {

	public static void main(String[] args) {
		List list = new LinkedList();
		list.add("add");
		list.add("add1");
		List<Person> personList = Arrays.asList(
				new Person("Alok", "Singh", 1),
				new Person("Muthaiya", "Murlidharan", 2),
				new Person("Manoj", "Tiwari", 3),
				new Person("Amy", "Jackson", 4),
				new Person("Michael", "Jackson", 5));

		personList.stream()
		.filter(p -> p.getLastName().startsWith("J"))
		.forEach(p -> System.out.println(p.getName()));
		
		list.stream();
	}

}
