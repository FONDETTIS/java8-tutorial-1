package name.yamamoto.satoshi.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;


public class Main {

	public static void main(String[] args) {
		
		// The current date and time
		LocalDateTime timePoint = LocalDateTime.now();
		// from values
		LocalDate.of(2012, Month.DECEMBER, 12);
		// middle of 1970
		LocalDate.ofEpochDay(150);
		// the train I took home today
		LocalTime.of(17, 18);
		// From a String
		LocalTime.parse("10:15:30");
		
		// Standard Java getter conventions are used in order to  
		// obtain values from Java SE 8 classes.
		LocalDate theDate = timePoint.toLocalDate();
		Month month = timePoint.getMonth();
		int day = timePoint.getDayOfMonth();
		timePoint.getSecond();
		
		// Set the value, returning a new object
		LocalDateTime thePast = timePoint
				.withDayOfMonth(10)
				.withYear(2010);
		
		// You can use direct manipulation methods, 
		// or pass a value and field pair
		LocalDateTime yetAnother = thePast
				.plusWeeks(3)
				.plus(3, ChronoUnit.WEEKS);
		
		// The new API also has the concept of an adjuster
		LocalDateTime foo = timePoint.with(TemporalAdjusters
				.lastDayOfMonth());
		LocalDateTime bar = timePoint.with(TemporalAdjusters
				.previousOrSame(DayOfWeek.WEDNESDAY));
		
	}

}
