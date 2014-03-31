package name.yamamoto.satoshi.java8.stream;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import name.yamamoto.satoshi.java8.PersonRepository;

public class Main {

	public static void main(String[] args) throws IOException {
		
		PersonRepository repository = new PersonRepository();
		
		// Sequential
		repository.findAll().stream();
		// Parallel 
		repository.findAll().parallelStream();
		
		// Filter Example
		System.out.println("** AKB48 ****************************************");
		repository.findAll().stream()
			.filter(p -> p.getTeam().equals("A"))
			.forEach(System.out::println);
		
		// Filter and Set the property
		System.out.println("** AKB48 ****************************************");
		repository.findAll().stream()
			.filter(p -> p.getTeam().equals("A"))
			.filter(p -> p.getName().startsWith("高橋みなみ"))
			.forEach(p -> p.setCaptain(true));

		repository.findAll().stream()
			.filter(p -> p.isCaptain())
			.forEach(System.out::println);
		
		// Map Example, result => 4,5,6,7
		List<Integer> numbers = Arrays.asList(new Integer[]{3, 4, 5, 6});
		numbers.stream()
			.map(i -> i + 1)
			.forEach(System.out::println);
		
		// Reduce Example, result => 18
		int sum = numbers.stream()
			.reduce((i, j) -> i + j).get();
		System.out.println(sum);
	}
	
	public static void print(List<?> list, String message) {
		System.out.println(message);
		for (Object o : list) {
			System.out.println(o);
		}
	}

}
