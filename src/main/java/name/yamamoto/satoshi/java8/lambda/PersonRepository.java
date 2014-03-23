package name.yamamoto.satoshi.java8.lambda;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import name.yamamoto.satoshi.java8.lambda.Person.Sex;

public class PersonRepository {
	private List<Person> persons;

	public PersonRepository() {
		init();
	}

	public List<Person> findBy(PersonSelector handler) {
		List<Person> retval = new ArrayList<>();
		for (Person p : persons) {
			if (handler.select(p)) {
				retval.add(p);
			}
		}
		return retval;
	}

	public List<Person> findAll() throws IOException {
		return persons;
	}
	
// peculiar to file repository --

	public void init() {
		this.persons = new ArrayList<>();
		
		// csv file path.
		FileSystem fs = FileSystems.getDefault();
		Path path = fs.getPath("src/main/resources/akb48.csv");

		// open file stream.
		try (InputStream in = Files.newInputStream(path);
				InputStreamReader inr = new InputStreamReader(in);
				BufferedReader reader = new BufferedReader(inr);) {

			// ignore header
			String line = reader.readLine();
			// read each line
			while ((line = reader.readLine()) != null) {
				persons.add(convert(line));
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Person convert(String csv) {
		/*
		 * csv format are 1: "hometown", 2: "family_name_kana", 3:
		 * "first_name_kana", 4: "name_ja", 5: "nick", 6: "birthday", 7: "team",
		 * 8: "class", 9: "family_name_en", 10: "first_name_en", 11:
		 * "graduate_date"
		 */
		// split csv line
		String[] props = csv.split(",");
		// trim double quote.
		for (int i = 0; i < props.length; i++) {
			props[i] = props[i].replace("\"", "");
		}
		// assign local variable
		String name = props[3];
		String team = props[6];
		LocalDate birthday = atomDateOf(props[5]);
		return new Person(name, birthday, Sex.FEMALE, team);
	}

	public static LocalDate atomDateOf(String str) {
		String[] list = str.split("-");
		int year = Integer.parseInt(list[0]);
		int month = Integer.parseInt(list[1]);
		int dayOfMonth = Integer.parseInt(list[2]);
		return LocalDate.of(year, month, dayOfMonth);
	}

}
