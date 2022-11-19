import java.util.StringTokenizer;
import acm.program.ConsoleProgram;

//5. დაწერეთ მეთოდი, რომელსაც გადაეცემა ორი სტრინგი და აბრუნებს ეს სტრინგები ერთმანეთის 
//ანაგრამები არის თუ არა. (ანუ ერთი სტრინგი მიიღება თუ არა მეორეში ასოების გადალაგების შედეგად) 
//მაგ: ( “i have A pEN.” , “i evah A NEp.”) -> true  
//( “i have A pEN.” , “i evaheeA NE.”) -> false
//Tags: String, Anagrams, RearrangeCharacters, CountCharacters

public class Practice05 extends ConsoleProgram {
	public void run() {
		while (true) {
			String s1 = readLine("Enter first word: ");
			String s2 = readLine("Enter second word: ");
			println(areAnagrams(s1, s2));
		}
	}

	private boolean areAnagrams(String s1, String s2) {
		if(s1.length() != s2.length()){
			return false;
		}
		for(int i = 0; i < s1.length(); i++){
			char currCh = s1.charAt(i);
			int countS1 = countCharInStr(s1, currCh);
			int countS2 = countCharInStr(s2, currCh);
			if(countS1 != countS2){
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
