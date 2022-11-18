import acm.program.ConsoleProgram;

//46. დაწერეთ მეთოდი რომელსაც გადაეცემა სტიგნი და რომელიც აბრუნებს ამ სტრინგში
//ყველაზე ხშირ სიმბოლოს

public class Problem46 extends ConsoleProgram {
	public void run() {
		while(true){
			String str = readLine("Enter String: ");
			println("Most frequent char: " + frequentChar(str));
			println("Most frequent English letter: " +frequentLetter(str));
		}
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
	

	private char frequentChar(String str){
		char result = ' ';
		int maxCnt = 0;
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			int currentCnt = countCharInStr(str, currentChar);
			
			if(currentCnt > maxCnt){
				maxCnt = currentCnt;
				result = currentChar;
			}
		}
		
		return result;
	}
	
	private char frequentLetter(String str){
		str = str.toLowerCase();
		int maxCnt = 0;
		char result = ' ';
		
		for(int i = 0; i < str.length(); i++){
			char currCh = str.charAt(i);
			if(Character.isLetter(currCh)){
				int currCnt = countCharInStr(str,currCh );
				if(currCnt > maxCnt){
					maxCnt = currCnt;
					result =  currCh;
				}
			}
		}
		
		return result;
	}
	
}
