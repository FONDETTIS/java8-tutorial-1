package name.yamamoto.satoshi.java8.stream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StopWatch;

public class PerformanceMain {

	public static void main(String[] args) throws IOException {
		
		final int len = 50000000;
		
		StopWatch watch = new StopWatch("Testing Stream API");
		
		// Initializing...
		List<Integer> list = new ArrayList<>(len);
		for (int i = 0; i < len; i++) {
			list.add(i);
		}
		
		// for-each
		watch.start("iterate tiger foreach");
		for (int i : list) {
			printIfTenThousand(i);
		}
		watch.stop();

		// sequential stream
		watch.start("iterate sequential stream");
		list.stream()
		.forEach(i -> printIfTenThousand(i));
		watch.stop();
		
		// parallel stream
		watch.start("iterate parallel stream");
		list.parallelStream()
		.forEach(i -> printIfTenThousand(i));
		watch.stop();
		

		System.out.println(watch.prettyPrint());
	}
	
	public static final void printIfTenThousand(int i) {
		if (i % 10000 == 0) { 
			System.out.println(i);
		}
	}
	
	

}
