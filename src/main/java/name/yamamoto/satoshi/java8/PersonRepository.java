package name.yamamoto.satoshi.java8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class PersonRepository {
	
	private static final String CSV_PATH = "src/main/resources/akb48.csv";
	private BufferedReader reader;
	
	public List<Person> findAll() throws IOException {
		// read each line
		String line = null;
		while ((line = reader.readLine()) != null) {
			System.out.println(line);
		}
		return null;
	}
	
	public void init() throws IOException {
		// csv file path.
		FileSystem fs = FileSystems.getDefault();
		Path path = fs.getPath(CSV_PATH);
		// open file stream.
		try (InputStream in = Files.newInputStream(path); 
			InputStreamReader inr = new InputStreamReader(in);) {
			reader = new BufferedReader(inr);
		};
	}
	
	public void destroy() throws IOException {
		reader.close();
	}
	
}
