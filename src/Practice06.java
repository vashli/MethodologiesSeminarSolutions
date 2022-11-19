import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

//6. დაწერეთ მეთოდი, რომელიც ორი სტრინგი და გიბრუნებთ, პირველ სტრინგში მაქსიმუმ ერთი 
//ასოს გადაკეთების შედეგად, იქნება თუ არა მეორე სტრინგის ანაგრამა.
//Tags: String, Anagrams, RearrangeCharacters, CountCharacters 


public class Practice06 extends ConsoleProgram {
	public void run() {
		while (true) {
			String s1 = readLine("Enter first word: ");
			String s2 = readLine("Enter second word: ");
			println(areAnagrams(s1, s2));
		}
	}

	private boolean areAnagrams(String s1, String s2) {
		char changeFrom = ' '; 
		char changeTo = ' ';
		boolean changeFromSet = false;
		boolean changeToSet = false;
		
		if(s1.length() != s2.length()){
			return false;
		}
		
		for(int i = 0; i < s1.length(); i++){
			char currCh = s1.charAt(i);
			int countS1 = countCharInStr(s1, currCh);
			int countS2 = countCharInStr(s2, currCh);
			if(countS1 == countS2){
				continue; // everything is fine, go to next index
			}
			if(countS1 - countS2 == 1 && (!changeFromSet || changeFrom == currCh)){
				changeFrom = currCh;
				changeFromSet = true;
			}else if(countS1 - countS2 == -1 && (!changeToSet || changeTo == currCh)){
				changeTo = currCh;
				changeToSet = true;
			}else{
				// if diff >= 2 or there are count differences in more than 1 pair
				return false;
			}
		}
		
		return true;
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
