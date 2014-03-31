package name.yamamoto.satoshi.java8.lambda;

import java.io.IOException;
import java.util.List;

import name.yamamoto.satoshi.java8.Person;
import name.yamamoto.satoshi.java8.PersonRepository;

public class Main {

	public static void main(String[] args) throws IOException {
		
		PersonRepository repository = new PersonRepository();
		
		System.out.println("** AKB48 ****************************************");
		
		List<Person> akb48 = repository.findAll();
		for (Person member : akb48) {
			System.out.println(member);
		}
		
		List<Person> teamA = repository.findBy((p) -> 
			p.getTeam().contains("A")
		);
		print(teamA, "*** Team A");
			
		List<Person> underage = repository.findBy((p) -> 
			p.getAge() < 20
		);
		print(underage, "*** Under Age");
		
		
	}
	
	public static void print(List<?> list, String message) {
		System.out.println(message);
		for (Object o : list) {
			System.out.println(o);
		}
	}

}
