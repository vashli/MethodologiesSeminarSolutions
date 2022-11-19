import acm.program.ConsoleProgram;

//12. დაწერეთ მეთოდი, რომელსაც არგუმენტად გადაეცემა რიცხვი n, და ციფრი k 2-დან 9-ის 
//ჩათვლით.  მეთოდი აბრუნებს n-ის k-ობითში გადაყვანის შედეგად მიღებული რიცხვის ციფრთა ჯამს
//(ციფრთა ჯამი დათვალეთ ჩვეულებრივ 10-ობითში)
//Input: n = 34, k = 6
//Output: 9
//Explanation: 34 (base 10) expressed in base 6 is 54(34 = … + 0 * 6^2 + 5 * 6^1 + 4 *6^0)  5 + 4 = 9.  


public class Practice12 extends ConsoleProgram {
	public void run() {
		while (true) {
			int n = readInt("Enter number: ");
			int k = readInt("Enter base: ");
			println(sumOfDigitsInBaseK(n, k));
		}
	}

	private int sumOfDigitsInBaseK(int n, int k) {
		int sum = 0; 
		while (n > 0) {
			int currDigit = (n % k);
			sum += currDigit;
			n /= k;
			print(currDigit); // prints num in base k but reversed
		}
		println(); // prints new line
		return sum;
	}

}
