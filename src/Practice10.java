import acm.program.ConsoleProgram;
import acm.util.RandomGenerator;

//10. დაწერეთ მეთოდი, რომელსაც გადმოეცემა რიცხვი და აბრუნებს ამ რიცხვის
//კენტ ადგილას მყოფი ციფრთა ჯამი უდრის თუ არა ლუწ ადგილას მდგომ ციფრთა ჯამს.
//მაგ: 1232 -> true  1234 -> false
//Tags: Math, IntegerDigits

public class Practice10 extends ConsoleProgram {
	public void run() {
		while(true){
			int num = readInt("Enter number: ");
			println(isBeautifulNum(num));
		}
	}

	private boolean isBeautifulNum(int num) {
		// even and odd sums may not be saved in variables with right names, but it's okay
		int oddSum = 0;
		int evenSum = 0;
		while (num > 0){
			oddSum += num % 10;
			num /= 10;
			if(num > 0){
				evenSum += num % 10;
				num /= 10;
			}
		}
		return oddSum == evenSum;
	}
}
