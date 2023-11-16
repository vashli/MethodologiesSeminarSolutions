//45. მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო, თქვენმა პროგრამამ
//უნდა იპოვოს რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო

import acm.program.ConsoleProgram;

public class Problem45 extends ConsoleProgram{

	public void run() {
		String text = readLine("enter text: ");
		char symbol = readLine("enter symbol: ").charAt(0);
		
		// same as line 10
//		String symbolString = readLine("enter symbol: ");
//		char symbolChar = symbolString.charAt(0);
		
		println("Count: " + countSymbol(text, symbol));
	}
	
	private int countSymbol(String text, char symbol) {
		int symbolCount = 0;
		for(int  i = 0; i < text.length(); i++) {
			if(text.charAt(i) == symbol) {
				symbolCount++; // symbolCount = symbolCount + 1;
			}
		}
		return symbolCount;
	}
}
