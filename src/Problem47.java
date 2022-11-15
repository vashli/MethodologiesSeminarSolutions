import acm.program.ConsoleProgram;

//47. დაწერეთ პრედიკატ მეთოდი რომელსაც გადაეცემა სტრინგი და რომელიც დაადგენს არის თუ
//არა მოცემული ტექსტი პალინდრომი

public class Problem47 extends ConsoleProgram {
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

	private boolean isPalindrome(String str){
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
