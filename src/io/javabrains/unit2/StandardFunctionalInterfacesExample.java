package io.javabrains.unit2;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import io.javabrains.common.Person;

public class StandardFunctionalInterfacesExample {

	public static void main(String[] args) {
		List<Person> people = Arrays.asList(
				new Person("Lewis", "Carroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charles", "Dickens", 60),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
				);
		
		
//		people.stream().sorted(Comparator.comparing(Person::getAge, Comparator.reverseOrder())).findFirst().ifPresent(System.out::println);
//		people.stream().reduce((a,b) -> b).ifPresent(System.out::println);
//		people.stream().map(Person::getAge).forEach((a)->System.out.println(a+2));
		
		people.stream().reduce((a,b) -> a.getAge() < b.getAge() ? a : b).ifPresent(System.out::println);

		// Step 1: Sort list by last name
		Collections.sort(people, (p1, p2) -> p1.getLastName().compareTo(p2.getLastName()));

		/*// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		performConditionally(people, p -> true, p -> System.out.println(p));

		// Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("Printing all persons with last name beginning with C");
		performConditionally(people, p -> p.getLastName().startsWith("C"), p -> System.out.println(p));

		System.out.println("Printing all persons with first name beginning with C");
		performConditionally(people, p -> p.getFirstName().startsWith("C"), p -> System.out.println(p.getFirstName()));*/

		// Step 2: Create a method that prints all elements in the list
		System.out.println("Printing all persons");
		people.forEach(System.out::println); 

		// Step 3: Create a method that prints all people that have last name beginning with C
		System.out.println("\n Printing all persons with last name beginning with C");
		people.stream().filter(p -> p.getLastName().startsWith("C")).forEach(System.out::println); 

		System.out.println("\n Printing all persons with first name beginning with C");
		people.stream().filter(p -> p.getFirstName().startsWith("C")).forEach(System.out::println); 

	}

	private static void performConditionally(List<Person> people, Predicate<Person> predicate, Consumer<Person> consumer) {
		for (Person p : people) {
			if (predicate.test(p)) {
				consumer.accept(p);
			}
		}
	}
}
