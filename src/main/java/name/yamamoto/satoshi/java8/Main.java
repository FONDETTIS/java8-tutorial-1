package name.yamamoto.satoshi.java8;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) throws IOException {
		// csv file path.
		FileSystem fs = FileSystems.getDefault();
		Path path = fs.getPath("src/main/resources/akb48.csv");
		// open file stream.
		try (InputStream in = Files.newInputStream(path); 
			InputStreamReader inr = new InputStreamReader(in);
			BufferedReader reader = new BufferedReader(inr);) {
			// read each line
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
				
			
			
			
			
			
		};
	}

}
