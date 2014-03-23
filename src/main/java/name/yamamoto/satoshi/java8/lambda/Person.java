package name.yamamoto.satoshi.java8.lambda;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.chrono.IsoChronology;

public class Person implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name;
	private LocalDate birthday;
	private Sex gender;
	private String team;
	
	public enum Sex {
		MALE, FEMALE;
	}
	
	public Person() {
		super();
	}
	
	public Person(String name, LocalDate birthday, Sex gender, String team) {
		super();
		this.name = name;
		this.birthday = birthday;
		this.gender = gender;
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
        return birthday
            .until(IsoChronology.INSTANCE.dateNow())
            .getYears();
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

	public String getTeam() {
		return team;
	}

	public void setTeam(String description) {
		this.team = description;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", birthday=" + birthday + ", gender="
				+ gender + ", description=" + team + "]";
	}
	
}
