import acm.program.ConsoleProgram;
//45. მომხმარებელს კონსოლიდან შეჰყავს ტექსტი და სიმბოლო, თქვენმა პროგრამამ უნდა იპოვოს
//რამდენჯერ გვხვდება მოცემულ ტექსტში მოცემული სიმბოლო

public class Problem45 extends ConsoleProgram {
	public void run() {
		String str = readLine("Enter String: ");
		char ch = enterChar();

		println(countCharInStr(str, ch));
	}

	private char enterChar(){
		String curr = readLine("Enter char: ");
		while(curr.length() != 1){
			println("Enter just 1 character");
			curr = readLine("Enter char: ");
		}
		
		return curr.charAt(0);
	}
	
	private int countCharInStr(String str, char ch) {
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			if (currentChar == ch) {
				count++;
			}
		}
		return count;
	}
	
}
