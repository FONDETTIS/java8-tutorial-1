package name.yamamoto.satoshi.java8;

import java.io.Serializable;
import java.time.LocalDate;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private LocalDate birthday;
	private Sex gender;
	private String description;
	
	public enum Sex {
		MALE, FEMALE;
	}
	
	public Person() {
		super();
	}
	
	public Person(String name, LocalDate birthday, Sex gender) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", description=" + description + "]";
	}
	
}
