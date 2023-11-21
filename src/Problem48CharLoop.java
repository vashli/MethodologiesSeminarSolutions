
//48. კონსოლიდან შეგყვავს ტექსტი პროგრამამ უნდა დაბეჭდოს სტატისტიკა რომელი 
//სიმბოლო რამდენჯერ გვხვდება

import acm.program.ConsoleProgram;

public class Problem48CharLoop extends ConsoleProgram {
	public void run() {
		String text = readLine("Enter the text to count statistics: ");
		printCharStatistics(text);
	}

	private void printCharStatistics(String text) {
		char currChar = minChar(text);
		char maxChar = maxChar(text);
		while(currChar <= maxChar) {
			int count = countSymbol(text, currChar);
			// print statistics only for characters in text
			if(count != 0) {
				println(currChar + ": " + count);
			}
			currChar += 1; // go to next character
		}
	}

	private char minChar(String text) {
		char minCh = 0; // 0 as an int not as a char '0'
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) < minCh) {
				minCh = text.charAt(i);
			}
		}
		return (char) minCh;
	}

	private char maxChar(String text) {
		char maxCh = 10000; // greater number than any visible character
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) > maxCh) {
				maxCh = text.charAt(i);
			}
		}
		return (char) maxCh;
	}

	private int countSymbol(String text, char symbol) {
		int symbolCount = 0;
		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == symbol) {
				symbolCount++; // symbolCount = symbolCount + 1;
			}
		}
		return symbolCount;
	}
}
