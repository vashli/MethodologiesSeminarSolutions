//47. დაწერეთ პრედიკატ მეთოდი რომელსაც გადაეცემა სტრინგი და რომელიც დაადგენს არის თუ
//არა მოცემული ტექსტი პალინდრომი

import acm.program.ConsoleProgram;

public class Problem47 extends ConsoleProgram{
	public void run() {
		while(true){
			String str = readLine("Enter String: ");
			if(isPalindrome(str)){
				println("Is a palindrome"); 
			}else{
				println("Is not a palindrome"); 
			}
		}
	}

//	abba
//	i = 0; i = 1 +
//	aba
//	i = 0;  + //i = 1 ??
	
//	i = 0, j = 4 - 1 - 0 = 3
//	i = 1, j = 4 - 1 - 1 = 2
	private boolean isPalindrome(String text) {
		for(int i = 0; i < text.length() / 2; i++) {
			if(text.charAt(i) != text.charAt(text.length() - 1 - i)) {
				return false;
			}
		}
		return true;
	}
	
	// second version using reverse string
	private boolean isPalindrome2(String str){
		return str.equals(reversedString(str));
	}
	
	private String reversedString(String str) {
		String revStr = "";
		for(int i = str.length() - 1; i >= 0; i--){
			revStr += str.charAt(i);
		}
		return revStr;
	}

}
