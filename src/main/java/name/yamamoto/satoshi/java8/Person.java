package name.yamamoto.satoshi.java8;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private Date birthday;
	private Sex gender;
	private String description;
	
	public enum Sex {
		MALE, FEMALE;
	}
	
	public Person() {
		super();
	}
	
	public Person(String name, Date birthday, Sex gender) {
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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
