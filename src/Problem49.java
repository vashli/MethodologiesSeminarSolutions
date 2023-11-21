//49. დაწერეთ stringToInteger მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
//ჩათვალეთ, რომ გადაცემული სტრინგი მხოლოდ ციფრებისგან შედგება და არ იწყება 0-ით.
//მაგალითად “234” გადაცემის შემთხვევაში მეთოდმა უნდა დააბრუნოს 234. ასევე ჩათვალეთ,
//რომ დაბრუნებული მნიშვნელობა დადებითია და ეტევა int-ში

import acm.program.ConsoleProgram;

public class Problem49 extends ConsoleProgram{
	public void run() {
		String numStr = "12340";
		int num = stringToInteger(numStr);
//		int num =  Integer.parseInt(numStr);  // existing method
		
		println(num);
		println(num - 1);
		println(num + 1);		
	}
	
	private int stringToInteger(String numStr) {
		int num = 0;
		for(int i = 0; i < numStr.length(); i++) {
			int currDigit = charToIntenger(numStr.charAt(i));
			num = num * 10 + currDigit;
		}
		return num;
	}

//	'1' - '0' = (int)'1' - (int)'0' = 49 - 48 = 1
 	private int charToIntenger(char ch) {
		return ch - '0';
	}
}
