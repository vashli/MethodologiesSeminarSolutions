import acm.program.ConsoleProgram;

//30. მომხმარებელს შეყავს მთელი რიცხვი, დაბეჭდეთ რიცხვი რომელიც მიიღება ციფრების
//შებრუნებით, 1256 -> 6521
public class Problem30 extends ConsoleProgram{
	public void run(){
		int num = readInt("Enter num: ");
		int reversed = reverse(num);
		println(reversed);
	}

	private int reverse(int num) {
		int reversedNumber = 0;
		int lastDigit;
		
		while(num != 0){
			lastDigit = num % 10;
			println(lastDigit);
			num /= 10; // num = num / 10
			reversedNumber = reversedNumber * 10 + lastDigit;
		}
		return reversedNumber;
	}
}
