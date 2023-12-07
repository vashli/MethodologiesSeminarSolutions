//53. დაწერეთ პროგრამა რომელიც ფაილიდან წაიკითხავს ტექტს და 
//დათვლის შემდეგ
//სტატისტიკებს: სიმბოლოების რაოდენობა(alphanumeric), სიტყვების რაოდენობა
//(სიტყვები სფეისებით
//გამოყოფილია ერთმანეთისგან), წინადადებების რაოდენობა. 
//		რამდენი წინდადება მთავრდება
//წერტილით, კითხვის ნიშნით და ძახილის ნიშნით?
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Problem53 extends ConsoleProgram{
	private static final String FILENAME = "statistics.txt";
	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILENAME));
			String text = "";
			while(true) {
				String line = reader.readLine();
				if (line == null) {
					break;
				}
				text += line + "\n";
			}
			reader.close();
			countStatistics(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void countStatistics(String text) {
		int symbolCount = 0;
		int wordCount = 0;
		int dotCount = 0;
		int questionCount = 0;
		int exclamationCount = 0;
		int sentenceCount = 0;
		
		StringTokenizer tokenizer = new StringTokenizer(text, " ?!.\n", true);
		
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if(token.equals(".")) {
				dotCount += 1;
				sentenceCount += 1;
			}else if(token.equals("!")) {
				exclamationCount += 1;
				sentenceCount += 1;
			}else if(token.equals("?")) {
				questionCount += 1;
				sentenceCount += 1;
			}else if(!token.equals(" ") && !token.equals("\n")) {
				wordCount += 1;
				symbolCount += token.length();
			}
		}
				
		println("symbolCount " + symbolCount);
		println("wordCount " + wordCount);
		println("dotCount " + dotCount);
		println("questionCount " + questionCount);
		println("exclamationCount " + exclamationCount);
		println("sentenceCount " + sentenceCount);		
	}
}
