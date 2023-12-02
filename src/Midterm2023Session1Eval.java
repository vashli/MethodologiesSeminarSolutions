//დაწერეთ eval მეთოდი, რომელსაც გადაეცემა სტრინგი, რომელიც წარმოადგენს
//მათემატიკური გამოსახულების ტექსტურ ჩანაწერს. ტექსტი შედგება მარტო
//დადებითი რიცხვებისგან, ' '(space), '+' და '-' სიმბოლოებისგან. მათემატიკური
//გამოსახულება ვალიდურია. იწყება რიცხვით, ყოველ რიცხვს(თუ იგი ბოლო
//არაა) მოსდევს სფეისი, სფეისს მათემატიკური ოპერატორი(+ ან -), ოპერატორს
//სფეისი და შემდეგ ახალი რიცხვი(შეიძლება გამოსახულება შედგებოდეს ბევრი
//წევრისგან). თქვენმა მეთოდმა უნდა დააბრუნოს რიცხვი, რომელიც არის ამ
//მათემატიკური გამოსახულების მნიშვნელობა. (ჩათვალეთ, რომ შედეგიც და
//თითოეული რიცხვიც, რომელიც ტექსტში გვხვდება int-ში ეტევა).
//მაგალითად
//1. თუკი eval მეთოდს გადაეცემა "1 + 2 - 10 + 1" მეთოდმა უნდა დააბრუნოს -6
//2. eval(“12”) აბრუნებს 12-ს
//3. eval(“123 - 123 + 22 - 0”) აბრუნებს 22-ს
//ამოხსნა დაწერეთ eval.java ფაილში
import java.util.StringTokenizer;

import acm.program.ConsoleProgram;

public class Midterm2023Session1Eval extends ConsoleProgram{
	public void run() {
		println(eval("1 + 2 - 10 + 1"));
		println(eval("12"));
		println(eval("123 - 123 + 22 - 0"));
	}
	
	private int eval(String expression) {
		StringTokenizer tokenizer = new StringTokenizer(expression);
		int res = 0;
		int sign = 1;
		while(tokenizer.hasMoreTokens()) {
			String token = tokenizer.nextToken();
			if(token.equals("+")) {
				sign = 1;
			}else if (token.equals("-")) {
				sign = -1;
			}else {
				int currNum = strToInt(token) * sign;
				res += currNum;
			}
		}
		return res;
	}

	// you can use Integer.parseInt() instead as well
	private int strToInt(String token) {
		int res = 0;
		for(int i = 0; i < token.length(); i++) {
			int digit = token.charAt(i) - '0';
			res = res * 10 + digit;
		}
		return res;
	}
}
