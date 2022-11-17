import acm.program.ConsoleProgram;

//49. დაწერეთ stringToInteger მეთოდი, რომელსაც გადაეცემა სტრინგი და აბრუნებს მთელ რიცხვს.
//ჩათვალეთ, რომ გადაცემული სტრინგი მხოლოდ ციფრებისგან შედგება და არ იწყება 0-ით.
//მაგალითად “234” გადაცემის შემთხვევაში მეთოდმა უნდა დააბრუნოს 234. ასევე ჩათვალეთ,
//რომ დაბრუნებული მნიშვნელობა დადებითია და ეტევა int-ში.

public class Problem49 extends ConsoleProgram {
	public void run() {
		int num = 0;
		String str = readNumberStr();

		for(int i = 0; i < str.length(); i++){
			char currCh = str.charAt(i);
			int currDigit = charToInt(currCh);
			num *= 10;
			num += currDigit;
		} 
		
		println("Num as an int: " + num);
		println("Num - 1: " + (num - 1));
		println("Num + 1: " + (num + 1));
	}

	private String readNumberStr(){
		String str = readLine("Enter num as String: ");
		while(!isOnlyDigits(str)){
			println("Not a valid number");
		}
		return str;
	}
	
	private boolean isOnlyDigits(String s){
		for(int  i = 0; i < s.length(); i++){
			if(!Character.isDigit(s.charAt(i))){
				return false;
			}
		}
		return true;
	}
	
//	char - '0' '1' '2' ... '9'
//	int -   0   1      ...  9
	private int charToInt(char digit){
		return digit - '0';
	}
	
}
