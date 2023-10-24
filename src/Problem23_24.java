//23. მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს 1 დან n მდე რიცხვების
//ჯამი
//24. მომხმარებელს შეყავს მთელი რიცხვი n, პროგრამამ უნდა დაბეჭდოს n ის გამყოფების
//რაოდენობა
import acm.program.ConsoleProgram;

public class Problem23_24 extends ConsoleProgram{
	public void run() {
		int num = readPositiveInt("Enter n: ");
		int sum  = calculateSum(num);
		println("Sum of numbers 1..n is: " + sum);
		
		int numDivisors = numberOfDivisors(num);
		println("Number of divisors is: " + numDivisors);
	}

	private int readPositiveInt(String text) {
		int n = readInt(text);
		while( n <= 0) {
			println("Number should positive");
			n = readInt(text);
		}
		return n;
	}
	
	private int calculateSum(int n) {
		int sum = 0;
		for(int i = 1; i <= n; i++) {
			sum += i; // sum = sum + i
		}
		return sum;	
	}
	
	private int numberOfDivisors(int n) {
		int num = 0;
		for(int i = 1; i <= n; i++) {		
			if (n % i == 0) { // % remainder
				num += 1;
			}
		}
		return num;
	}
}
