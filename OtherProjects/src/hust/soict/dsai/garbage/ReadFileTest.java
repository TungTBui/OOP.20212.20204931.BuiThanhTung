package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReadFileTest {
	
	public static void main (String[] args) throws IOException {
			
		long startTime, endTime;
		String filePath = "test.txt";

		List<String> content = Files.readAllLines(Paths.get(filePath));
		
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (String word: content) {
			outputString += word;
		}
		endTime = System.currentTimeMillis();
		long stringRunningTime = endTime - startTime;
		
		startTime = System.currentTimeMillis();
		StringBuilder sb = new StringBuilder();
		for (String word: content) {
			sb.append(word);
		}
		outputString = sb.toString();
		endTime = System.currentTimeMillis();
		long stringBuilderRunningTime = endTime - startTime;
		
		
		
		System.out.println(stringRunningTime);
		System.out.println(stringBuilderRunningTime);
		

	}

}
