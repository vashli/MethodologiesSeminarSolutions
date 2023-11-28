//სტრინგი ბალანსირებულია თუკი მასში მხოლოდ ‘L' და ‘R’ სიმბოლოება და 
//მთაი რაოდენობა ერთნაირია. დაწერეთ მეთოდი რომელსაც გადაეცემა 
//ბალანსირებული სტრინგი და რომელიც აბრუნებს მაქსიმუმ რამდენ 
//ბალანსირებულ სტრინგად დაჭრა შეიძლება ამ სტრინგის. გაითვალისწინეთ, 
//რომ დაჭრის შედეგად მიღებული თითოეული სტრინგი ბალანსირებული უნდა იყოს. 
//ასევე გაითვალისწინეთ, რომ დაჭრილი სტრინგების შეწებებით თავდაპირველი სტრინგი 
//უნდა მიიღებოდეს.
//თქვენმა მეთოდმა უნდა დააბრუნოს ნაჭრების რაოდენობა.
//მაგალითად სტრინგი “LLLLRRRR” უფრო პატარა ბალანსირებულ ნაჭრებად ვერ დაიყოფა შესაბამისად თქვენმა მეთოდმა უნდა დააბრუნოს 1. 
//სტრინგი “LRLLRLRRRL” შეიძლება დაიჭრას ასე “LR”-“LLRLRR”-“RL”. უფრო მეტ დაბალანსებულ ნაჭრებად ვერ დაიჭრება შესაბამისად მეთოდმა უნდა დააბრუნოს 3.
//ხოლო სტრინგი “LRLRRL” შეიძლება დაიჭრას ასე “LR”-“LR” -”RL”. ანუ მეთოდმა უნდა დააბრუნოს 3.
//
//მეთოდი :
//private int balance(String text) დაწერეთ balance.java ფაილში
//public void run(){
//    int n = balance(“LLLRRR”);
//    println(n); // უნდა დაბეჭდოს 1
//}
//

import acm.program.ConsoleProgram;

public class Bonus16_2OldMidtermLR extends ConsoleProgram{
	public void run() {
		int n = balance("LLLRRR");
	    println(n); // უნდა დაბეჭდოს 1
		
		println(balance("LRLLRLRRRL")); //3
	    
	}

	private int balance(String text) {
		int lCount = 0;
		int rCount = 0;
		int res = 0;
		for(int i = 0; i < text.length(); i++) {
			char ch = text.charAt(i);
			if(ch == 'L') {
				lCount++;
			}else {
				rCount++;
			}
			if(lCount == rCount) {
				res++;
			}
		}
		return res;
	}
}
