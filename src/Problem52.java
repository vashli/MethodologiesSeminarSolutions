//52. დაწერეთ პროგრამა რომელიც წაიკითხავს თავის თავს ფაილიდან და 
//დაბეჭდავს კონსოლში

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;

public class Problem52 extends ConsoleProgram{
//	private static final String FILENAME = "nonExistant file";
	private static final String FILENAME = "src/Problem52.java";
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
//			println("opened reader");
			while(true) {
				String newLine = reader.readLine();
				if(newLine == null) {
					break;
				}
				println(newLine);
			}
		
			reader.close();
			
//			throw new FileNotFoundException();  // manually throw an exception
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			println("შეცდომა მოხდა, ფაილი ვერ მოიძებნა");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			println("სხვა შეცდომა მოხდა");
		}
		
	}
}
