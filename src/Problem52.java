import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import acm.program.ConsoleProgram;

//52. დაწერეთ პროგრამა რომელიც წაიკითხავს თავის თავს ფაილიდან და დაბეჭდავს კონსოლში
public class Problem52 extends ConsoleProgram {
	public void run() {
		try {
			BufferedReader bf = new BufferedReader( new FileReader("Problem52.java"));
			while(true){
				String currLine = bf.readLine(); 
				if(currLine == null){
					break;
				}
				println(currLine);
			}
			bf.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
